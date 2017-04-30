package aiss.controller;

import java.io.IOException;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.HelloWorldServlet;
import aiss.model.google.drive.Files;
import aiss.model.resources.GoogleDriveResource;

public class UploadController extends HttpServlet {
	private static final Logger log = Logger.getLogger(UploadController.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {

				req.getRequestDispatcher("/upload.jsp").forward(req,resp);
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req,resp);
	}
}
