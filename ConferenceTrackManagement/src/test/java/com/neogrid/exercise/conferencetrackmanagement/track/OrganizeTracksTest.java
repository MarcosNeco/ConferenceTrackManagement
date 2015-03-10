package com.neogrid.exercise.conferencetrackmanagement.track;

import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.util.List;

import org.junit.Test;

import com.neogrid.exercise.conferencetrackmanagement.converter.ConverterInTalks;
import com.neogrid.exercise.conferencetrackmanagement.reader.Reader;
import com.neogrid.exercise.conferencetrackmanagement.reader.ReaderFile;
import com.neogrid.exercise.conferencetrackmanagement.resources.PathResources;
import com.neogrid.exercise.conferencetrackmanagement.talk.Talk;

public class OrganizeTracksTest {

	@Test
	public void testIfNotNull() throws Exception {
		File file = new File(PathResources.INPUT); 
		Reader reader = new ReaderFile(file);
		ConverterInTalks converterInTalks = new ConverterInTalks(reader);
		List<Talk> talks = converterInTalks.convert();
		OrganizingTracks organizingTracks = new OrganizingTracks(talks);
		List<Track> tracks = organizingTracks.organize();
		assertNotNull(tracks);
	}

}
