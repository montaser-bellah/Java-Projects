/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project120210591;

import java.io.Serializable;

import static com.mycompany.project120210591.Services.scanner;

/**
 *
 * @author A
 */
public class Employee extends Person implements Serializable {

    private int FullTime;
    private int PartTime;

    public Employee() {
    }

    public Employee(String id, String password, String name, String email, String phoneNumber, int status) {
        super(id, password, name, email, phoneNumber, status);
    }
    

    public int getFullTime() {
        return FullTime;
    }

    public void setFullTime(int fullTime) {
        FullTime = fullTime;
    }

    public int getPartTime() {
        return PartTime;
    }

    public void setPartTime(int partTime) {
        PartTime = partTime;
    }

    @Override
    public String getReportAboutPerson() {
        String type = "Not specified";
        if(this.PartTime==1){
            type = "PartTime";
        }else if (this.FullTime==1)
            type="FullTime";
            
        return "" + super.getReportAboutPerson()+ type + '}';
               
    }
    public void employeeInterface(){
        System.out.println("<<< Employee >>>");
        System.out.println("1.Chanage Password\n2.Attendance\n3.Holiday\n4.Exit");
    }
    public void ChanagePassword(){
        System.out.println("Please Enter New Password...");
        String password = Services.scanner.next();
        Services.currentEmployee.setPassword(password);
        System.out.println("Password has been updataed...");
    }
      public static void HolidayServicesForEmployee() {
        do {
            Services.HolidayInterface();
            Services.input();
            switch (Services.actions) {
                case 1:
                    Services.myHoliday(Services.currentEmployee);
                    break;
                case 2:
                    Services.createHoliday(Services.currentEmployee);
                    break;
                case 3:
                    break;

                    
            }

        } while (Services.actions!=3);

    }
      public void EmployeeServices(){
          do{
              this.employeeInterface();
              Services.input();
              switch(Services.actions){
                  case 1:
                      this.ChanagePassword();
                      break;
                  case 2:
                 Services.currentEmployee.getAttendance().AttendanceAndLeave();
                      break;
                  case 3:
                      Employee.HolidayServicesForEmployee();
                      break;
                       default:
                           if(Services.actions!=4)
                               System.out.println("PLease Enter only from 1 to 4...");


                           break;

              }

          }while(Services.actions!=4);
      }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
}

