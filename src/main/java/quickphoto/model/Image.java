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
@JsonPropertyOrder({ "input", "output" })
public class Image {

	@JsonProperty("input")
	private Input input;
	@JsonProperty("output")
	private Output output;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	/**
	 * No args constructor for use in serialization
	 * 
	 */
	public Image() {
	}

	/**
	 * 
	 * @param input
	 * @param output
	 */
	public Image(Input input, Output output) {
		super();
		this.input = input;
		this.output = output;
	}

	@JsonProperty("input")
	public Input getInput() {
		return input;
	}

	@JsonProperty("input")
	public void setInput(Input input) {
		this.input = input;
	}

	public Image withInput(Input input) {
		this.input = input;
		return this;
	}

	@JsonProperty("output")
	public Output getOutput() {
		return output;
	}

	@JsonProperty("output")
	public void setOutput(Output output) {
		this.output = output;
	}

	public Image withOutput(Output output) {
		this.output = output;
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

	public Image withAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
		return this;
	}

	@Override
	public String toString() {
		return "Image [input=" + input + ", output=" + output + ", additionalProperties=" + additionalProperties + "]";
	}

}