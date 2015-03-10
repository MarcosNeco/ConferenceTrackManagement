package com.neogrid.exercise.conferencetrackmanagement.track;

import java.util.List;

import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class OrganizingTracks {
	
	private List<Talk>talks;
	private List<Track> tracks;
	
	public OrganizingTracks(List<Talk> talks) {
		this.talks = talks;
	}
	
	public List<Track> organize(){
		return tracks;
	}
	
	
}
