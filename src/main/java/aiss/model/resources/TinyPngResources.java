package aiss.model.resources;

import org.restlet.data.ChallengeScheme;
import org.restlet.data.MediaType;
import org.restlet.resource.ClientResource;
import org.restlet.resource.ResourceException;

import quickphoto.model.Image;
import quickphoto.model.ImageUrl;

public class TinyPngResources {

	private String uri = "https://api.tinify.com/shrink";
	//private String key = "Basic YXBpOlpiR2JWRFZtUUhqWlNGY0RSTFBjbVVCTUkyOWJRVEND";

	public TinyPngResources() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Image comprimirFotoByUrl(ImageUrl imageUrl) {
		ClientResource cr = null;
		Image res = null;
		try {
			
			cr = new ClientResource(uri);
			cr.setChallengeResponse(ChallengeScheme.HTTP_BASIC, "api", "TgnCl8WyG2HX4euUM3brbNN8LsQ7m9JO");
			cr.accept(MediaType.APPLICATION_JSON);
			cr.setEntityBuffering(true);
			res = cr.post(imageUrl, Image.class);
			
		} catch (ResourceException re) {
			System.err.println("Error when post the image: " + cr.getResponse().getStatus());
			throw re;
		}

		return res;
	}

}
