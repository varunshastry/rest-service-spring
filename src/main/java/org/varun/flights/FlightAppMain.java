package org.varun.flights;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FlightAppMain {
    private static final Logger logger = LogManager.getLogger(FlightAppMain.class);

    public static void main(String[] args) {
        SpringApplication.run(FlightAppMain.class, args);
        logger.info("Application up and running. Ready to serve!");
    }
}
