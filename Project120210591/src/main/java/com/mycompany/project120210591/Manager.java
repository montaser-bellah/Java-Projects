/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.project120210591;

import static com.mycompany.project120210591.Admin.scanner;
import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;

public class Manager extends Person implements Serializable {


    public Manager() {
        
    }



    public Manager(String id, String password, String name, String email, String phoneNumber, int status) {
        super(id, password, name, email, phoneNumber, status);
    }
    ///////////////////////
   /* public  boolean statusManagerServices;
    public void activateOrDeactivateStatusMServices(){
        if(this.statusManagerServices){
            this.ManagerServices();

        }else {
            System.out.println("You are not authorized to access system permissions");
        }
    }*/

//////////////////////////

    public static void addEmployee(Employee employee) {
        if (Services.employees.add(employee)) {
            System.out.println("Employee was been added successfully ...");
        } else {
            System.out.println("Error Employee doesn't added !!!");
        }

    }

    public static void remove(Employee employee) {
        if (Services.employees.remove(employee)) {
            System.out.println("The Employee was been Deleted ...");
        } else {
            System.out.println("Error Process doesn't completed ...");
        }
    }

    //this method used to make sure for Employee is Exists or not .
    public static Employee check(String input) {
        for (Employee employee : Services.employees) {
            if (employee.getId().equals(input) || employee.getName().equals(input)) {
                return employee;
            }
        }
        return null;
    }

    public static void deletedEmployee() {
//        Manager.read();
        System.out.println("PLease Enter UserName / ID ");
        String id = scanner.next();
        if (Manager.check(id) != null) {
            Manager.remove(Manager.check(id));
            Manager.write();
        } else {
            System.out.println("Manager doesnt found ...");
        }
    }

    public static void updataEmployee() {
//        Manager.read();
        System.out.println("PLease Enter UserName/ID ");
        String id = scanner.next();
        if (Manager.check(id) != null) {
            System.out.println("Please Enter New Password...");
            Manager.check(id).setPassword(scanner.next());
            System.out.println("The New Password has been updated 😉");
            Manager.write();
        } else {
            System.out.println("Wrong ID Or Employee with ID " + id + "doesn't Found...");
        }
    }

    // this mehtod used to search about Employee.
    public static void seachAboutEmployee() {
//        Manager.read();
        System.out.println("Please Enter UserName / ID ");
        String id = scanner.next();
        if (Manager.check(id) != null) {
            Manager.check(id).smallRoport();
        } else {
            System.out.println("Cann't be Found 😌");
        }
    }

    // this mehtod used to given Reprot about employee
    public static void ReportAboutEmployee() {
        Iterator<Employee> iterator = Services.employees.iterator();
        if (Services.employees.isEmpty()) {
            System.out.println(">>>>>>>> No Employees >>>>>>>>>>>");
        } else {
            while (iterator.hasNext()) {
                System.out.println(" Report About Manager... ");
                System.out.println("PLease Enter Name Or ID ");
                String input = scanner.next();
                if (check(input) != null) {
                    System.out.println(iterator.next().getReportAboutPerson()+" }");
                    break;

                }
            }
        }
    }

    //this.method used to given Reprot about all Employee.
    public static void AllEmployees() {
        Manager.read();
        Iterator<Employee> iterator = Services.employees.iterator();
        if (Services.employees.isEmpty()) {
            System.out.println("No Employees ...");
        } else {
            System.out.println(" Reprot About All Employees ...");
            while (iterator.hasNext()) {
                System.out.println(iterator.next().getReportAboutPerson());
            }
        }
    }

    public static void screenActivateAndDeactivate() {
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
//        Manager.read();
        System.out.println("PLease Enter ID ");
        String id = scanner.next();
        if (Manager.check(id) != null) {
            if (Manager.check(id).getStatus() == 1) {
                System.out.println("Acount was been Ativated ...");
            } else {
                Manager.check(id).setStatus(1);
                System.out.println(" Now , Acount was been Activated ");
            }
            Manager.write();
        }

    }


    public static void insertDeactivate() {
//        Manager.read();
        System.out.println("PLease Enter ID ");
        String id = scanner.next();
        if (Manager.check(id) != null) {
            if (Manager.check(id).getStatus() == 0) {
                System.out.println("Acount was been Disable...");
            } else {
                Manager.check(id).setStatus(0);
                System.out.println(" Now , Acount was been Deactivated ");
            }
            Manager.write();
        }

    }
    public static void convertToManager(){
//        Manager.read();
        System.out.println("<<< Promote an employee to Manager >>>\nPLease Enter ID");
                String id = scanner.next();
               if(Manager.check(id)!=null){

                   Manager manager = new Manager();
                   manager.setIdForPromote(Manager.check(id).getId());
                   manager.setName(Manager.check(id).getName());
                   manager.setEmail(Manager.check(id).getEmail());
                   manager.setPassword(Manager.check(id).getPassword());
                   manager.setPhoneNumber(Manager.check(id).getPhoneNumber());
                   manager.setStatus(Manager.check(id).getStatus());
                   manager.setHoliday(Manager.check(id).getHoliday());
                   Services.managers.add(manager);
                   System.out.println("The Current Employee with ID >> ( "+manager.getId() +" )has the authority of a manager...");
                   Manager.remove(Manager.check(id));
                   Services.employees.remove(Manager.check(id));
                   Manager.write();
                   
               }else 
                   System.out.println("Cann't be found the Employee");
    }

    
    
    
    
    


    
    public  void ManagerServices()  {

        do {
         Services.ManagerScreen();
            Services.input();
            switch (Services.actions) {
                case 1:
                    Employee employee = new Employee();
                    Services.addPerson(employee);
                    break;
                case 2:
                    Manager.updataEmployee();
                    break;
                case 3:
                    Manager.deletedEmployee();
                    break;
                case 4:
                    Manager.seachAboutEmployee();
                    break;
                case 5:
                    Manager.ReportAboutEmployee();
                    break;
                case 6:
                   Services.screenFullReport();
                    Manager.AllEmployees();
                    break;
                case 7:
                    Manager.screenActivateAndDeactivate();
                    break;
                case 8:
                      Manager.convertToManager();
                    break;
                case 9:
                    Services.currentManager.getAttendance().AttendanceAndLeave();
                    break;
                case 10:
                Services.HolidayServices();
                    break;
                default:
                    if(Services.actions!=11)
                        System.out.println("Please Enter only from 1 to 11 ...");
                    break;
        }

        } while (Services.actions != 11);
    }
    
    //Storing and reading data for employees....
    
     public static void read() {
        try {
           Project120210591.ois= new ObjectInputStream(new FileInputStream(Project120210591.Employees));
            Services.employees = (ArrayList<Employee>) Project120210591.ois.readObject();
           Project120210591.ois.close();

        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }
    }
      public static void write() {
        try {
          Project120210591.oos = new ObjectOutputStream(new FileOutputStream(Project120210591.Employees,false));
            Project120210591.oos.writeObject(Services.employees);
            Project120210591.oos.flush();
            Project120210591.oos.close();

        } catch (IOException e) {
        }
    }

}

    
    
 
    


