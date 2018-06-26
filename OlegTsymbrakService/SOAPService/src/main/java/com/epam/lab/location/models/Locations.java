package com.epam.lab.location.models;

public class Locations {
    private int x;
    private int y;
    private String location;

    public Locations() {
    }
    public Locations(String location) {
        this.location = location;
    }
    public Locations(String location, int x, int y) {
        this.location = location;
        this.x = x;
        this.y = y;
    }

    public String getLocation(){
        return location;
    }

    public int getX(){
        return x;
    }
    Friends someFriends = new Friends();
    public int getY(){
        return y;
    }
}
