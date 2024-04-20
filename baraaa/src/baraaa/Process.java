/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraaa;

import java.util.Scanner;


public class Process {
    private Library library;
    private Scanner scanner;

    public Process() {
        library = new Library();
        scanner = new Scanner(System.in);
    }

    public void start() {
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    deleteBook();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    buyBook();
                    break;
                case 6:
                    library.showStudents();
                    break;
                case 7:
                    addStudent();
                    break;
                case 8:
                    // Generate full report
                    break;
                case 9:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }

            System.out.println();
        } while (choice != 9);
    }

    private void displayMenu() {
        System.out.println("----- Library Management System -----");
        System.out.println("1. Show Books");
        System.out.println("2. Add a Book");
        System.out.println("3. Delete a Book");
        System.out.println("4. Search for a Book");
        System.out.println("5. Buy a Book");
        System.out.println("6. Show Students");
        System.out.println("7. Add a Student");
        System.out.println("8. Full Report");
        System.out.println("9. Exit");
    }

    private void addBook() {
        System.out.print("Enter Book ID: ");
        String bookID = scanner.nextLine();
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter Book Category: ");
        String bookCategory = scanner.nextLine();
        System.out.print("Enter Book Author ID: ");
        String authorID = scanner.nextLine();
        System.out.print("Enter Book Author Name: ");
        String authorName = scanner.nextLine();
        System.out.print("Enter Book Publisher: ");
        String bookPublisher = scanner.nextLine();
        System.out.print("Enter Book Edition Year: ");
        int bookEditionYear = scanner.nextInt();
        System.out.print("Enter Book Price: ");
        double bookPrice = scanner.nextDouble();
        System.out.print("Enter Book Quantity: ");
        int bookQuantity = scanner.nextInt();
        scanner.nextLine(); 
    
    Auther author = new Auther(authorID, authorName,  0, "", "");
        Book book = new Book(bookID, bookName, bookCategory, author, bookPublisher,
                bookEditionYear, bookPrice, bookQuantity);
        library.addBook(book);
    }

    private void deleteBook() {
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();
        Book book = library.searchBook(bookName);
        if (book != null) {
            library.deleteBook(book);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private void searchBook() {
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();
        Book book = library.searchBook(bookName);
        if (book != null) {
            System.out.println(book);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private void buyBook() {
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();
        Book book = library.searchBook(bookName);
        if (book != null) {
            System.out.print("Enter Student ID: ");
            int studentID = scanner.nextInt();
            System.out.print("Enter Student Name: ");
            String studentName = scanner.nextLine();
            System.out.print("Enter Student Gender: ");
            String studentGender = scanner.nextLine();
            System.out.print("Enter Student Phone: ");
            String studentPhone = scanner.nextLine();
            System.out.print("Enter Student Address: ");
            String studentAddress = scanner.nextLine();
            System.out.print("Enter Student Specialization: ");
            String specialization = scanner.nextLine();
            System.out.print("Enter Student Enrolled Date: ");
            String enrolledDate = scanner.nextLine();
            System.out.print("Enter Student Budget: ");
            double budget = scanner.nextDouble();
            scanner.nextLine(); 

            Student student = new Student(studentID, studentName, studentGender, studentPhone, studentAddress, specialization, enrolledDate, budget);
            library.buyBook(book, student);
        } else {
            System.out.println("Book not found in the library.");
        }
    }

    private void addStudent() {
        System.out.print("Enter Student ID: ");
        int studentID = scanner.nextInt();
        System.out.print("Enter Student Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student Gender: ");
        String studentGender = scanner.nextLine();
        System.out.print("Enter Student Phone: ");
        String studentPhone = scanner.nextLine();
        System.out.print("Enter Student Address: ");
        String studentAddress = scanner.nextLine();
        System.out.print("Enter Student Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Student Enrolled Date: ");
        String enrolledDate = scanner.nextLine();
        System.out.print("Enter Student Budget: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); 
        Student student = new Student(studentID, studentName, studentGender, studentPhone, studentAddress, specialization, enrolledDate, budget);
        library.addStudent(student);
    }
}
