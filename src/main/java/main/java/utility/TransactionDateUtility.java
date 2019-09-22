package main.java.utility;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TransactionDateUtility {

	static final String transationDateFormat = "dd/MM/yyyy HH:mm:ss";
	
	public static Date getDateFromString(String date) throws ParseException {
		return new SimpleDateFormat(TransactionDateUtility.transationDateFormat).parse(date);
	}
	
	public static String getStringFromDate(Date date) throws ParseException {
		DateFormat df = new SimpleDateFormat(TransactionDateUtility.transationDateFormat);
		String todayAsString = df.format(date);
		return todayAsString;
	}
}
