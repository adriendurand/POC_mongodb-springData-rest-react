package com.adrien.poc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main class of the application
 */
@SpringBootApplication
public class Application implements CommandLineRunner {

	// The logger of the class
	private final Logger logger = LoggerFactory.getLogger(Application.class);

	/**
	 * Main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(Application.class);
		app.setShowBanner(false);
		app.run(args);
	}

	/**
	 * Method call from the main method but not in a static way
	 */
	public void run(String... args) throws Exception {
		logger.debug("Main");
	}
}
