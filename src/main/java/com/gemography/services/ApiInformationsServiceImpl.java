package com.gemography.services;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gemography.models.Information;
import com.gemography.models.Repos;
import com.gemography.models.Response;

@Service
public class ApiInformationsServiceImpl implements ApiInformationsService{
	@Autowired
	private DateService dateService;
	
	private RestTemplate restTemplate = new RestTemplate();
	@Value("${github.api}")
	private String apiUrl;

	@Override
	public Information getInformationForEveryLang(String language) {

		String fullApiUrl= apiUrl+dateService.getCorrectDay();
		//get the body response from api of github
		ResponseEntity<Response> response
		  = restTemplate.getForEntity(fullApiUrl, Response.class);
		
		
		return getInformations(response.getBody().getItems(),language);
	}
	
	private Information getInformations(List<Repos> repos,String language){
		
		Information result = new Information();
		result.setItems(new ArrayList<Repos>());
		result.setLanguage(language);
		result.setNumberOfRepos(0);
	
		for(Repos item : repos) {
			String currentLang=item.getLanguage();
			if(currentLang!=null && currentLang.equals(language)) {
				result.setNumberOfRepos(result.getNumberOfRepos()+1);
				List<Repos> currentRespos = result.getItems();
				currentRespos.add(item);
				result.setItems(currentRespos);
			}
		}

		return result;
	}
	
}
