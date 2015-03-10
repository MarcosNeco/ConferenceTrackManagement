package com.neogrid.exercise.conferencetrackmanagement.track;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class OrganizingTracks {
	
	private List<Talk>talks;
	private List<Track> tracks;
	private int countTime = 0;
	private int TIME_LUNCH = 180;
	private int TIME_NETWORK_EVENTING = 450;
	
	
	public OrganizingTracks(List<Talk> talks) {
		this.talks = talks;
		tracks = new ArrayList<Track>();
	}
	
	public List<Track> organize(){
		sortDescTalksByTime();
		Track track  = new Track();
		for(Talk talk : talks){
			addTalk(talk, track);
			
			if(countTime == TIME_LUNCH)
				addLunch(track);
			if(countTime == TIME_NETWORK_EVENTING){
				addNetworkingEvent(track);
				tracks.add(track);
				track = track2();
			}
		}
		return tracks;
	}
	
	private void addNetworkingEvent(Track track) {
		track.addNetworkEveting();
	}

	private void addLunch(Track track) {
		sumCountTime(60);
		track.addLunch();
	}
	
	private Track track2() {
		TIME_NETWORK_EVENTING = 455;
		countTime=0;
		return new Track();
	}

	private void addTalk(Talk talk, Track track){
		sumCountTime(talk.getTime());
		track.addTalk(talk);
	}

	private void sumCountTime(int value){
		countTime += value;
	}

	private void sortDescTalksByTime(){
		Collections.sort(talks);
	}
	
}
