/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraaa;

import java.io.Serializable;
import java.util.ArrayList;

public class Student extends Person implements Serializable {
    private int studentID;
    private String specialization;
    private String enrolledDate;
    private double budget;
    private ArrayList<Book> booksBorrowed;
 

    public Student() {
      
    }
    
    

    public Student( int personIdentityNumber, String personName,String personGender,String personPhone,String personAddress,
   String specialization, String enrolledDate, double budget) {
        
   
    super( personIdentityNumber,  personName, personGender, personPhone, personAddress);
        this.studentID = personIdentityNumber;
        this.specialization = specialization;
        this.enrolledDate = enrolledDate;
        this.budget = budget;
         
    }
    
    public void addBook(Book book) {
        booksBorrowed.add(book);
    }
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getEnrolledDate() {
        return enrolledDate;
    }

    public void setEnrolledDate(String enrolledDate) {
        this.enrolledDate = enrolledDate;
    }

    public double getBudget() {
        return budget;
    }

    public void setBudget(double budget) {
        this.budget = budget;
    }
    public void printPersonDetails() {
      
        System.out.println("Student ID: " + studentID);
        System.out.println("Specialization: " + specialization);
        System.out.println("Enrolled Date: " + enrolledDate);
        System.out.println("Budget: " + budget);
        
    }

    @Override
    public String toString() {
        return "Student{" + "StudentIdentityNumber: " + personIdentityNumber + ", StudentName: " + personName + ", StudentGender: " + personGender + ", StudentPhone: " + personPhone + ", StudentAddress: " + personAddress +
                ", Student ID: " + studentID +
                ", Specialization: " + specialization +
                ", Enrolled Date: " + enrolledDate + 
                ", Budget: " + budget + 
                 '}' ;
    }
    
    
    
    
    
    
    
    
    
}
