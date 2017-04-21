package com.krishnan.balaji.practice.util;

import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
@Converter()
public class LocalDateConverter implements AttributeConverter<LocalDate, Date>{

	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) {
		return (attribute == null ? null :  Date.valueOf(attribute));
	}

	@Override
	public LocalDate convertToEntityAttribute(Date dbDate) {
		return (dbDate == null ?  null : dbDate.toLocalDate());
	}

}
