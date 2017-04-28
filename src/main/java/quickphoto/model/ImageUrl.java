package quickphoto.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class ImageUrl implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Source source;

	public ImageUrl(Source source) {
		this.source = source;
	}

	public Source getSource() {
	return source;
	}

	public void setSource(Source source) {
	this.source = source;
	}

	}
	
