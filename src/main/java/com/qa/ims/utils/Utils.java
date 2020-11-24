package com.qa.ims.utils;

import java.util.Scanner;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {
	private static Logger LOGGER = LogManager.getLogger();

	private final Scanner scanner;

	public Utils(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public Utils() {
		scanner = new Scanner(System.in);
	}

	// Uses the scanner to get a Long and returns it
	public Long getLong() {

		Long longInput = null;
		do {
			try {		
				String input = getString();
				longInput = Long.parseLong(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (longInput == null);
		return longInput;
	}

	// getInt function for the scanner to use.
	public int getInt() {

		int intInput = 0;
		do {
			try {		
				String input = getString();
				intInput = Integer.parseInt(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (intInput == 0);
		return intInput;
	}
	
	// Uses the scanner to get a String and returns it
	public String getString() {
		return scanner.nextLine();
	}

	// Uses the scanner to get a Double and returns it
	public Double getDouble() {
		
		Double doubleInput = null;
		do {
			try {
				String input = getString();
				doubleInput = Double.parseDouble(input);
			} catch (NumberFormatException nfe) {
				LOGGER.info("Error - Please enter a number");
			}
		} while (doubleInput == null);
		return doubleInput;
	}

}
