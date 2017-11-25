package mbs.program;


import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class FileWritter {
	private Map<String, Integer> words;
	private File file;
	private BufferedWriter writer;
	
	public FileWritter() {
		words = new TreeMap<String, Integer>();
	}
	
	public void appendMap(String word){
		if(words.containsKey(word)){
			words.put(word, words.get(word) + 1);
		}
		else{
			words.put(word, 1);
		}
	}
	
	
	private String identifyChar(char c) {
		if(c >= 'a' && c <= 'g'){
			return "src/mbs/results/result1.txt";
		}
		
		else if(c >= 'h' && c <= 'n') {
			return "src/mbs/results/result2.txt";
		}
		
		else if(c >= 'o' && c <= 'u'){
			return "src/mbs/results/result3.txt";
		}
		
		else {
			return "src/mbs/results/result4.txt";
		}
	}
	
	
	public void writeToFiles() {
			for (Map.Entry<String, Integer> entry : words.entrySet()) {
				try {
					
					String pathToFile = identifyChar(entry.getKey().toLowerCase().charAt(0));
					System.out.println(pathToFile);
					file = new File(pathToFile);
					writer = new BufferedWriter(new java.io.FileWriter(file, true));
					writer.write(entry.getKey() + " - " + entry.getValue());
					writer.newLine();
					writer.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		
	}
	
	public String printMap(){
		return words.toString();
	}
	
}
