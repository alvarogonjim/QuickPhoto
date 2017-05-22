package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.Files;
import aiss.model.google.drive.about.About;
import aiss.model.resources.GoogleDriveResource;

public class DriveFileDelete extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				
				//About user
				About a = gdResource.getAbout();
				req.setAttribute("a_name", a.getName());
				req.setAttribute("a_avatar", a.getUser().getPicture().getUrl());
				req.setAttribute("a_bytesTotal", a.getQuotaBytesTotal());
				req.setAttribute("a_bytesUsed", a.getQuotaBytesUsedAggregate());
				//
				
				gdResource.deleteFile(id);
				log.info("File with id '"+id+"' deleted!");
				req.getRequestDispatcher("/select").forward(req,resp);
			}else{
				log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for delete!");
			req.getRequestDispatcher("/select").forward(req,resp);
		}
	}
}
