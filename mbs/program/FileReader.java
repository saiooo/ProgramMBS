package mbs.program;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;



public class FileReader {
	private File folder;
	private File[] files;
	private BufferedReader reader;
	@Autowired
	private FileWritter writer;
	
	
	
	public FileReader(String path) {
		folder = new File(path);
		files = folder.listFiles();
	}
	
	
	/*public void run() {

		System.out.println("File reading thread " + getName() + " is runnning...");
		readFile();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getArray();
	}*/
	
	
	public void readFile() {
		String txt = "";
		
		for(File file : files) {
			if(file.getName().startsWith("txt")) {
				try {
					reader = new BufferedReader(new java.io.FileReader(file));
					String currentLine = "";
							
					while((currentLine = reader.readLine()) != null) {
						writer.appendMap(currentLine);
					}
					
					
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		}
		
			
	}	
	
	

}
