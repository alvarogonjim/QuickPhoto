package aiss.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.about.About;
import aiss.model.resources.GoogleDriveResource;
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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Create image
		String id = request.getParameter("id");
		String url = request.getParameter("img2compress");
		System.out.println("URL : " + url);
		Source s = new Source(url);

		TinyPngResources tiny = new TinyPngResources();
		Image im = tiny.comprimirFotoByUrl(new ImageUrl(s));
		response.setStatus(HttpServletResponse.SC_OK);
		log.log(Level.FINE, "Processing GET request");

		String accessToken = (String) request.getSession().getAttribute("GoogleDrive-token");
		if (accessToken != null && !"".equals(accessToken)) {
			GoogleDriveResource gdResource = new GoogleDriveResource(accessToken);

			// About user
			About a = gdResource.getAbout();
			request.setAttribute("a_name", a.getName());
			request.setAttribute("a_avatar", a.getUser().getPicture());
			request.setAttribute("a_bytesTotal", a.getQuotaBytesTotal());
			request.setAttribute("a_bytesUsed", a.getQuotaBytesUsedAggregate());
			//

		} else {
			log.info("The files returned are null... probably your token has experied. Redirecting to OAuth servlet.");
			request.getRequestDispatcher("/AuthController/GoogleDrive").forward(request, response);
		}

		request.setAttribute("inputURL", url);
		request.setAttribute("output", im.getOutput());
		request.setAttribute("input", im.getInput());
		request.getRequestDispatcher("/compressResult.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
