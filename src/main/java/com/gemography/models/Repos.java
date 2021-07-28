package com.gemography.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Setter@Getter
@NoArgsConstructor
public class Repos {
	
	private long id ;
	private String name;
	private String full_Name ;
	private String url;
	private String language;
	
	public Repos(long id, String name, String full_Name, String url, String language) {
		super();
		this.id = id;
		this.name = name;
		this.full_Name = full_Name;
		this.url = url;
		this.language = language;
	}
	

}
