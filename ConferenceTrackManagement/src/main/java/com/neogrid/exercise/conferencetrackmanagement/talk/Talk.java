package com.neogrid.exercise.conferencetrackmanagement.talk;


public class Talk implements Comparable<Talk>{
	
	private String title;
	private int time;
	
	public Talk(String title, int timeInMinutes) {
		this.title = title;
		this.time = timeInMinutes;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	
	public int compareTo(Talk otherTalk) {
	    return  otherTalk.getTime() - this.time;
	}

}
