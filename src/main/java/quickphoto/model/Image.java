package quickphoto.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Image implements Serializable{


/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Input input;
private Output output;

public Input getInput() {
return input;
}

public void setInput(Input input) {
this.input = input;
}

public Output getOutput() {
return output;
}

public void setOutput(Output output) {
this.output = output;
}

	}
	
