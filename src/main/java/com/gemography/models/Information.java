package com.gemography.models;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter@Setter
@NoArgsConstructor
@ToString
public class Information {
	
	private String Language ; 
	private int numberOfRepos ;
	private List<Repos> items;
	public Information(String language, int numberOfRepos, List<Repos> items) {
		super();
		Language = language;
		this.numberOfRepos = numberOfRepos;
		this.items = items;
	}

}
