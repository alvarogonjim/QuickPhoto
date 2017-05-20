package aiss.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.google.drive.Parent;
import aiss.model.resources.GoogleDriveResource;

public class CompressListController extends HttpServlet {
	private static final Logger log = Logger.getLogger(SelectController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
		if(accessToken!=null && !"".equals(accessToken)){
			GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
			
			Files files_0 = gdResource.getFiles(); //Files 
			List<FileItem> files = new ArrayList<FileItem>(); //Array para rellenar y enviar al jsp

			String QPfolderID = createFolder("QuickPhoto", gdResource);
			System.out.println("FOLDER ID: " + QPfolderID);
			for(FileItem i : files_0.getItems())
				for(Parent pa : i.getParents())
					if(pa.getId().equals(QPfolderID))
						files.add(i);

			if(files!=null){
				req.setAttribute("files", files);
				req.getRequestDispatcher("/compressList.jsp").forward(req,resp);
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

	public String createFolder(String folderName, GoogleDriveResource gdResource)
	{
		List<String> ids = gdResource.getFiles().getFoldersIdByName(folderName);
		int sameName = ids.size();
		String res = "";
		if(sameName > 1)
			log.warning("There are " + sameName + " folders with title: '" + folderName +"'. There should only be one.");
		else if(sameName == 0) {
			FileItem file = new FileItem();
			file.setTitle(folderName);
			file.setMimeType("application/vnd.google-apps.folder");
			String newId = gdResource.insertFile(file, "");
			gdResource.updatePermissions(newId);
			log.info("Folder: '" + folderName +"' created and shared succesfully.");
		} else {
			res = ids.get(0);
		}
		
		return res;
	}
}
