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

public class UploadController extends HttpServlet {
	private static final Logger log = Logger.getLogger(UploadController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
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
				req.getRequestDispatcher("/upload.jsp").forward(req,resp);
		} else {
			log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
			req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
		}
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}
