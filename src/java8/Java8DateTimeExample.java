package java8;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author NAYANK
 *
 *In old days, we use the following classic Date and Calendar APIs to represent and manipulate date.

java.util.Date – date and time, print with default time-zone.
java.util.Calendar – date and time, more methods to manipulate date.
java.text.SimpleDateFormat – formatting (date -> text), parsing (text -> date) for date and calendar.

In Java 8, a new series of date and time APIs (JSR310 and inspired by Joda-time) are created in the new java.time package.

java.time.LocalDate – date without time, no time-zone.
java.time.LocalTime – time without date, no time-zone.
java.time.LocalDateTime – date and time, no time-zone.
java.time.ZonedDateTime – date and time, with time-zone.
java.time.DateTimeFormatter – formatting (date -> text), parsing (text -> date) for java.time
java.time.Instant – date and time for machine, seconds passed since the Unix epoch time (midnight of January 1, 1970 UTC)
java.time.Duration – Measures time in seconds and nanoseconds.
java.time.Period – Measures time in years, months and days.
java.time.TemporalAdjuster – Adjust date.
 */

public class Java8DateTimeExample {

	public static void main(String[] args) throws ParseException, InterruptedException {
		//Convert Date to String.

		SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
		String date = sdf.format(new Date()); 
		System.out.println(date); //15/10/2013

		//Convert String to Date.
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString = "31-08-1982 10:20:56";
		Date date1 = sdf1.parse(dateInString);
		System.out.println(date1); //Tue Aug 31 10:20:56 SGT 1982


		//Get current date time
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date2 = new Date();
		System.out.println(dateFormat.format(date2)); //2013/10/15 16:16:39

		// Convert Calendar to Date
		Calendar calendar = Calendar.getInstance();
		Date date3 =  calendar.getTime();
		System.out.println(dateFormat.format(date3));


		//2. Java Calendar Examples
		//Get current date time
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Calendar calendar1 = new GregorianCalendar(2013,0,31);
		System.out.println(sdf2.format(calendar1.getTime()));


		// Simple Calendar example
		SimpleDateFormat sdf4 = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");	
		Calendar calendar2 = new GregorianCalendar(2013,1,28,13,24,56);

		int year       = calendar2.get(Calendar.YEAR);
		int month      = calendar2.get(Calendar.MONTH); // Jan = 0, dec = 11
		int dayOfMonth = calendar2.get(Calendar.DAY_OF_MONTH); 
		int dayOfWeek  = calendar2.get(Calendar.DAY_OF_WEEK);
		int weekOfYear = calendar2.get(Calendar.WEEK_OF_YEAR);
		int weekOfMonth= calendar2.get(Calendar.WEEK_OF_MONTH);

		int hour       = calendar2.get(Calendar.HOUR);        // 12 hour clock
		int hourOfDay  = calendar2.get(Calendar.HOUR_OF_DAY); // 24 hour clock
		int minute     = calendar2.get(Calendar.MINUTE);
		int second     = calendar2.get(Calendar.SECOND);
		int millisecond= calendar2.get(Calendar.MILLISECOND);

		System.out.println(sdf4.format(calendar.getTime()));

		System.out.println("year \t\t: " + year);
		System.out.println("month \t\t: " + month);
		System.out.println("dayOfMonth \t: " + dayOfMonth);
		System.out.println("dayOfWeek \t: " + dayOfWeek);
		System.out.println("weekOfYear \t: " + weekOfYear);
		System.out.println("weekOfMonth \t: " + weekOfMonth);

		System.out.println("hour \t\t: " + hour);
		System.out.println("hourOfDay \t: " + hourOfDay);
		System.out.println("minute \t\t: " + minute);
		System.out.println("second \t\t: " + second);
		System.out.println("millisecond \t: " + millisecond);

		System.out.println("#1. " + sdf4.format(calendar2.getTime()));
		//update a date
		calendar2.set(Calendar.YEAR, 2014);
		calendar2.set(Calendar.MONTH, 11);
		calendar2.set(Calendar.MINUTE, 33);
		System.out.println("#2. " + sdf4.format(calendar2.getTime()));


		//Convert Date to Calendar.
		SimpleDateFormat sdf5 = new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
		String dateInString1 = "22-01-2015 10:20:56";
		Date date5 = sdf5.parse(dateInString);

		Calendar calendar5 = Calendar.getInstance();
		calendar.setTime(date5);




		compareDates();
		getCurrentDate();
		convertStringToDate();
		calculateElapsedTime();
		convertStringToLocalDate();
		formatLocalDate();
		instantExample();
		convertDateToLocalDate();
		durationAndPeriod();
		
		addDaysToDate();
	}

	private static void addDaysToDate() {
		Date currentDate = new Date();
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(currentDate));
        
        Calendar c = Calendar.getInstance();
        c.setTime(currentDate);
        
        c.add(Calendar.YEAR, 1);
        c.add(Calendar.MONTH, 1);
        c.add(Calendar.DATE, 1); //same with c.add(Calendar.DAY_OF_MONTH, 1);
        c.add(Calendar.HOUR, 1);
        c.add(Calendar.MINUTE, 1);
        c.add(Calendar.SECOND, 1);
        
        Date currentDatePlusOne = c.getTime();
        System.out.println(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(currentDatePlusOne));
        
	}

	private static void durationAndPeriod() {
		Duration oneHours = Duration.ofHours(1);
        System.out.println(oneHours.getSeconds() + " seconds");
        Duration oneHours2 = Duration.of(1, ChronoUnit.HOURS);
        System.out.println(oneHours2.getSeconds() + " seconds");
     // Test Duration.between
        System.out.println("\n--- Duration.between --- ");

        LocalDateTime oldDate = LocalDateTime.of(2016, Month.AUGUST, 31, 10, 20, 55);
        LocalDateTime newDate = LocalDateTime.of(2016, Month.NOVEMBER, 9, 10, 21, 56);

        System.out.println(oldDate);
        System.out.println(newDate);

        //count seconds between dates
        Duration duration = Duration.between(oldDate, newDate);

        System.out.println(duration.getSeconds() + " seconds");

        Period tenDays = Period.ofDays(10); 
        System.out.println(tenDays.getDays()); //10

        Period oneYearTwoMonthsThreeDays = Period.of(1, 2, 3);
        System.out.println(oneYearTwoMonthsThreeDays.getYears());   //1
        System.out.println(oneYearTwoMonthsThreeDays.getMonths());  //2
        System.out.println(oneYearTwoMonthsThreeDays.getDays());    //3
        
        
        System.out.println("\n--- Period.between --- ");
        LocalDate oldDate1 = LocalDate.of(1982, Month.AUGUST, 31);
        LocalDate newDate1 = LocalDate.of(2016, Month.NOVEMBER, 9);

        System.out.println(oldDate1);
        System.out.println(newDate1);

        // check period between dates
        Period period = Period.between(oldDate1, newDate1);

        System.out.print(period.getYears() + " years,");
        System.out.print(period.getMonths() + " months,");
        System.out.print(period.getDays() + " days");
        
        long years = ChronoUnit.YEARS.between(oldDate1, newDate1);
        
        System.out.println(years + " years");
	}

	private static void convertDateToLocalDate() {
		/*
		 * 	Date -> Instant + System default time zone = LocalDate
			Date -> Instant + System default time zone = LocalDateTime
			Date -> Instant + System default time zone = ZonedDateTime
		 */
		
		//Asia/Kuala_Lumpur +8
        ZoneId defaultZoneId = ZoneId.systemDefault();
        System.out.println("System Default TimeZone : " + defaultZoneId);
        
        //toString() append +8 automatically.
        Date date = new Date();
        System.out.println("date : " + date);
        
        //1. Convert Date -> Instant
        Instant instant = date.toInstant();
        System.out.println("instant : " + instant); //Zone : UTC+0

        //2. Instant + system default time zone + toLocalDate() = LocalDate
        LocalDate localDate = instant.atZone(defaultZoneId).toLocalDate();
        System.out.println("localDate : " + localDate);

        //3. Instant + system default time zone + toLocalDateTime() = LocalDateTime
        LocalDateTime localDateTime = instant.atZone(defaultZoneId).toLocalDateTime();
        System.out.println("localDateTime : " + localDateTime);

        //4. Instant + system default time zone = ZonedDateTime
        ZonedDateTime zonedDateTime = instant.atZone(defaultZoneId);
        System.out.println("zonedDateTime : " + zonedDateTime);

	}

	private static void instantExample() {
		Instant instant = Instant.now();
		System.out.println("Instant : " + instant);
		LocalDateTime ldt = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);
		System.out.println("LocalDateTime : " + ldt);


		ZonedDateTime jpTime = instant.atZone(ZoneId.of("Asia/Tokyo"));
		System.out.println("ZonedDateTime : " + jpTime);
		System.out.println("OffSet : " + jpTime.getOffset());
	}

	private static void formatLocalDate() {
		LocalDateTime now = LocalDateTime.now();
		System.out.println("Before : " + now);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		String formatDateTime = now.format(formatter);
		System.out.println("After : " + formatDateTime);
	}

	private static void convertStringToLocalDate() {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
		String date = "16/08/2016";
		LocalDate localDate = LocalDate.parse(date, formatter);
		System.out.println("localDate:"+localDate);
	}

	private static void calculateElapsedTime() throws InterruptedException {
		long lStartTime = System.nanoTime();
		int i=0;
		Thread.sleep(100);
		long lEndTime = System.nanoTime();
		long output = lEndTime - lStartTime;
		System.out.println("Elapsed time in milliseconds: " + output / 1000000);

		long lStartTime1 = System.currentTimeMillis();
		TimeUnit.SECONDS.sleep(1);
		long lEndTime1 = System.currentTimeMillis();
		System.out.println("Elapsed time in milliseconds: " + (lEndTime1-lStartTime1) );


		System.out.println("epoch instant:"+Instant.now().toEpochMilli());

		System.out.println("Date.gettime:"+new Date().getTime());
	}

	private static void convertStringToDate() throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateInString = "7-Jun-2013";

		Date date = formatter.parse(dateInString);
		System.out.println(date);
		System.out.println(formatter.format(date));
	}

	private static void getCurrentDate() {

		DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

		Date date = new Date();
		System.out.println(sdf.format(date));

		Calendar cal = Calendar.getInstance();
		System.out.println(sdf.format(cal.getTime()));

		LocalDateTime now = LocalDateTime.now();
		System.out.println(dtf.format(now));

		LocalDate localDate = LocalDate.now();
		System.out.println(DateTimeFormatter.ofPattern("yyy/MM/dd").format(localDate));


		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		System.out.println(timestamp);

		Date date1 = new Date();
		System.out.println(new Timestamp(date1.getTime()));
		System.out.println(timestamp.getTime());
		System.out.println(sdf.format(timestamp));


		//2. java.time.Instant




	}

	private static void compareDates() throws ParseException {


		//1. Date.compareTo()
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date1 = sdf.parse("2009-12-31");
		Date date2 = sdf.parse("2010-01-31");

		System.out.println("date1 : " + sdf.format(date1));
		System.out.println("date2 : " + sdf.format(date2));

		if (date1.compareTo(date2) > 0) {
			System.out.println("Date1 is after Date2");
		} else if (date1.compareTo(date2) < 0) {
			System.out.println("Date1 is before Date2");
		} else if (date1.compareTo(date2) == 0) {
			System.out.println("Date1 is equal to Date2");
		} else {
			System.out.println("How to get here?");
		}


		//2. Date.before(), Date.after() and Date.equals()

		if (date1.after(date2)) {
			System.out.println("Date1 is after Date2");
		}

		if (date1.before(date2)) {
			System.out.println("Date1 is before Date2");
		}

		if (date1.equals(date2)) {
			System.out.println("Date1 is equal Date2");
		}

		//3. Calender.before(), Calender.after() and Calender.equals()
		Calendar cal1 = Calendar.getInstance();
		Calendar cal2 = Calendar.getInstance();
		cal1.setTime(date1);
		cal2.setTime(date2);

		if (cal1.after(cal2)) {
			System.out.println("Date1 is after Date2");
		}

		if (cal1.before(cal2)) {
			System.out.println("Date1 is before Date2");
		}

		if (cal1.equals(cal2)) {
			System.out.println("Date1 is equal Date2");
		}


		// 4. Java 8  java.time.LocalDate

		DateTimeFormatter sdf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate date11 = LocalDate.of(2009, 12, 31);
		LocalDate date21 = LocalDate.of(2010, 01, 31);

		System.out.println("date1 : " + sdf1.format(date11));
		System.out.println("date2 : " + sdf1.format(date21));

		System.out.println("Is...");
		if (date11.isAfter(date21)) {
			System.out.println("Date1 is after Date2");
		}

		if (date11.isBefore(date21)) {
			System.out.println("Date1 is before Date2");
		}

		if (date11.isEqual(date21)) {
			System.out.println("Date1 is equal Date2");
		}

		System.out.println("CompareTo...");
		if (date11.compareTo(date21) > 0) {

			System.out.println("Date1 is after Date2");

		} else if (date11.compareTo(date21) < 0) {

			System.out.println("Date1 is before Date2");

		} else if (date11.compareTo(date21) == 0) {

			System.out.println("Date1 is equal to Date2");

		} else {

			System.out.println("How to get here?");

		}

	}

}
