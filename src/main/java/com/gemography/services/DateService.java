package com.gemography.services;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DateService {
	@Value("${lastdays}")
	private int days;
	
	@Value("${date.format}")
	private String format; 
	
	public String getCorrectDay() {
		Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DAY_OF_YEAR, -days);
        SimpleDateFormat formatDate = new SimpleDateFormat(format);
        Date resultDate = new Date(calendar.getTimeInMillis());
        String date = formatDate.format(resultDate);
        return date;
	}
	
}
