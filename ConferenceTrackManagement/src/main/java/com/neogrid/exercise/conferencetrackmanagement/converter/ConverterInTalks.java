package com.neogrid.exercise.conferencetrackmanagement.converter;

import java.util.ArrayList;
import java.util.List;

import com.neogrid.exercise.conferencetrackmanagement.reader.Reader;
import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class ConverterInTalks {
	
	private Reader reader;
	private List<Talk> talks;
	
	public ConverterInTalks(Reader reader){
		this.reader = reader;
		talks = new ArrayList<Talk>();
	}
	
	public List<Talk> convert() throws Exception{
		for(String line : reader.getLines()){
			String lastWord = line.substring(line.lastIndexOf(" ")+1);
			int time = extractTimeLastWord(lastWord); 
			Talk talk = new Talk(line, time);
			talks.add(talk);
		}
		return talks;
	}
	
	private int extractTimeLastWord(String lastWord) throws Exception{
		if(lastWord.contains("lightning"))
			return 5;
		
		if(!lastWord.matches(".*\\d.*"))
			throw new Exception("file format invalid");
		
       return Integer.valueOf(lastWord.replaceAll("\\D+", ""));
	}
}
