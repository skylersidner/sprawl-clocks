package com.mindcanary.domain.clock;

import com.mindcanary.domain.type.RealmType;
import com.mindcanary.domain.type.CountdownType;

public class Clock {

	private long id;
	private RealmType realm;
	private String name;
	private CountdownType countdown;
	private String description;
	
	
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	
	public RealmType getRealm() {
		return realm;
	}
	public void setRealm(RealmType realm) {
		this.realm = realm;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public CountdownType getCountdown() {
		return countdown;
	}
	public void setCountdown(CountdownType countdown) {
		this.countdown = countdown;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
}
