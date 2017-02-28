package com.softgroup.java;

import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

public class Display implements Observer {

    private Room room;
    private ArrayList<Room> listRooms = new ArrayList<>();
    private ArrayList<String> listStrings = new ArrayList<>();

    public void addRoom(Room room){
        this.room = room;
        room.addObserver(this);
    }
    
    public void addRooms(ArrayList<Room> listRooms) {
        this.listRooms = listRooms;
        for (Room r : listRooms) {
            r.addObserver(this);
        }
    }

    @Override
    public void update(Observable o, Object arg) {
        listStrings.clear();
        if (!listRooms.isEmpty() && room != null) {
            System.out.println("You must correctly put all rooms to list");
        } else if (listRooms.isEmpty()) {
            synchronized (room) {
                System.out.print("\rRoom №" + room.getNumber() + " -->  Doctors: " + room.getDoctorCount() +
                        " | Visitors: " + room.getVisitorCount());
            }
        } else {
            for (int i = 0; i < listRooms.size(); i++) {
                synchronized (listRooms.get(i)) {
                    listStrings.add("Room №" + listRooms.get(i).getNumber() + " -->  Doctors: " + listRooms.get(i).getDoctorCount() +
                            " | Visitors: " + listRooms.get(i).getVisitorCount());
                }
            }
            System.out.print("\r");
            for(int x = 0; x < listStrings.size(); x++){
                System.out.print(listStrings.get(x) + " |-| ");
            }
        }
    }
}

