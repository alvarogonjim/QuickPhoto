
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
@JsonPropertyOrder({ "source" })
public class ImageUrl {

	@JsonProperty("source")
	private Source source;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public ImageUrl() {
	}

	/**
	 * 
	 * @param source
	 */
	public ImageUrl(Source source) {
		super();
		this.source = source;
	}

	@JsonProperty("source")
	public Source getSource() {
		return source;
	}

	@JsonProperty("source")
	public void setSource(Source source) {
		this.source = source;
	}

	public ImageUrl withSource(Source source) {
		this.source = source;
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

	public ImageUrl withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "ImageUrl [source=" + source + ", additionalProperties=" + additionalProperties + "]";
	}

}