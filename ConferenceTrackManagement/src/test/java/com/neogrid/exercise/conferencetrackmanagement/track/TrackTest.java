package com.neogrid.exercise.conferencetrackmanagement.track;

import static org.junit.Assert.*;

import org.junit.Test;

import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class TrackTest {

	@Test
	public void testAddAfterSeventeenHours() {
		Track track = new Track();
		
		Talk talk1 = new Talk("talk1", 180);
		Talk talk2 = new Talk("talk2", 245);
		
		track.addTalk(talk1);
		track.addLunch();
		assertFalse(track.addTalk(talk2));
	
	}
	
	@Test
	public void testLeastSeventeenHours(){
		Track track = new Track();
		
		Talk talk1 = new Talk("talk1", 180);
		Talk talk2 = new Talk("talk2", 240);
		
		track.addTalk(talk1);
		track.addLunch();
		assertTrue(track.addTalk(talk2));
	}
	
	@Test
	public void testEventsTrack(){
		Track track = new Track();
		
		Talk talk1 = new Talk("talk1", 180);
		Talk talk2 = new Talk("talk2", 240);
		
		track.addTalk(talk1);
		track.addLunch();
		track.addTalk(talk2);
		
		assertEquals("talk1", track.getEventsTrack().get(0).getTitle());
		assertEquals(9, track.getEventsTrack().get(0).getHour());
		assertEquals(0, track.getEventsTrack().get(0).getMinute());
		
		assertEquals("Lunch", track.getEventsTrack().get(1).getTitle());
		assertEquals(12, track.getEventsTrack().get(1).getHour());
		assertEquals(0, track.getEventsTrack().get(1).getMinute());
		
		assertEquals("talk2", track.getEventsTrack().get(2).getTitle());
		assertEquals(13, track.getEventsTrack().get(2).getHour());
		assertEquals(0, track.getEventsTrack().get(2).getMinute());
	}
}
