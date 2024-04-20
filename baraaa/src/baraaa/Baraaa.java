/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baraaa;
import java.io.*;
import java.util.Scanner;
public class Baraaa {
   static File file;
   static ObjectInputStream ois;
   static ObjectOutputStream oos;
   

public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("Library Management System");
            System.out.println("1. Show Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Delete a Book");
            System.out.println("4. Search for a Book");
            System.out.println("5. Buy a Book");
            System.out.println("6. Show Students");
            System.out.println("7. Add a Student");
            System.out.println("8. Generate Full Report");
            System.out.println("9. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    library.showBooks();
                    break;
                    
                    
                    
                case 2:
                    Book newBook = createBook(scanner);
                    library.addBook(newBook);
                    System.out.println("Book added successfully!");
                    break;
                    
                    
                    
                    
                case 3:
                    System.out.print("Enter the name of the book to delete: ");
                    scanner.nextLine();
                    String bookToDelete = scanner.nextLine();
                    Book book = library.searchBook(bookToDelete);
                    if (book != null) {
                        library.deleteBook(book);
                        System.out.println("Book deleted successfully!");
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                    
                    
                    
                    
                    
                case 4:
                    System.out.print("Enter the name of the book to search: ");
                    scanner.nextLine();
                    String bookToSearch = scanner.nextLine();
                    Book foundBook = library.searchBook(bookToSearch);
                    if (foundBook != null) {
                        System.out.println("Book found:");
                        System.out.println(foundBook);
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                    
                    
                    
                    
                    
                case 5:
                    System.out.print("Enter the name of the book to buy: ");
                    scanner.nextLine();
                    String bookToBuy = scanner.nextLine();
                    Book bookToPurchase = library.searchBook(bookToBuy);
                    if (bookToPurchase != null) {
                        library.buyBook(bookToPurchase);
                        System.out.println("Book purchased successfully!");
                    } else {
                        System.out.println("Book not found!");
                    }
                    break;
                    
                    
                    
                    
                case 6:
                    library.showStudents();
                    break;
                    
                    
                    
                case 7:
                    Student newStudent = createStudent(scanner);
                    library.addStudent(newStudent);
                    System.out.println("Student added successfully!");
                    break;
                    
                    
                    
                case 8:
                    library.FullReport();
                    break;
                    
                    
                    
                    
                case 9:
                   library.writeBooks();
                   library.writeStudents();
                    System.out.println("Exiting...");
                    break;
                    
                    
                    
                default:
                    System.exit(0);
                    System.out.println("Invalid choice! Please try again.");
            }

          System.out.println();
        } while (choice != 9);

        scanner.close();
    }
    

    
    
      private static Book createBook(Scanner scanner) {
        System.out.print("Enter Book ID: ");
        int bookId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Book Name: ");
        String bookName = scanner.nextLine();
        System.out.print("Enter Book Category: ");
        String category = scanner.nextLine();
        System.out.print("Enter Book Author's Identity Number: ");
        String authorIdentityNumber = scanner.nextLine();
        System.out.print("Enter Book Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Enter Book Edition Year: ");
        String editionYear = scanner.next();
        System.out.print("Enter Book Price: ");
        double price = scanner.nextDouble();
        System.out.print("Enter Book Quantity: ");
        int quantity = scanner.nextInt();

        System.out.print("Enter Author's Name: ");
        scanner.nextLine();
        String authorName = scanner.nextLine();
        System.out.print("Enter Author's Gender: ");
        String authorGender = scanner.nextLine();
        System.out.print("Enter Author's Phone: ");
        String authorPhone = scanner.nextLine();
        System.out.print("Enter Author's Address: ");
        String authorAddress = scanner.nextLine();
        System.out.print("Enter Author's Number of Books: ");
        int authorNumberOfBooks = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Author's Email: ");
        String authorEmail = scanner.nextLine();
        System.out.print("Enter Author's Workplace: ");
        String authorWorkplace = scanner.nextLine();
        
        

        Auther author = new Auther(authorIdentityNumber, authorName,
                authorNumberOfBooks, authorEmail, authorWorkplace);
        return new Book( bookName , bookId, category, authorName, publisher, editionYear, price, quantity);
    }

    private static Student createStudent(Scanner scanner) {
        System.out.print("Enter Student's Identity Number: ");
        int studentIdentityNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Student's Name: ");
        String studentName = scanner.nextLine();
        System.out.print("Enter Student's Gender: ");
        String studentGender = scanner.nextLine();
        System.out.print("Enter Student's Phone: ");
        String studentPhone = scanner.nextLine();
        System.out.print("Enter Student's Address: ");
        String studentAddress = scanner.nextLine();
        System.out.print("Enter Student's ID: ");
        String studentId = scanner.nextLine();
        System.out.print("Enter Student's Specialization: ");
        String specialization = scanner.nextLine();
        System.out.print("Enter Student's Enrolled Date: ");
        String enrolledDate = scanner.nextLine();
        System.out.print("Enter Student's Budget: ");
        double budget = scanner.nextDouble();

        return new Student(studentIdentityNumber , studentName, studentGender, studentPhone, studentAddress
                , specialization, enrolledDate, budget);
    }
}
