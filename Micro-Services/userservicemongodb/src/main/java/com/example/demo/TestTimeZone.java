package com.example.demo;

import java.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

public class TestTimeZone {

	public static void main(String[] args) {
		
		   DateTime dt = new DateTime();
		   // translate to London local time
		   DateTime dtLondon = dt.withZone(DateTimeZone.forID("-06:00"));
		   System.out.println("time "+dtLondon +" time zone  "+dtLondon.getZone().toTimeZone().getDisplayName());
		   
		
		
	}

}
