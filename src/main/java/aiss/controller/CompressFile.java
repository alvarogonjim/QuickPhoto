package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TinyPngResources;
import quickphoto.model.Image;
import quickphoto.model.ImageUrl;
import quickphoto.model.Source;

public class CompressFile extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5104372551543923390L;
	private static final Logger log = Logger.getLogger(CompressFile.class.getName());
	    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Create image
		String url = request.getParameter("img2compress");
		System.out.println("URL : " + url);
		Source s = new Source(url);
		
		TinyPngResources tiny = new TinyPngResources();
		Image im = tiny.comprimirFotoByUrl(new ImageUrl(s));
		response.setStatus(HttpServletResponse.SC_OK);
		log.log(Level.FINE, "Processing GET request");

		response.getWriter().println("<b>INPUT:</b><br><img src=\""+ url +"\"/>");
		response.getWriter().println("Propertiers: " + im.getInput());
		response.getWriter().println("\n\n<b>OUTPUT:</b><br><img src=\"" + im.getOutput().getUrl() + "\"/>");
		response.getWriter().println("Propertiers: " + im.getOutput());
		/*Enviarla para subirla
		request.getRequestDispatcher("/GoogleDriveFileNew").forward(request,response);*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
