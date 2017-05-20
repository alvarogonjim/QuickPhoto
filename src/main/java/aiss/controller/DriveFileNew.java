package aiss.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.util.Base64;

import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class DriveFileNew extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {	
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				String files_0 = gdResource.getFiles().getItems().get(0).getId();
				String parentId = createFolder("QuickPhoto", gdResource);
				gdResource.moveFile(files_0, parentId);
				req.getRequestDispatcher("/select").forward(req,resp);
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
