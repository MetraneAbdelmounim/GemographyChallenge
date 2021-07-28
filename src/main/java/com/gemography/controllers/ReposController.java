package com.gemography.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemography.services.ApiService;

@RestController()
public class ReposController {
	@Autowired
	private ApiService apiService;
	
	@GetMapping("api/v1/languages")
	
	private List<String> getLanguagesFromApi(){
	
		return apiService.getLanguages(); 
	}
	

}
