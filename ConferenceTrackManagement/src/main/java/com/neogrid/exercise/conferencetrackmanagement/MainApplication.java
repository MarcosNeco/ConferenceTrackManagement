package com.neogrid.exercise.conferencetrackmanagement;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.neogrid.exercise.conferencetrackmanagement.converter.ConverterInTalks;
import com.neogrid.exercise.conferencetrackmanagement.reader.Reader;
import com.neogrid.exercise.conferencetrackmanagement.reader.ReaderFile;
import com.neogrid.exercise.conferencetrackmanagement.resources.PathResources;
import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class MainApplication {
	
	
	public static void main(String[] args) {
		try {
			File file = new File(PathResources.INPUT); 
			Reader reader = new ReaderFile(file);
			ConverterInTalks converterInTalks = new ConverterInTalks(reader);
			List<Talk> talks = converterInTalks.convert();
			Collections.sort(talks);
			for(Talk talk : talks){
				System.out.println("TITULO: "+ talk.getTitle() + "  " + "TEMPO:" + talk.getTime());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
