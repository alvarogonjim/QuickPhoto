package quickphoto.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown=true)
public class Input implements Serializable{

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private Integer size;
private String type;

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
}
