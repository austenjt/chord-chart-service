package org.jazz.chart;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@CommonsLog
public class Application
{
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
