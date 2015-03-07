package com.neogrid.exercise.conferencetrackmanagement.reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderFile implements Reader {
	
	private File file;
	private List<String> lines = new ArrayList<String>();
	
	public ReaderFile(File file) throws IOException {
	    this.file = file;
		readLines();
	}
	
	public void readLines() throws IOException{
		BufferedReader fileReader = new BufferedReader(new FileReader(file));
		while(fileReader.ready()){
			String line = fileReader.readLine();
			this.lines.add(line);
		}
		fileReader.close();
	}
	
	public List<String> getLines() {
		return this.lines;
	}

}
