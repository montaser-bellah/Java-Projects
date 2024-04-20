/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraaa;

import java.io.*;
 import java.util.ArrayList;
import java.util.Scanner;
import java.io.Serializable;


public class Library implements Serializable   {
   
 ArrayList<Book> books;
  ArrayList<Student> students;
  
 
  

    public Library() {
        books = new ArrayList<>();
        students = new ArrayList<>();
        this.readBooks();
        this.readStudents();
    }

    public void showBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void deleteBook(Book book) {
        books.remove(book);
    }

    public Book searchBook(String bookName) {
        for (Book book : books) {
            if (book.getBookName().equalsIgnoreCase(bookName)) {
                return book;
            }
        }
        return null;
    }

    public void buyBook(Book book) {
        book.setBookQu(book.getBookQu() - 1);
    }

    public void showStudents() {
        for (Student studentss : students) {
            System.out.println(studentss);
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void FullReport() {
        System.out.println("Books:");
        showBooks();
        System.out.println("Students:");
        showStudents();
    }

    void buyBook(Book book, Student student) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
     public void writeBooks(){
      Baraaa.file= new File("books.dat");
     try {
         Baraaa.oos = new ObjectOutputStream(new FileOutputStream(Baraaa.file));
         Baraaa.oos.writeObject(books);
         Baraaa.oos.flush();//تستخدم هذه الدالة لكي يتم تأكيد الكتابة ع الملف 
         Baraaa.oos.close();
     } catch (FileNotFoundException ex) {
         System.out.println(ex.getMessage());
     } catch (IOException ex) {
         System.out.println(ex.getMessage());
     }
      
  }
  ////////////////////////////////////////////////////////////
  public void readBooks(){
      Baraaa.file=new File("books.dat");
     try {
         Baraaa.ois=new ObjectInputStream(new FileInputStream(Baraaa.file));
        books=(ArrayList<Book>) Baraaa.ois.readObject();
        //لابد من عمل casting 
       Baraaa.ois.close();
     } catch (FileNotFoundException ex) {
         System.out.println(ex.getMessage());
         
     } catch (IOException ex) {
         System.out.println(ex.getMessage());
     } catch (ClassNotFoundException ex) {
         System.out.println(ex.getMessage());
     }
      
  }
  ////////////////////////////////////////////////////
   public void writeStudents(){
      Baraaa.file= new File("students.dat");
     try {
         Baraaa.oos = new ObjectOutputStream(new FileOutputStream(Baraaa.file));
         Baraaa.oos.writeObject(students);
         Baraaa.oos.flush();//تستخدم هذه الدالة لكي يتم تأكيد الكتابة ع الملف 
         Baraaa.oos.close();
     } catch (FileNotFoundException ex) {
         System.out.println(ex.getMessage());
     } catch (IOException ex) {
         System.out.println(ex.getMessage());
     }
      
  }
  ////////////////////////////////////////////////////////////
  public void readStudents(){
      Baraaa.file=new File("students.dat");
     try {
         Baraaa.ois=new ObjectInputStream(new FileInputStream(Baraaa.file));
        students=(ArrayList<Student>) Baraaa.ois.readObject();
        //لابد من عمل casting 
       Baraaa.ois.close();
     } catch (FileNotFoundException ex) {
         System.out.println(ex.getMessage());
         
     } catch (IOException ex) {
         System.out.println(ex.getMessage());
     } catch (ClassNotFoundException ex) {
         System.out.println(ex.getMessage());
     }
      
  }
  
}

    

