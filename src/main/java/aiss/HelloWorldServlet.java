package aiss;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.resources.TinyPngResources;
import quickphoto.model.Image;
import quickphoto.model.ImageUrl;
import quickphoto.model.Source;

public class HelloWorldServlet extends HttpServlet {
	
	private static final Logger log = Logger.getLogger(HelloWorldServlet.class.getName());
	    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// Create image
		String url = "http://www.lavozdegalicia.es/sc/x/default/2015/04/21/00121429642982387753453/Foto/efe_20150421_180454102.jpg";
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
