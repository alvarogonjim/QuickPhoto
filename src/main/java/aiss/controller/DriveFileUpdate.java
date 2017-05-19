package aiss.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.logging.Logger;

import javax.annotation.processing.Filer;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import aiss.model.google.drive.FileItem;
import aiss.model.resources.GoogleDriveResource;

public class DriveFileUpdate extends HttpServlet {
	private static final Logger log = Logger.getLogger(DriveFileDelete.class.getName());

	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		String url=req.getParameter("url");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				java.net.URL urlO = new java.net.URL(url);
				java.io.File fileR = null;
//				
//				try {
//					//fileR = java.nio.file.Paths.get(urlO.toURI()).toFile();
//				} catch (URISyntaxException e) {
//					e.printStackTrace();
//				}

				FileItem file=gdResource.getFile(id);				
				req.setAttribute("file", file);
			//	byte[] array = Files.readAllBytes(fileR.toPath());
				String str = "";
				System.out.println("str: " + str);
				req.setAttribute("content", str);
				req.getRequestDispatcher("/compressList").forward(req,resp);
			}else{
				log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for update!");
			req.getRequestDispatcher("/compressList").forward(req,resp);
		}
	}
	
	
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String id=req.getParameter("id");
		if(id!=null && !"".equals(id)){
			String accessToken=(String)req.getSession().getAttribute("GoogleDrive-token");
			String str = "\u2030PNG\r\n\u001A\r\n   \r\nIHDR   \f   \u000E\b\u0002   \u201D\u00DFj\u00BB   \u0001sRGB \u00AE\u00CE\u001C\u00E9   \u0004gAMA  \u00B1\u008F\u000B\u00FCa\u0005   \tpHYs  \u000E\u00C3  \u000E\u00C3\u0001\u00C7o\u00A8d   UIDAT(S\u008D\u2039\u00C1\u0011\u00C0 \f\u00C3\u00D8\u00E94\u00B5]'4<\u00D0\u0192\u00C3B\u00AC k\u2021\u00D2T\u00F4;;[D\u00CEQ\u00DA\u00DB\u00A8\u00C37\u00A3\u02C6\u0192\u00DCFF\u00C6\u2013\u00BBc\u00FF\u00B5\u00A7(\u00A9\b\u001F\u00AA\u00F6=\u00E1TDE\u00E6\u0014\u0012`\u00CE\u0017- \u0005\u00A9\u00DBd\u00A6\u0011\u00F1 \u00F9\r\nB\u00CC]aN\u0010    IEND\u00AEB`\u201A";
			String content=req.getParameter("content");
			if(accessToken!=null && !"".equals(accessToken)){
				GoogleDriveResource gdResource=new GoogleDriveResource(accessToken);
				gdResource.updateFileContent(id, str);
				req.getRequestDispatcher("/compressList").forward(req,resp);
			}else{
				log.info("Trying to acces to google drive without an acces token, redirecting to OAuth servlet");
				req.getRequestDispatcher("/AuthController/GoogleDrive").forward(req,resp);
			}
		}else{
			log.warning("Invalid id for update!");
			req.getRequestDispatcher("/compressList").forward(req,resp);
		}
	}
}
