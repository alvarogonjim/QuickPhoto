package aiss.model.resources;

import java.io.IOException;

import org.restlet.data.Form;
import org.restlet.data.Header;
import org.restlet.engine.header.HeaderConstants;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;
import org.restlet.util.Series;

import quickphoto.model.ImageUrl;

public class TinyPngResources {

	
	private String uri = "http://api.tinify.com";
	private String key = "ZbGbVDVmQHjZSFcDRLPcmUBMI29bQTCC";
	
	public TinyPngResources() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ImageUrl comprimirFotoByUrl(ImageUrl imageUrl){

		
		ClientResource cr = null;
		ImageUrl  res = null;
		
		try {
		
			cr = new ClientResource(uri+"/shrink");
			Series<Header> headers  = (Series<Header>)cr.getRequestAttributes().get("org.restlet.http.headers");
			headers.set(HeaderConstants.HEADER_AUTHORIZATION, key);
			//headers.set(HeaderConstants.HEADER_AUTHORIZATION, key);
			
			//Headers es null --> null pointer exception.
			
			cr.setEntityBuffering(true);
			res = cr.post(imageUrl, ImageUrl.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when post the image: " + cr.getResponse().getStatus());
			throw re;
		}
		
		return res;
	}
		
	
	}
	
	
