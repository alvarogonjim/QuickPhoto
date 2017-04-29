package quickphoto.model;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "size", "type", "width", "height", "ratio", "url" })
public class Output {

	@JsonProperty("size")
	private Integer size;
	@JsonProperty("type")
	private String type;
	@JsonProperty("width")
	private Integer width;
	@JsonProperty("height")
	private Integer height;
	@JsonProperty("ratio")
	private Double ratio;
	@JsonProperty("url")
	private String url;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Output() {
	}

	/**
	 * 
	 * @param height
	 * @param ratio
	 * @param width
	 * @param type
	 * @param url
	 * @param size
	 */
	public Output(Integer size, String type, Integer width, Integer height, Double ratio, String url) {
		super();
		this.size = size;
		this.type = type;
		this.width = width;
		this.height = height;
		this.ratio = ratio;
		this.url = url;
	}

	@JsonProperty("size")
	public Integer getSize() {
		return size;
	}

	@JsonProperty("size")
	public void setSize(Integer size) {
		this.size = size;
	}

	public Output withSize(Integer size) {
		this.size = size;
		return this;
	}

	@JsonProperty("type")
	public String getType() {
		return type;
	}

	@JsonProperty("type")
	public void setType(String type) {
		this.type = type;
	}

	public Output withType(String type) {
		this.type = type;
		return this;
	}

	@JsonProperty("width")
	public Integer getWidth() {
		return width;
	}

	@JsonProperty("width")
	public void setWidth(Integer width) {
		this.width = width;
	}

	public Output withWidth(Integer width) {
		this.width = width;
		return this;
	}

	@JsonProperty("height")
	public Integer getHeight() {
		return height;
	}

	@JsonProperty("height")
	public void setHeight(Integer height) {
		this.height = height;
	}

	public Output withHeight(Integer height) {
		this.height = height;
		return this;
	}

	@JsonProperty("ratio")
	public Double getRatio() {
		return ratio;
	}

	@JsonProperty("ratio")
	public void setRatio(Double ratio) {
		this.ratio = ratio;
	}

	public Output withRatio(Double ratio) {
		this.ratio = ratio;
		return this;
	}

	@JsonProperty("url")
	public String getUrl() {
		return url;
	}

	@JsonProperty("url")
	public void setUrl(String url) {
		this.url = url;
	}

	public Output withUrl(String url) {
		this.url = url;
		return this;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Output withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Output [size=" + size + ", type=" + type + ", width=" + width + ", height=" + height + ", ratio="
				+ ratio + ", url=" + url + ", additionalProperties=" + additionalProperties + "]";
	}

}
