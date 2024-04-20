/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project120210591;

import com.sun.tools.javac.Main;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *               /** بسم الله الرحمن الرحيم *                        /
 *
 * @author A
 */
public class Services  {

    public static int actions;
    static ArrayList<Person> persons;
    static ArrayList<Manager> managers;
    static ArrayList<Employee> employees;
    static ArrayList<Holiday> holidays;
    /********************************************************/
    
   static File managerData ;
    static File Holidays ;
   static FileOutputStream fileOutputStream;
   static  ObjectOutputStream objectOutputStream;
   static FileInputStream fileInputStream;
   static  ObjectInputStream objectInputStream;
    /**********************************************************/
    
    static Scanner scanner;
    public static Person currentPerson;
    public static Manager currentManager;
    public static Employee currentEmployee;
    public static Admin currentAdmin;

    static ArrayList<Admin> admins;

    Services() {
        this.persons = new ArrayList<Person>();
        this.admins = new ArrayList<>();
        this.managers = new ArrayList<>();
        this.employees = new ArrayList<>();
        this.holidays = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        Admin.readAdminDat();
        Manager.read();
        Services.readManager();
        Services.readHolidays();
        
//        Admin admin = new Admin();        طريقة تقليدية للتجريب.....
//        admin.setId("admin");
//        admin.setPassword("admin");
//        Services.admins.add(admin);

    }

    public void input(int action) {
        try {
            action = scanner.nextInt();
        } catch (InputMismatchException e) {
        }
        scanner.nextLine();
    }

////////////////////////////////////Logins /////////////////////////////////////////////
    public void loginScreen() {

        System.out.println("1. Login As Admin ");
        System.out.println("2. Login As Manager ");
        System.out.println("3. Login As Employee");
        System.out.println("4. About the System");
        System.out.println("5. Exit...");


    }

    public void Logins() throws IOException, ClassNotFoundException {
            
        do {

            this.loginScreen();
            Services.input();
            switch (Services.actions) {
                case 1:
                    this.LoginAsAdmin();
                    break;
                case 2:
                    this.LoginAsManager();
                    break;
                case 3:
                    this.LoginAsEmployee();
                    break;
                case 4:
                    this.AboutSystem();
                    break;
                case 5:
                    Admin.writeAdminData();
                    Services.writeManager();
                    Services.writeHolidays();
                    Manager.write();

                    break;
                    
                   
                default:
                    if (Services.actions != 5) {
                        System.out.println("PLease Enter only from 1 to 5...");
                    }
                    break;
            }

        } while (Services.actions != 5);

    }

    public void LoginAsAdmin() throws IOException {
        Admin.readAdminDat();
       if(Services.admins.isEmpty()){
           Admin.creatNewAdmin();
       }else{
        System.out.println(" PLease Enter UserName ");
        String id = scanner.next();
        System.out.println(" Please Enter Password ");
        String password = scanner.next();
        for (Admin admin : Services.admins) {
            if (id.equals(admin.getId()) && password.equals(admin.getPassword())) {
                currentAdmin = admin;
                currentAdmin.adminServices();

                break;
            } else {
                System.out.println("Manager cann't be found Or UserName | Password Incrroct 🙄");
            }
        }
    }}

    public void LoginAsManager()  {
//        Services.readManager();
        System.out.println(" PLease Enter UserName ");
        String id = scanner.next();
        System.out.println(" Please Enter Password ");
        String password = scanner.next();
        if (Services.isFoundManager(id, password) != null) {
            if (isFoundManager(id, password).getStatus() != 1) {
                System.out.println("Your Account Disable , so try Again...");
            } else {
              Services.currentManager = isFoundManager(id, password);
              currentManager.ManagerServices();
            }
        } else {
            System.out.println("Cann't be Found the Manager...");
        }
    }

    public void LoginAsEmployee() {
//        Manager.read();
        System.out.println(" PLease Enter UserName ");
        String id = scanner.next();
        System.out.println(" Please Enter Password ");
        String password = scanner.next();
        if (Services.isFound(id, password) != null) {
            if (isFound(id, password).getStatus() != 1) {
                System.out.println("Your Account Disable , so try Again...");
            } else {
                Services.currentEmployee = isFound(id, password);
                Services.currentEmployee.EmployeeServices();
            }
        } else {
            System.out.println("Cann't be Found the Employee...");
        }

    }
    //////////////////////////////////// end Logins /////////////////////////////////////////

    //This method used to return boolean value if the id is Exists...
    public static boolean idIsExists(String id) {
        Services.readManager();
        Services.readHolidays();
        Manager.read();
        if (!Services.managers.isEmpty()) {
            for (Manager manager : Services.managers) {
                if (manager.getId().equals(id) && manager.getId() != null) {
                    return true;
                }

            }
        }
         if (!Services.employees.isEmpty()) {
            for (Employee employee : Services.employees) {
                if (employee.getId().equals(id)) {
                    return true;
                }

            }
        }
        return false;
    }
    public static Manager isFoundManager(String id, String password)  {
//        Services.readManager();
        for (Manager manager : Services.managers) {
            if (id.equals(manager.getId()) && password.equals(manager.getPassword())) {
                return manager;
            }
        }
        return null;
    }

    //This method used to make sure about Employee with id and password
    public static Employee isFound(String id, String password) {
        Manager.read(); //this method used to read Employee data...

        for (Employee employee : Services.employees) {
            if (id.equals(employee.getId()) && password.equals(employee.getPassword())) {
                return employee;
            }
        }
        return null;
    }

    //This method used to add Person on the system...
    public static void addPerson(Person person)  {
//        Services.readManager(); /**/Manager.read();
        System.out.println("Enter ID: ");
        person.setId(scanner.next());
        System.out.println("Enter Name: ");
        person.setName(Services.scanner.next());
        System.out.println("Enter password: ");
        person.setPassword(scanner.next());
        System.out.println("Enter Email:");
        person.setEmail(scanner.next());
        System.out.println("Enter PHone Number: ");
        person.setPhoneNumber(scanner.next());
        System.out.println("Enter Status: ");
        person.setStatus(scanner.nextInt());
       if (person instanceof Manager) {
            managers.add((Manager) person);
            System.out.println("The Manager was been added successfully...");
            Services.writeManager();
        } else if (person instanceof Employee) {
            System.out.println("Type of Employee (1) <FullTime> or (2) <PartTime>");
            Employee employee = (Employee) person;
            Services.input();
            if (Services.actions == 1) {
                employee.setFullTime(1);
                employees.add(employee);
            } else if (Services.actions == 2) {
                employee.setPartTime(1);
                employees.add(employee);
            } else {
                System.out.println("PLease Enter only 1 or 2 !");
                employee.setFullTime(0);
                employee.setPartTime(0);
                return;
            }
            System.out.println("The Employee has been successfully added😊");
            Manager.write();
        }

    }
///////////***************************************Sorting ???????>>>>>>>>>>>>>>>>>>>>>>>>>>>

    public static void sortAsecending() { // ترتيب تصاعديا بالنسبة للأسماء
//        Services.readManager();
//        Manager.read();
        Collections.sort(managers);
        Collections.sort(employees);
    }

    public static void sortDescending() { //ترتيب تنازليا بالنسبة للأسماء...
//        Services.readManager(); /**/ Manager.read();

        Collections.sort(Services.managers, Collections.reverseOrder());
        Collections.sort(Services.employees, Collections.reverseOrder());
    }

    public static void screenFullReport() {
//        Services.readManager();
//        Services.readHolidays();
        System.out.println("Choose the view of Data on the screen 😊");
        System.out.println("1. Asecending Order By Name: ");
        System.out.println("2. Descending Order By Name: ");
        Services.input();
        if (Services.actions == 1) {
            Services.sortAsecending();
        } else if (Services.actions == 2) {
            Services.sortDescending();
        } else {
            System.out.println("PLease Enter only 1 Or 2 !!!");
        }

    }

    //////////////////////////End Sorting**********//////////////////////////////////////////////
    public static void getManagerAndEmployeeCount() {
//        Services.readManager(); Manager.read();
        System.out.println(">>>Manager , Employee Count>>>");
        System.out.println("Mangaer Count >> " + Services.managers.size());
        System.out.println("Employee Count >> " + Services.employees.size());

    }

    public static void secreenHolidayRequests() {
        System.out.println(">>>Holiday requests>>>");
        System.out.println("1. View Holiday requests:");
        System.out.println("2. Accept the holiday:");
        System.out.println("3. Rejected the holiday:");
        System.out.println("4. Exit...");
    }

    public static void holidayRequests() {

        do {
            Services.secreenHolidayRequests();
            Services.input();
            switch (Services.actions) {
                case 1:
                    Services.viewHolidays();
                    break;
                case 2:
                    Services.acceptHoliday();
                    break;
                case 3:
                    Services.rejectHoliday();
                    break;
                default:
                    if(Services.actions!=4)
                        System.out.println("Please Enter only from 1 to 4");
                    break;
            }

        } while (Services.actions != 4);
    }

    public static void viewHolidays() {
//        Services.readHolidays();
        if (!Services.holidays.isEmpty()) {
            for (Holiday holiday : holidays) {
                if (holiday.getCheck() == 0) {
                    System.out.println(holiday.toString());
                }
            }
        } else {
            System.out.println("No Holidays requests");
        }
    }

    // This  method used to find the holiday and return its if she is exists...
    public static Holiday findHolidayById(String id) {
//        Services.readHolidays();
        if (!Services.holidays.isEmpty()) {
            for (Holiday holiday : Services.holidays) {
                if (holiday.getId().equals(id)) {
                    return holiday;
                }
            }
        } else {
            System.out.println("No Holiday Requests ...");
        }
        return null;

    }

    public static void acceptHoliday() {
//        Services.readHolidays();
        System.out.println("PLease Enter ID ");
        String id = scanner.next();
        if (Services.findHolidayById(id) != null) {
            if (Services.findHolidayById(id).getCheck() == 0) {
                Services.findHolidayById(id).setCheck(1);
                System.out.println("Approve successfully ....");
                Services.writeHolidays();
            }

        } else {
            System.out.println("Incrrocet ID , try again...");
        }
    }

    public static void rejectHoliday() {
//        Services.readHolidays();
        System.out.println("PLease Enter ID ");
        String id = scanner.next();
        if (Services.findHolidayById(id) != null) {
            if (Services.findHolidayById(id).getCheck() == 0) {
                Services.findHolidayById(id).setCheck(2);
                System.out.println("Holiday Request was been rejected  ....");
//                Services.writeHolidays();
            }

        } else {
            System.out.println("Incrrocet ID , try again...");
        }
    }

    public static void createHoliday(Person person) {
        Scanner reader = new Scanner(System.in);
         Holiday holiday = new Holiday();
        holiday.setId(person.getId());
        System.out.println("Your Name :");
        System.out.println(person.getName());
        holiday.setName(person.getName());
        System.out.println("Please Enter Reason ");
        String reason = reader.nextLine();
        holiday.setReason(reason);
        System.out.println("PLease Enter Detials ");
        String detials = reader.nextLine();
        holiday.setDetails(detials);
        System.out.print("Please Enter DATE" );
        String date= reader.nextLine();
        holiday.setDate(date);
        holiday.setCount(holiday.getCount() + 1);
        System.out.println("The Request has been submitted successfully ");
        Services.holidays.add(holiday);
        Services.writeHolidays();



    }
    public static Holiday returnHoliday(String id ){
        for(Holiday h : Services.holidays){
            if(id.equals(h.getId())&&h.getCheck()==0){
                return h;
            }
        }return null;
    }

    public static void myHoliday(Person person) {
//        Services.readHolidays();
        if (!Services.holidays.isEmpty()) {
            for (Holiday holiday : Services.holidays) {
                if (holiday.getId().equals(person.getId())) {
                    System.out.println(holiday.toString());
                    break;
                }else
                    System.out.println("No HOliday requests for you");

            }
        }else
            System.out.println("NO HOliday🙄");
    }


        static void HolidayInterface() {
        System.out.println("1.MY Holiday\n2.Create Holiday\n3.Exit...");
    }

    public static void HolidayServices() {
        do {
           
            Services.HolidayInterface();
            Services.input();
            switch (Services.actions) {
                case 1:
                    Services.myHoliday(Services.currentManager);
                    break;
                case 2:

                    Services.createHoliday(Services.currentManager);
                    break;
                default:
                    if(Services.actions!=3)
                        System.out.println("Please Enter only from 1 to 3...");
                    break;

            }

        } while (Services.actions != 3);

    }

    ////////////////////////////////////////////Managers Interface////////////////////////////////////
    public static void ManagerScreen() {
        System.out.println("1.Add Employee\n2.Update Employee \n3.Delete Employee "
                + "\n4.Search About Employee \n5.Report about Employee \n6.Report about all Employeee"
                + "\n7.Deactivate & Activate Employee\n8.Promote an employee to Manager \n9.Attendance \n10.Hliday \n11.Exit"
        );
        System.out.println(".....................................................................");
    }

    //this method used to catch the Error and solve the problem...
    public static void input() {
        try {
            actions = scanner.nextInt();
        } catch (InputMismatchException e) {
            actions = -1;
        }
        scanner.nextLine();
    }

    public void AboutSystem() {
        System.out.println("*          | System Information |          *");
        System.out.println("********************************************");
        System.out.println("* -Company Attendance Management System ");
        System.out.println("* -Developed by Montaser Bellah...120210591  ");
        System.out.println("* -@2023 - 2024     ");
    }
     public static void readManager() { //THis mehtod used to read data for Manager...
        if(Project120210591.managerData.canRead()){
             try {
                 Project120210591.ois = new ObjectInputStream(new FileInputStream(Project120210591.managerData));
                 Services.managers = (ArrayList<Manager>) Project120210591.ois.readObject();
                 Project120210591.ois.close();

             } catch (IOException | ClassNotFoundException e) {
                 System.out.println("No reading");
             }

         } }


    //This mehtod used to stor data for Manager...
     public static void writeManager() {
         if (!Services.managers.isEmpty()) {
             try {
                 Project120210591.oos = new ObjectOutputStream(new FileOutputStream(Project120210591.managerData,false));
                 Project120210591.oos.writeObject(managers);
                 Project120210591.oos.flush();
                 Project120210591.oos.close();
             } catch (IOException e) {
                 System.out.println("Error No Save...");
             }
         }
     }



    
    
     public static void writeHolidays() {
        if(!Services.holidays.isEmpty()){
             try {
                 Services.objectOutputStream = new ObjectOutputStream(new FileOutputStream(Project120210591.Holidays));
                 Services.objectOutputStream.writeObject(Services.holidays);
                 Services.objectOutputStream.flush();
                 Services.objectOutputStream.close();

                 } catch (IOException e) {
             }
         }
     }




    public static void readHolidays() {
        try {
            Project120210591.ois = new ObjectInputStream(new FileInputStream(Project120210591.Holidays));
            Services.holidays = (ArrayList<Holiday>) Project120210591.ois.readObject();
            Project120210591.ois.close();

        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }
    
    
    
    
    
    
    
    

}
