package com.softgroup.java;

import java.util.ArrayList;
import java.util.Random;

public class Main {	
	
	private static final double PROBABILITY_DOCTOR = 0.2;
	private static final double PROBABILITY_VISITOR = 0.5;
	private static ArrayList<Room> list;
	private static Random r;
	private static Display display;


	public static void main(String[] args) {
		init();
		addRoomsToList();
		display.addRooms(list);
		startWorkingDay();
	}

	private static void init(){
		r = new Random();
		list = new ArrayList<>();
		display = new Display();
	}

	private static void addRoomsToList(){
		list.add(new Room(1));
		list.add(new Room(2));
		list.add(new Room(3));
		list.add(new Room(4));
		list.add(new Room(5));
	}

	private static void startWorkingDay(){
		while(true) {
			for (int i = 0; i < list.size(); i++) {
				if (r.nextDouble() < PROBABILITY_VISITOR) {
					new Visitor(list.get(i)).start();
				}
				if (r.nextDouble() < PROBABILITY_DOCTOR) {
					new Doctor(list.get(i)).start();
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
