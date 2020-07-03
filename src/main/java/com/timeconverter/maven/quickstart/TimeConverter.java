package com.timeconverter.maven.quickstart;

import java.io.IOException;
import java.util.Scanner;

public class TimeConverter {
	private String orignalTime;

	public TimeConverter() {
		
	}

	public TimeConverter(String timeIn12HourFormat) {
		this.orignalTime = timeIn12HourFormat;
	}

	public static void main(String[] args) throws IOException {
		Scanner ip = new Scanner(System.in);
		String input = "";

		while(!input.equals("q")) {
		   System.out.println("Please input time to convert: ");
		   input = ip.next();

		   if (!input.equals("q")) {
			   TimeConverter converter = new TimeConverter(input);
				String output = converter.convertTimeTo24HourFormat();
				System.out.println("Output: " + output);
		  }
		}

		System.out.println("Program Exited");
	}

	public String convertTimeTo24HourFormat() {
		if (isValidInput(this.orignalTime)) {
			String last_character = getLastCharacter(this.orignalTime);
			String after_colon = getAfterColonString(this.orignalTime);
			String before_colon = getBeforeColonString(this.orignalTime);

			return get24HourString(before_colon, after_colon, last_character);
		} else {
			return "Not a valid 12 hour format time";
		}
	}

	public boolean isValidInput(String input) {
		if (input.length() < 4 && input.length() <8) {
			return false;
		}

		String last_character = getLastCharacter(input);
		if (!(last_character.contains("am") || last_character.contains("pm"))) {
			return false;
		}

		if (!input.contains(":")) {
			return false;
		}

		try {
			String before_colon = getBeforeColonString(input);
			int before_value = Integer.parseInt(before_colon);
			if (before_value > 12) {
				return false;
			}
		} catch (Exception ex) {
			return false;
		}

		try {
			String after_colon = getAfterColonString(input);
			int after_value = Integer.parseInt(after_colon);
			if(after_value > 60)
			{
				return false;
			}
		} catch (Exception ex) {
			return false;
		}

		return true;
	}

	public String getLastCharacter(String input) {
		String last_character = "";
		last_character = input.substring(input.length()-2, input.length());
		return last_character;
	}

	public String getAfterColonString(String input) {
		String after_colon = "";
		after_colon = input.substring(input.indexOf(":") + 1, input.length()-2);
		return after_colon;
	}

	public String getBeforeColonString(String input) {
		String before_colon = "";
		before_colon = input.substring(0, input.indexOf(":"));
		return before_colon;
	}

	public String get24HourString(String before_colon, String after_colon, String last_character) {
		String output = "";

		int intValue = Integer.parseInt(before_colon);
		if (last_character.equals("am") && intValue < 12) {
			output = before_colon + ":" + after_colon;
		} else if (last_character.equals("am") && intValue == 12) {
			output = "00" + ":" + after_colon;
		} else {
		int a = intValue + 12;
			output = a + ":" + after_colon;
		}

		return output;
	}
}
