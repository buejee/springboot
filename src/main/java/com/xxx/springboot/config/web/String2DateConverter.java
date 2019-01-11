package com.xxx.springboot.config.web;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.springframework.core.convert.converter.Converter;
public class String2DateConverter implements Converter<String, Date> {
	private static DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	@Override
	public Date convert(String source) {
		Date date = null;
		try {
			date = format.parse(source);
		} catch (ParseException e) {
			date = new Date();
		}
		return date;
	}
}
