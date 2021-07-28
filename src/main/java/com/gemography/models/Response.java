package com.gemography.models;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@JsonIgnoreProperties(ignoreUnknown = true)
@Setter@Getter
@NoArgsConstructor
public class Response {
	
	 @JsonInclude()
	private List<Repos> items;

	public Response(List<Repos> items) {
		super();
		this.items = items;
	}
	 
	 
}
