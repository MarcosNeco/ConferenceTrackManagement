package com.neogrid.exercise.conferencetrackmanagement.track;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class Track {
	
	private List<EventTrack> listTrackI = new ArrayList<EventTrack>();
	private Calendar hourTrack;
	
	public Track(){
		startEvent();
	}
	
	private void startEvent(){
		hourTrack = Calendar.getInstance();
		hourTrack.set(Calendar.HOUR, 9);
		hourTrack.set(Calendar.MINUTE, 0);
	}
	
	public boolean addTalk(Talk talk){
	  return add(new EventTrack(hourTrack, talk.getTitle()));
	}
	
	public void addLunch(){
		hourTrack.add(Calendar.MINUTE, 60);
		add(new EventTrack(hourTrack, "lunch"));
	}
	
	public void addNetworkEveting(){
		
		
	}
	
	private boolean add(EventTrack trackI){
		if(hourTrack.get(Calendar.MINUTE)+20 > 40)
			return false;
		
		listTrackI.add(trackI);
		return true;
	}
	
	public class EventTrack{
		private Calendar hour;
		private String title;
		
		public EventTrack(Calendar hour, String title) {
			this.hour = hour;
			this.title = title;
		}
		
		public Calendar getHour(){
			return hour;
		}
		
		public String getTitle(){
			return title;
		}
	}
	
}
