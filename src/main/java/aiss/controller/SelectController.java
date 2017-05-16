package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.HelloWorldServlet;
import aiss.model.google.drive.FileItem;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class SelectController extends HttpServlet {
	private static final Logger log = Logger.getLogger(SelectController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
		if(accessToken!=null && !"".equals(accessToken)){
			GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
			Files files=gdResource.getFiles();
			String h = "";
			for(FileItem f : files.getItems())
			{
				if(f.getMimeType().contains("image/")){
					h = f.toString();
					break;
				}
			}
			if(files!=null){
				req.setAttribute("files", files);
				req.setAttribute("string0", h); //borrar
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
}
