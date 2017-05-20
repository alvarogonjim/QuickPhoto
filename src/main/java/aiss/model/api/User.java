package aiss.model.api;

import org.codehaus.jackson.annotate.JsonProperty;

import com.fasterxml.jackson.annotation.JsonCreator;

public class User {

	private String id;
	private String name;
	private String surName;
	private String email;

//
//	@JsonCreator
//	public User(@JsonProperty("id") String id,
//			@JsonProperty("name") String name, 
//			@JsonProperty("surName") String surName, 
//			@JsonProperty("email") String email) {
//		this.id = id;
//		this.name = name;
//		this.surName = surName;
//		this.email = email;
//	}


	@JsonCreator
	public User(@JsonProperty("name")String name, 
			@JsonProperty("surName")String surName, 
			@JsonProperty("email")String email) {
		this.name = name;
		this.surName = surName;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurName() {
		return surName;
	}

	public void setSurName(String surName) {
		this.surName = surName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
