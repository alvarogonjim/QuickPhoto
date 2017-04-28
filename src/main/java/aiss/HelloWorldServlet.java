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
		Source s = new Source("http://contratodeobras.com/images/fondo-azul-jpg.jpg");
		TinyPngResources tiny = new TinyPngResources();
		Image im = tiny.comprimirFotoByUrl(new ImageUrl(s));
		response.setStatus(HttpServletResponse.SC_OK);
		System.out.println(im);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
