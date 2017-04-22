package com.krishnan.balaji.practice.util;

import java.time.Duration;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter
public class DurationConverter implements AttributeConverter<Duration, Long> {

	@Override
	public Long convertToDatabaseColumn(Duration arg0) {
		return (arg0 ==null ? 0 : arg0.toMinutes());
	}

	@Override
	public Duration convertToEntityAttribute(Long arg0) {
		return (arg0 == null ? Duration.ofMinutes(0) : Duration.ofMinutes(arg0));
	}

}
