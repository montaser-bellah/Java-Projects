/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project120210591;

import java.io.Serializable;
import java.util.ArrayList;

public class Holiday implements Serializable {

    Person person;

    private String name;
    private String Id;
    private String reason; //Reason about request HOliday
    private String details; // details about Holidays
    private String Date; //this variable to set and get the Date of Holiday
    private int check = 0; //this variable to set and get the sutatus for Holiday.
    private int count = 0;

    Holiday() {

    }

    Holiday(Person person) {
        this.person = person;
    }

    public Person getPerson() {
        return person;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }


    @Override
    public String toString() {
        String check = "No Response";
        switch (this.check) {
            case 1:
                check = "Accepted";
                break;
            case 2:
                check = "Rejected";
                break;
        }

        return "{"
                + " name='" + name + '\''
                + ", Id='" + Id + '\''
                + ", reason='" + reason + '\''
                + ", details='" + details + '\''
                + ", Date='" + Date + '\''
                + ", Check=" + check
                + '}';
    }
}
