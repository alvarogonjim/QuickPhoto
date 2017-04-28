package quickphoto.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Source implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String url;

	public Source(String url) {
		this.url = url;
	}
	
	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}
	
	
}
