package com.gemography.services;

import java.util.List;

import com.gemography.models.Information;

public interface ApiInformationsService {
	public Information getInformationForEveryLang(String language);
}
