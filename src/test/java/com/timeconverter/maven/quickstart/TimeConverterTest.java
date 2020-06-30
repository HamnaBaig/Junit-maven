package com.timeconverter.maven.quickstart;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class TimeConverterTest {

	@Test
	public void incorrectFormatTest() {
		TimeConverter converter = new TimeConverter("11:");
		String actualResult = converter.convertTimeTo24HourFormat();
		Assert.assertEquals("Not a valid 12 hour format time", actualResult);
	}

	@Test
	public void checkLastCharacter() {
		TimeConverter converter = new TimeConverter();
		String actualResult = converter.getLastCharacter("11:00am");
		Assert.assertEquals("am", actualResult);
	}

	
	@Test 
	public void getAfterColonString()
	{
		TimeConverter converter = new TimeConverter();
		String actualResult = converter.getAfterColonString("11:00am");
		Assert.assertEquals("00", actualResult);
	}
	@Test 
	public void getbeforeColonString()
	{
		TimeConverter converter = new TimeConverter();
		String actualResult = converter.getBeforeColonString("11:00am");
		Assert.assertEquals("11", actualResult);
	}
	
		@Test
		public void get24HourString()
				{
		TimeConverter converter = new TimeConverter();
		String actualResult = converter.get24HourString("11","30","pm");
		Assert.assertEquals("23:30", actualResult);
		
				}
		@Test
		public void verifyamresult()
				{
		TimeConverter converter = new TimeConverter();
		String actualResult = converter.get24HourString("11","30","am");
		Assert.assertEquals("11:30", actualResult);
		
				}
		@Test
		public void verifyequalam()
				{
		TimeConverter converter = new TimeConverter();
		String actualResult = converter.get24HourString("12","00","am");
		Assert.assertEquals("00:00", actualResult);
		
				}
		@Test
		public void invalidvalueaftercolon() 
		{
			TimeConverter converter = new TimeConverter();
			
			boolean actualResult = converter.isValidInput("11:00am");
			Assert.assertEquals(true, actualResult);
			
		}
		@Test
		public void verifylastcharacter()
		{
			TimeConverter converter = new TimeConverter();
			boolean actualResult = converter.isValidInput("11:00");
			Assert.assertEquals(false, actualResult);
		}
			@Test
			public void verifywithcolon()
			{
				TimeConverter converter = new TimeConverter();
				boolean actualResult = converter.isValidInput("11:00am");
				Assert.assertEquals(true, actualResult);
			}

@Test
public void verifycolon()
{
	TimeConverter converter = new TimeConverter();
	boolean actualResult = converter.isValidInput("1100am");
	Assert.assertEquals(false, actualResult);

		
			
		
}
}
