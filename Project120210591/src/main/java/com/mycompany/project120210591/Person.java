/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project120210591;

import static com.mycompany.project120210591.Admin.scanner;
import java.io.Serializable;

public class Person implements Serializable, Comparable<Person> {

    private String id;
    private String password;
    private String name, email, phoneNumber;
    private int status;
    private String  Status;
    private Attendance attendance;

    public Attendance getAttendance() {
        return attendance;
    }

    private Holiday holiday;

    public Holiday getHoliday() {
        return holiday;
    }

    public void setHoliday(Holiday holiday) {
        this.holiday = holiday;
    }

    public Person() {
        this.holiday = new Holiday();
        this.attendance = new Attendance(); //لكل شخص لابد من أي يكون له كائن من 
        //                                            هذا الكلاس

    }

    public Person(String id, String password, String name, String email, String phoneNumber, int status) {
        this.id = id;
        this.password = password;
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;

    }

    Person(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }


    public void setId(String id) { //this method make sure about id for person if its repate...
        do{
          if(!Services.idIsExists(id)){
              this.id = id;
              break;
          }else {
              System.out.println("Please Enter anthor ID , because this "+id+ " is Exists!!!");
              id = scanner.next();
          }


        }while(true);
    }

    public void setIdForPromote(String id ){//this method used to put Employee id's in Manager Id's.
        this.id= id;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.Status ="Disable";
        if(status==1)
            this.Status="Active";
        this.status = status;
    }

    public void smallRoport() {
        System.out.println("Name : " + this.getName() + " ||" + " Status : " + this.getStatus());
    }

    public String getReportAboutPerson() {

        return "{"
                + "id='" + id + '\''
                + ", password='" + password + '\''
                + ", name='" + name + '\''
                + ", email='" + email + '\''
                + ", phoneNumber='" + phoneNumber + '\''
                + ", checkIn='" + this.getAttendance().getTimeAttendance() + '\''
                + ", checkOut='" + this.getAttendance().getTimeOfLeave() + '\''
                + ", status= " + Status
               ;
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "{"
                + "id='" + id + '\''
                + ", name='" + name + '\'';

    }
}
// this class used to record timeAttendance and Time of Leave....

class Attendance implements Serializable {

    private String timeAttendance, timeOfLeave;

    public String getTimeAttendance() {
        return timeAttendance;
    }

    public void setTimeAttendance(String timeAttendance) {
        this.timeAttendance = timeAttendance;
    }

    public String getTimeOfLeave() {
        return timeOfLeave;
    }

    public void setTimeOfLeave(String timeOfLeave) {
        this.timeOfLeave = timeOfLeave;
    }

    public void attendanceScreen() {
        System.out.println("<<< Attendance >>>");
        System.out.println("1.Time Attendance\n2.Time of Leave\n3.Exit...");
    }

    public void recordAttendance() {
        System.out.println("<<< Time Attendance >>>");
        System.out.println("Enter Time ...");
        this.setTimeAttendance(scanner.next());
    }

    public void recordTimeOfLeave() {
        System.out.println("<<< Time OF Leave >>>");
        System.out.println("Enter Time ...");
        this.setTimeOfLeave(scanner.next());
    }

    public void AttendanceAndLeave() {
        do {
            this.attendanceScreen();
            Services.input(); //this.mehtod used to make sure about numbers ...
            //أي للتأكد من صحة الأرقام قبل إدخالها                  
            switch (Services.actions) {
                case 1:
                    this.recordAttendance();
                    break;
                case 2:
                    this.recordTimeOfLeave();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("PLease Enter only 1 to 3");
            }
            if (Services.actions == 3) {
                break;
            }

        } while (true);
    }

}
