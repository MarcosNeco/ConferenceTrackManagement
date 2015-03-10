package com.neogrid.exercise.conferencetrackmanagement.creator;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import com.neogrid.exercise.conferencetrackmanagement.converter.ConverterInTalks;
import com.neogrid.exercise.conferencetrackmanagement.reader.Reader;
import com.neogrid.exercise.conferencetrackmanagement.reader.ReaderFile;
import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class CreatorTalksTest {
	 
	public Reader readerFile;
	public static final int INDEX_WALK_LIGHTNING= 3;
	
	@Before
	public void before() throws IOException{
		File file = new  File(getClass().getResource("/file_to_test_creator_talk.txt").getPath());;
		readerFile = new ReaderFile(file);
	}

	@Test
	public void testFirstTalkIsCorrect() throws Exception {
		ConverterInTalks creatorTalks = new ConverterInTalks(readerFile);
		Talk firstTalk = creatorTalks.convert().get(0);
		assertEquals(firstTalk.getTitle(), "work with maven ");
		assertEquals(firstTalk.getTime(), 20);
	}
	
	@Test
	public void testSecondTalkIsCorrect() throws Exception {
		ConverterInTalks creatorTalks = new ConverterInTalks(readerFile);
		Talk firstTalk = creatorTalks.convert().get(1);
		assertEquals(firstTalk.getTitle(), "learning sql ");
		assertEquals(firstTalk.getTime(), 60);
	}
	
	@Test
	public void testThirdTalkIsCorrect() throws Exception {
		ConverterInTalks creatorTalks = new ConverterInTalks(readerFile);
		Talk firstTalk = creatorTalks.convert().get(2);
		assertEquals(firstTalk.getTitle(), "implements application hadoop ");
		assertEquals(firstTalk.getTime(), 50);
	}
	
	@Test
	public void testTalkLightning() throws Exception{
		ConverterInTalks creatorTalks = new ConverterInTalks(readerFile);
		Talk firstTalk = creatorTalks.convert().get(INDEX_WALK_LIGHTNING);
		assertEquals(firstTalk.getTime(), 5);
	}

}
