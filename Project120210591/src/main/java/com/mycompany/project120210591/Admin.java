/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project120210591;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;


/**
 *
 * @author A
 */
public class Admin extends Person implements Serializable {

  static  Scanner scanner = new Scanner(System.in);
  static PrintWriter printwriter;

    public Admin() {
        Services.readManager();
      
    }


    public Admin(String id, String password, String name, String email, String phoneNumber, int status) {
        super(id, password, name, email, phoneNumber, status);
    }
    public static void creatNewAdmin(){
     
          Admin admin = new Admin();
          System.out.println("New Admin...");
          System.out.println("PLease Enter UserName...");
          admin.setName(scanner.next());
          System.out.println("PLease Enter ID ..");
          admin.setId(scanner.next());
          System.out.println("Please Enter Password .");
          admin.setPassword(scanner.next());
          Services.admins.add(admin);
          Admin.writeAdminData();
          
      
    }
    
//    public static void writeAdminData(Admin admin){
// try {
//            Admin.printwriter = new PrintWriter("Admin.txt");
//            Admin.printwriter.print(admin.getName()+","+admin.getId()+","+admin.getPassword());
//            Admin.printwriter.close();
//        } catch (FileNotFoundException e) {
//        }
//    }
//
//   public static void readAdminData(){
//       Scanner reader = new Scanner("Admin.txt");
//      if(!reader.hasNext())
//          Admin.creatNewAdmin();
//      else{
//          String []line = reader.nextLine().split(",");
//          reader.close();
//      }
//
//   }
    
     public static void writeAdminData(){
 try {
     Services.objectOutputStream = new ObjectOutputStream (new FileOutputStream("Admin.data"));
     Services.objectOutputStream.writeObject(Services.admins);
     Services.objectOutputStream.flush();
     Services.objectOutputStream.close();
        } catch (FileNotFoundException e) {
        } catch (IOException ex) {        
      }        
    }
     public static void readAdminDat(){
      try {
          Services.objectInputStream  = new ObjectInputStream (new FileInputStream("Admin.data"));
          Services.admins = (ArrayList<Admin>)Services.objectInputStream.readObject();
          Services.objectInputStream.close();
      } catch (Exception ex) {
          System.out.println("Cann't be reading");
      }
     }
    
    
    
    
      public static void adminSecreen() {

        System.out.println("1. Add Manager ");
        System.out.println("2. Update Manager Data");
        System.out.println("3. Delete Manager ");
        System.out.println("4. Search About Manager ");
        System.out.println("5. Report About Manager ");
        System.out.println("6. Report About All Managers ");
        System.out.println("7. HOliday requests ");
        System.out.println("8.  Deactivate & Activate Manager");
        System.out.println("9. Get Manager Count and Employee count ");
        System.out.println("10. Exit...");

    }

    public static void addManager(Manager manager) {
        Services.managers.add(manager);
        System.out.println("The Manager has been successfully added 😊");
    }

    public static  void removeManager(Manager manager) {
        if (Services.managers.remove(manager)) {
            Services.writeManager();
            System.out.println("The Manager has been deleted.");
        }

    }

    public static Manager check(String input) {
        for (Manager manager : Services.managers) {
            if (input.equals(manager.getId()) || input.equals(manager.getName())) {
                return manager;
            }
        }
        return null;
    }

    public static void deletedManager() {
        System.out.println("PLease Enter UserName / ID ");
        String id = scanner.next();
      if (check(id)!= null){
          Admin.removeManager(check(id));
      } else
            System.out.println("Manager doesnt found ...");
    }

    public static void updataManager() {
        System.out.println("PLease Enter UserName/ID ");
        String id = scanner.next();
        for (Manager manager : Services.managers) {
            if (id.equals(manager.getId())) {
                System.out.println("Please Enter New Password ");
                manager.setPassword(scanner.next());
                System.out.println("The New Password has been updated 😉");
            }
        }
    }

    // this mehtod used to search about manager.
    public static void seachAboutManager() {
        System.out.println("Please Enter UserName / ID ");
        String id = scanner.next();
        if (check(id) != null) {
            check(id).smallRoport();
        } else {
            System.out.println("Cann't be Found 😌");
        }
    }

// this mehtod used to given Reprot about manager.
public static void ReportAboutManager() {
    Iterator<Manager> iterator = Services.managers.iterator();
    if (!Services.managers.isEmpty()) {
        while (iterator.hasNext()) {
            System.out.println("<<< Report About Manager>>> ");
            System.out.println("PLease Enter Name Or ID ");
            String input = scanner.next();
            if (check(input) != null) {
                System.out.println(iterator.next().getReportAboutPerson()+" }");
                break;
 } else
                System.out.println("Cann't be found...");
        }
    }
}
      //this.method used to given Reprot about all Manager.
public static void AllManager(){
  Iterator <Manager> iterator = Services.managers.iterator();
  if(Services.managers.isEmpty()){
      System.out.println("No Managers ...");
  }
  else{
                  System.out.println(" Reprot About All Managers ...");
                   while(iterator.hasNext()){
                       System.out.println(iterator.next().getReportAboutPerson()+" }");
                   }
  }
}



   

    public static void SecreenDeOrActivatePerson() {
        int action2 = 0;
        do {
            System.out.println(">>>Deactivate & Activate Manager>>>");
            System.out.println("1.Activate ");
            System.out.println("2.Deactivate ");
            System.out.println("3. Exit...");
            Services.input();
            switch (Services.actions) {
                case 1:
                  insertActivate();
                    break;
                case 2:
                    insertDeactivate();
                    break;
                default:
                    if (Services.actions != 3) {
                        System.out.println("Incorrect input , try Again...");
                    }
                    break;
            }
        } while (Services.actions != 3);
    }

    public static void insertActivate() {
        System.out.println("PLease Enter ID ");
        String id = scanner.next();
        for (Manager manager : Services.managers) {
            if (manager.getId().equals(id)) {
                if (manager.getStatus() == 1) {
                    System.out.println("Acount was been Activated...");
                    break;
                } else {
                    manager.setStatus(1);
                    System.out.println(" Now , Acount was been Activated ");
                }
            }
        }

    }

    public static void insertDeactivate() {
        System.out.println("PLease Enter ID");
        String id = scanner.next();
        for (Manager manager : Services.managers) {
            if (manager.getId().equals(id)) {
                if (manager.getStatus() == 0) {
                    System.out.println("Acount was been Disable..");
                    break;
                } else {
                    manager.setStatus(0);
                    System.out.println(" Now , Acount was been Deactivated... ");
                }
            }
        }
    }
    
     public  void adminServices() throws IOException {
        do {
            Admin.adminSecreen();
            Services.input();
            switch (Services.actions) {
                case 1:
                    Manager manager = new Manager();
                   Services.addPerson(manager);
                    break;
                case 2:
                    Admin.updataManager();
                    break;
                case 3:
                    Admin.deletedManager();
                    break;
                case 4:
                    Admin.seachAboutManager();
                    break;
                case 5:
                    Admin.ReportAboutManager();
                    break;
                case 6:
                    
            Services.screenFullReport();
                    Admin.AllManager();
                    break;
                case 7:
               Services.holidayRequests();
                    break;
                case 8:
                    Admin.SecreenDeOrActivatePerson();
                    break;
                case 9:
                    Services.getManagerAndEmployeeCount();
                    break;
                case 10:
                    break;
                     default:
                    System.out.println("PLease Enter only from 1 to 10...");
                    break;
                

            }

        } while (Services.actions != 10);
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    

}
