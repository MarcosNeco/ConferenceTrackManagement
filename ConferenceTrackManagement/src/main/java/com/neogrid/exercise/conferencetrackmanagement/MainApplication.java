package com.neogrid.exercise.conferencetrackmanagement;

import java.io.File;
import java.io.IOException;
import java.util.List;

import com.neogrid.exercise.conferencetrackmanagement.converter.ConverterInTalks;
import com.neogrid.exercise.conferencetrackmanagement.reader.Reader;
import com.neogrid.exercise.conferencetrackmanagement.reader.ReaderFile;
import com.neogrid.exercise.conferencetrackmanagement.resources.PathResources;
import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;
import com.neogrid.exercise.conferencetrackmanagement.track.OrganizingTracks;
import com.neogrid.exercise.conferencetrackmanagement.track.Track;
import com.neogrid.exercise.conferencetrackmanagement.track.Track.EventTrack;

public class MainApplication {
	
	
	public static void main(String[] args) {
		try {
			File file = new File(PathResources.INPUT); 
			Reader reader = new ReaderFile(file);
			ConverterInTalks converterInTalks = new ConverterInTalks(reader);
			List<Talk> talks = converterInTalks.convert();
			OrganizingTracks organizingTracks = new OrganizingTracks(talks);
			List<Track> tracks = organizingTracks.organize();
			printInScreen(tracks);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void printInScreen(List<Track> tracks){
		for(int i = 0; i < tracks.size() ;i++){
			Track track = tracks.get(i);
			System.out.println("\n\ntrack: - " + i + "\n\n");
			List<EventTrack> eventTracks = track.getEventsTrack();
			for(EventTrack eventTrack : eventTracks){
				System.out.println(eventTrack.getHour()+":"+eventTrack.getMinute()+ " - " + eventTrack.getTitle());
			}
		}
	}
}
