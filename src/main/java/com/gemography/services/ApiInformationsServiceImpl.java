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
	public List<Information> getInformationForEveryLang() {
		List<Information> results = new ArrayList<Information>();
		Map<String, Information> map = new  HashMap<String, Information>();
		String fullApiUrl= apiUrl+dateService.getCorrectDay();
		
		ResponseEntity<Response> response
		  = restTemplate.getForEntity(fullApiUrl, Response.class);
		
		
		return getInformations(response.getBody().getItems());
	}
	
	private List<Information> getInformations(List<Repos> repos){
		
		List<Information> results = new ArrayList<Information>();
		Map<String, Information> map = new  HashMap<String, Information>();
		for(Repos item : repos) {
			String currentLang=item.getLanguage();
			if(!map.containsKey(item.getLanguage())){
				ArrayList<Repos> items = new ArrayList<Repos>();
				items.add(item);
				map.put(item.getLanguage(), new Information(item.getLanguage(), 1 ,items ) );
			}
			else {
				Information currentInformation = map.get(currentLang);
				int numberOfrepoCurrent = currentInformation.getNumberOfRepos();
				currentInformation.setNumberOfRepos(numberOfrepoCurrent+1);
				List<Repos> currentRepos = currentInformation.getItems();
				currentRepos.add(item);
				currentInformation.setItems(currentRepos);
				map.replace(currentLang,currentInformation);
			}
		}
		results.addAll(map.values());
		return results;
	}
	
}
