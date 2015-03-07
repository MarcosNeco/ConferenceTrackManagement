package com.neogrid.exercise.conferencetrackmanagement.reader;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ReaderFileTest {
	
	private File pathFile;
	
	@Before
	public void before(){
		pathFile =new File(getClass().getResource("/file_to_test_reader_file.txt").getPath());
	}
	
	@Test 
	public void testFileIsNotNull(){
		assertNotNull(getClass().getResource("/file_to_test_reader_file.txt"));
	}
	
	@Test
	public void testNumberLines() throws IOException {
		ReaderFile readerFile = new ReaderFile(pathFile);
		assertEquals(5, readerFile.getLines().size());
	}
	
	@Test
	public void testValueFirstLine() throws IOException{
		ReaderFile readerFile = new ReaderFile(pathFile);
		String firstLine = readerFile.getLines().get(0);
		assertEquals("first test", firstLine);
	}
	
	@Test
	public void testValueLastLine() throws IOException{
		ReaderFile readerFile = new ReaderFile(pathFile);
		String lastLine = readerFile.getLines().get(4);
		assertEquals("final test", lastLine);
	}
	
	@Test(expected=IOException.class)
	public void testFailFileNotExist() throws IOException{
		ReaderFile readerFile = new ReaderFile(new File("/file_not_exist"));
		assertNotNull(readerFile);
	}
}
