package com.epam.lab.location.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "friends")
public class Friends {
    private String name1;
    private String name2;
    private String name3;
    private String name4;
    private String names;
    private Friends value;

    //private Double value;
    public Friends getValue() {
        return value;
    }

    public void setValue(Friends value) {
        this.value = value;
    }

    public Friends(Friends someFriends) {
        this.value = someFriends;
    }

    public Friends() {
    }

    public Friends(String name1) {
        this.name1 = name1;
    }

    public Friends(String name1, String name2) {
        this.name1 = name1;
        this.name2 = name2;
    }

    public Friends(String name1, String name2, String name3) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
    }

    public Friends(String name1, String name2, String name3, String name4) {
        this.name1 = name1;
        this.name2 = name2;
        this.name3 = name3;
        this.name4 = name4;
    }

    @Override
    public String toString() {
        if (name1 != null && name2 == null && name3 == null && name4 == null) {
            names = String.format("There is 1 friend in this location  - %s", name1);
        } else if (name1 != null && name2 != null && name3 == null && name4 == null) {
            names = String.format("There are 2 friends in this location - %s, %s", name1, name2);
        } else if (name1 != null && name2 != null && name3 != null && name4 == null) {
            names = String.format("There are 3 friends in this location - %s, %s, %s", name1, name2, name3);
        } else if (name1 != null && name2 != null && name3 != null && name4 != null) {
            names = String.format("There are 4 friends in this location - %s, %s, %s, %s", name1, name2, name3, name4);
        }
        return names;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Friends friends = (Friends) o;
        return this.name1==friends.name1&&
                this.name2==friends.name2&&
                this.name3==friends.name3&&
                this.name4==friends.name4;
    }

    @Override
    public int hashCode() {
        int result = name1.hashCode();
        result = 31 * result + name2.hashCode();
        result = 31 * result + name3.hashCode();
        result = 31 * result + name4.hashCode();
        return result;
    }
}
