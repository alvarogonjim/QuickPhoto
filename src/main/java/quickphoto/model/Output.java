package quickphoto.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Output implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer size;
	private String type;
	private Integer width;
	private Integer height;
	private Double ratio;
	private String url;

	public Integer getSize() {
	return size;
	}

	public void setSize(Integer size) {
	this.size = size;
	}

	public String getType() {
	return type;
	}

	public void setType(String type) {
	this.type = type;
	}

	public Integer getWidth() {
	return width;
	}

	public void setWidth(Integer width) {
	this.width = width;
	}

	public Integer getHeight() {
	return height;
	}

	public void setHeight(Integer height) {
	this.height = height;
	}

	public Double getRatio() {
	return ratio;
	}

	public void setRatio(Double ratio) {
	this.ratio = ratio;
	}

	public String getUrl() {
	return url;
	}

	public void setUrl(String url) {
	this.url = url;
	}
}