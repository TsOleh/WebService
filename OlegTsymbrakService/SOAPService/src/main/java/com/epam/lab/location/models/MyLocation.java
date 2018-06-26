package com.epam.lab.location.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "myLocation")
public class MyLocation extends Locations{
    public MyLocation(String location){
        super(location);
    }
}
