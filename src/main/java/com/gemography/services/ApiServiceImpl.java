package com.gemography.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.gemography.models.Repos;
import com.gemography.models.Response;

@Service
public class ApiServiceImpl implements ApiService{
	private RestTemplate restTemplate = new RestTemplate();
	@Value("${github.api}")
	private String apiUrl;

	@Override
	public List<String> getLanguages() {
		
		String fullApiUrl= apiUrl+getCorrectDay();
		ResponseEntity<Response> response
		  = restTemplate.getForEntity(fullApiUrl, Response.class);
		
		return removeDuplicateLang(response.getBody().getItems());
		
	}
	
	private String getCorrectDay() {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -30);
        SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
        Date resultDate = new Date(calendar.getTimeInMillis());
        String date = formatDate.format(resultDate);
        return date;
	}
	
	private List<String> removeDuplicateLang(List<Repos> items){
		Set<String> langSet = new HashSet<String>();
		
		for(Repos lang : items) {
			String currentlang = lang.getLanguage();
			if(!langSet.contains(currentlang) && currentlang!=null) {
				langSet.add(currentlang);
			}
		}
		List<String> arrayLanguages = new ArrayList<String>();
		arrayLanguages.addAll(langSet);
		return arrayLanguages;
	}
}
