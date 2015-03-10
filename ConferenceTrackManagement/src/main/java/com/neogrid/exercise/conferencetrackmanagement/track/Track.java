package com.neogrid.exercise.conferencetrackmanagement.track;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class Track {
	
	private List<EventTrack> eventsTrack = new ArrayList<EventTrack>();
	private Calendar trackClock;
	private static final int NOT_DEFINED = 0;
	
	public Track(){
		startEvent();
	}
	
	private void startEvent(){
		trackClock = Calendar.getInstance();
		trackClock.set(trackClock.get(Calendar.YEAR), trackClock.get(Calendar.MONTH), trackClock.get(Calendar.DATE), 9 , 0 );
	}
	
	public boolean addTalk(Talk talk){
		return add(talk.getTime() , talk.getTitle());
	}
	
	public boolean addLunch(){
		return add(60, "Lunch");
	}
	
	public boolean addNetworkEveting(){
		return add(NOT_DEFINED, "Networking Event");
	}
	
	public List<EventTrack> getEventsTrack() {
		return eventsTrack;
	}
	
	private boolean add(int minute, String title){
		if(overSeventeenHours(minute))
			return false;
		
		eventsTrack.add(new EventTrack(trackClock.get(Calendar.HOUR_OF_DAY), trackClock.get(Calendar.MINUTE), title));
		trackClock.add(Calendar.MINUTE, minute);
		return true;
	}
	
	private boolean overSeventeenHours(int minute){ 
		Calendar hour = Calendar.getInstance();
		hour.set(trackClock.get(Calendar.YEAR), trackClock.get(Calendar.MONTH), trackClock.get(Calendar.DATE), 17 , 0 );
	   long difference = hour.getTimeInMillis() - (trackClock.getTimeInMillis() + TimeUnit.MINUTES.toMillis(minute)) ;
		return difference < 0; 
	}


	public class EventTrack{
		private int hour;
		private int minute;
		private String title;
		
		public EventTrack(int hour, int minute , String title) {
			this.hour = hour;
			this.minute = minute;
			this.title = title;
		}
		
		public int getHour(){
			return hour;
		}
		
		public int getMinute() {
			return minute;
		}
		
		public String getTitle(){
			return title;
		}
	}
	
}
