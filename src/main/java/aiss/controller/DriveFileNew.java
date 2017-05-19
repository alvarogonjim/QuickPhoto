package aiss.controller;

import java.io.IOException;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jboss.resteasy.util.Base64;

import aiss.model.google.drive.FileItem;
import aiss.model.resources.GoogleDriveResource;

public class DriveFileNew extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {	
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			String title= "quick22355.jpg";
			String content=req.getParameter("bytes");	
//			for(Object entry : req.getParameterMap().keySet()){
//			String n = (String) entry;
//			System.out.println(n);
//			}
			System.out.println("Content1:" + content.split(";")[1].split(",")[1]);
			byte[] con = Base64.decode(content.split(";")[1].split(",")[1]);
			
			if(accessToken!=null && !"".equals(accessToken)){
				if(title!=null && !"".equals(title)){
					GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
					FileItem file = new FileItem();
					file.setTitle(title);
					System.out.println("Content2:" + content);
					file.setMimeType("image/jpg");
					gdResource.insertFile(file, con);
					req.setAttribute("message", "File '"+title+"' added to your Drive!");
					req.getRequestDispatcher("/googleDriveListing").forward(req,resp);
				}else{
					req.setAttribute("message", "You must provide a valid title for file");
					req.setAttribute("content", content);
					req.getRequestDispatcher("EditFile.jsp").forward(req,resp);
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
