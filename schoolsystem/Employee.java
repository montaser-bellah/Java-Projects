
package schoolsystem;

import java.io.Serializable;


 abstract  class  Employee implements Serializable{
    private String name;
    private int id;
    private String address;
    private String phoneNumber;
    private String email;
    private double basicSalary;
   

    public Employee() {
    }

    public Employee(String name, int id, String address, String phoneNumber, String email, double basicSalary ) {
        this.name = name;
        this.id = id;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.basicSalary = basicSalary;
       
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public double getBasicSalary() {
        return basicSalary;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBasicSalary(double basicSalary) {
        this.basicSalary = basicSalary;
    }

    

    public double getSalary() {
        return basicSalary ;
    }

    @Override
    public String toString() {
        return "Employee Details: \n" +
                "Name: " + name + "\n" +
                "ID: " + id + "\n" +
                "Address: " + address + "\n" +
                "Phone Number: " + phoneNumber + "\n" +
                "Email: " + email + "\n" +
                "Basic Salary: " + basicSalary ;
                
    }
}
