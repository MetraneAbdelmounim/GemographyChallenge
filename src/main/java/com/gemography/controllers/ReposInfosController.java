package com.gemography.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gemography.models.Information;
import com.gemography.services.ApiInformationsService;

@RestController()
public class ReposInfosController {
	@Autowired
	private ApiInformationsService apiInfoService;
	
	@GetMapping("api/v1/informations")
	private List<Information> getInformationForEveryLanguage(){
		return apiInfoService.getInformationForEveryLang();
	}
}
