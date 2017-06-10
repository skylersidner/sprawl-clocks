package com.mindcanary.domain.type;

import com.mindcanary.exceptions.EnumerationException;

public enum RealmType {

	CORPORATE(0, "Corporate"),
	THREAT(1, "Threat");
	
	private final long id;
	private final String name;
	
	private RealmType(long id, String name) {
		this.id = id;
		this.name = name;
	}
	
	public long getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public static RealmType fromId(long id) {
		for (RealmType type : RealmType.values()) {
			if (type.id == id) {
				return type;
			}
		}
		throw new EnumerationException(id, RealmType.class.getName());
	}
	
	public static RealmType fromName(String name) {
		for (RealmType type : RealmType.values()) {
			if (type.name == name) {
				return type;
			}
		}
		throw new EnumerationException(name, RealmType.class.getName());
	}
}
