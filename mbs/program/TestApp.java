package mbs.program;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestApp {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext context = 
				new AnnotationConfigApplicationContext(Config.class);

		
		FileReader reader = (FileReader) context.getBean("fileReader");
		FileWritter writer = (FileWritter) context.getBean("fileWritter");
		
		reader.readFile();
		writer.writeToFiles();
		
		context.close();

	}

}
