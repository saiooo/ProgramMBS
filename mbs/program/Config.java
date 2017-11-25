package mbs.program;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan("mbs.program")
public class Config {
	
	@Bean
	@Value("src/mbs/resources")
	public FileReader fileReader(String path) {
		return new FileReader(path);
	}
	
	@Bean
	public FileWritter fileWritter() { 
		return new FileWritter();
	}
}
