package com.mindcanary.domain.type;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.mindcanary.exceptions.EnumerationException;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum CountdownType {

	t1200(0, "1200"),
	t1500(1, "1500"),
	t1800(2, "1800"),
	t2100(3, "2100"),
	t2200(4, "2200"),
	t2300(5, "2300"),
	t0000(6, "0000");
	
	
	private final long id;
	private final String value;
	
	private CountdownType(long id, String value) {
		this.id = id;
		this.value = value;
	}
	
	public long getId() {
		return id;
	}
	
	public String getValue() {
		return value;
	}
	
	@JsonCreator
	public static CountdownType fromId(long id) {
		for (CountdownType type : CountdownType.values()) {
			if (type.id == id) {
				return type;
			}
		}
		throw new EnumerationException(id, CountdownType.class.getName());
	}
	
	public static CountdownType fromValue(String value) {
		for (CountdownType type : CountdownType.values()) {
			if (type.value == value) {
				return type;
			}
		}
		throw new EnumerationException(value, CountdownType.class.getName());
	}
}
