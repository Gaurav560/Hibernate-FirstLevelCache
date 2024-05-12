package com.telusko;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//POJO
@Entity
public class Alien {

    //fields
    @Id
    private int aid;
    private String aname;
    private String color;


    //getters and setters
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }


    @Override
    public String toString() {
        return "Alien{" +
                "aid=" + aid +
                ", aname='" + aname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}