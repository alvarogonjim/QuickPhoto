package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.HelloWorldServlet;
import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.google.drive.Parent;
import aiss.model.resources.GoogleDriveResource;

public class SelectController extends HttpServlet {
	private static final Logger log = Logger.getLogger(SelectController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
		if(accessToken!=null && !"".equals(accessToken)){
			GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
			
			
			Files files_0 = gdResource.getFiles(); //Files 
			List<String> foldersId = files_0.getFoldersIdByName("alvarogay"); //Lista de IDs con el nombre QuickPhoto
			List<FileItem> files = new ArrayList<FileItem>(); //Array para rellenar y enviar al jsp
			Parent p = new Parent();
			
			 System.out.println("size foldersID: " + foldersId.size() );
			if(foldersId.size() >= 1)
			{
			String quickPhotoIDFolder = foldersId.get(0);
			for(FileItem i : files_0.getItems()) //para todo elemento
				for(Parent papa : i.getParents())
					if(papa.getId().equals(quickPhotoIDFolder)) //que tenga un padre/carpeta con la id quickPhotoIDFolder
						files.add(i); //lo unico que se me ocurre es obtenerlo asi, 
			
			//crucemos los dedos, el segundo seria lo suyo
			} else {
			System.out.println("TO DO: crear carpeta QuickPhoto con share=true");
			}
				
			
			
			
			if(files!=null){
				req.setAttribute("files", files);
				req.getRequestDispatcher("/select.jsp").forward(req,resp);
			}else{
				log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
	
	 private static void printFilesInFolder(Drive service, String folderId)
		      throws IOException {
		    Children.List request = service.children().list(folderId);

		    do {
		      try {
		        ChildList children = request.execute();

		        for (ChildReference child : children.getItems()) {
		          System.out.println("File Id: " + child.getId());
		        }
		        request.setPageToken(children.getNextPageToken());
		      } catch (IOException e) {
		        System.out.println("An error occurred: " + e);
		        request.setPageToken(null);
		      }
		    } while (request.getPageToken() != null &&
		             request.getPageToken().length() > 0);
		  }
}
