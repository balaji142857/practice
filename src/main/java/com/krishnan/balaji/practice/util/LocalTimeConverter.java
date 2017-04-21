package com.krishnan.balaji.practice.util;

import java.sql.Time;
import java.time.LocalTime;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class LocalTimeConverter implements AttributeConverter<LocalTime, Time> {

	@Override
	public Time convertToDatabaseColumn(LocalTime attribute) {
		return (attribute== null ? null : Time.valueOf(attribute));
	}

	@Override
	public LocalTime convertToEntityAttribute(Time dbData) {
		return dbData.toLocalTime();
	}

}
