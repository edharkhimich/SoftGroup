package com.softgroup.java;

import java.util.Observable;

public class Room extends Observable{
	
	private int doctorCount;
	private int visitorCount;
	private int number;

	public Room(int number) {
		this.number = number;
	}

	public synchronized void notifyDisplay() {
		setChanged();
		notifyObservers();
	}

	public int getNumber() {
		return number;
	}

	public int getDoctorCount() {
		return doctorCount;
	}
	
	public int getVisitorCount() {
		return visitorCount;
	}

	public void incDoctorCount(int newCount) {
		this.doctorCount += newCount;
	}
	
	public void incVisitorCount(int newCount) {
		this.visitorCount += newCount;
	}

}
