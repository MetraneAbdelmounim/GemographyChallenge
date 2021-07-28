package com.gemography.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gemography.models.Information;
import com.gemography.models.Repos;
import com.gemography.models.Response;

@Service
public class ApiServiceImpl implements ApiService{
	@Autowired
	private DateService dateService;
	
	private RestTemplate restTemplate = new RestTemplate();
	@Value("${github.api}")
	private String apiUrl;

	@Override
	public List<String> getLanguages() {
		
		String fullApiUrl= apiUrl+dateService.getCorrectDay();
		//get response from api of github
		ResponseEntity<Response> response
		  = restTemplate.getForEntity(fullApiUrl, Response.class);
		
		return removeDuplicateLang(response.getBody().getItems());
		
	}
	
	private List<String> removeDuplicateLang(List<Repos> items){
		//i'm using map to reduce the complexity of searching languages
		Set<String> langSet = new HashSet<String>();
		
		for(Repos lang : items) {
			String currentlang = lang.getLanguage();
			//remove duplicate language
			if(!langSet.contains(currentlang) && currentlang!=null) {
				langSet.add(currentlang);
			}
		}
		//convert set to array list
		List<String> arrayLanguages = new ArrayList<String>();
		arrayLanguages.addAll(langSet);
		return arrayLanguages;
	}

}
