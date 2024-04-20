
/*
??? ??????? ?? ?????: ?????? ?????????? ??????,
??? ??????? ???????? 6 ???????,
??? ??????????? ???????? ???? ?? ???? ?????,
?? ???? ??????? ???: 
• ????? ?? ?????? ?? ????????? 
• ??????????? 
• ??????????? 
• ???????? ????? 
• ?????? ????,
?????? ????????: ??? ??????? ,, ??? ??????? ,, ??? ???????? ,,
??????? ????????  ,, ??????? ???????? ,, ??????? ????????? (^_^)?
*/

package schoolsystem;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;



import java.util.Scanner;


public class SchoolSystem  {
   
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException  {
        
        
           System.out.println("- ??????? ?? ?? ??????? ?? ");
        
        System.out.println("- ??? ??????? ??? ???????? ?? ?‍: ????? ???? ???? && ?‍: ????? ??? ????? ");
        
        System.out.println("- ?????? ?? ??? ???????? ?: ??????? ?????? ?");
        
        System.out.println("- ?? ???? ?? ??? ???? ????? ? ");
        
        System.out.println("_______________________________________________________________________________");
       
        
        School school = new School();
        File file = new File("project.dat");
        if (file.exists()) {
            FileInputStream fileIn = new FileInputStream(file);
            if (fileIn.read() != -1) {
                school.readDataFromFile();
            }
        }
         
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
           
            System.out.println("1- Add Employee");
            System.out.println("2- Add Student");
            System.out.println("3- Add Subject");
            System.out.println("4- Show Subjects");
            System.out.println("5- Show Employees Salaries");
            System.out.println("6- Count of students in a subject");
            System.out.println("7- Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.println("Select employee type: ");
                    System.out.println("1. Principal");
                    System.out.println("2. Teacher");
                    int employeeType = scanner.nextInt();
                    scanner.nextLine(); 

                    System.out.println("Enter employee details:");
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Basic Salary: ");
                    double basicSalary = scanner.nextDouble();
                    scanner.nextLine(); 
                    

                    if (employeeType == 1 || employeeType == 2) {
                        System.out.print("Principal Bonus: ");
                        double principalBonus = scanner.nextDouble();
                        scanner.nextLine(); 

                        Principal principal = new Principal(name, id, address, phoneNumber, email, basicSalary,
                                 principalBonus);
                        school.principal = principal;
                    

                        Teacher teacher = new Teacher(name, id, address, phoneNumber, email, basicSalary
                               );
                        school.addTeacher(teacher);
                    } else {
                        System.out.println("Invalid choice");
                    }
                    break;
                case 2:
                    System.out.println("Enter student details:");
                    System.out.print("ID: ");
                    int studentId = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Name: ");
                    String studentName = scanner.nextLine();
                    System.out.print("Level: ");
                    String level = scanner.nextLine();
                      
                    Student student = new Student(studentId, studentName, level);
                    school.addStudent(student);
                    break;
                case 3:
                    System.out.println("Enter subject details:");
                    System.out.print("Name: ");
                    String subjectName = scanner.nextLine();
                    System.out.println("Available Teachers:");
                    for (Teacher teacher : school.teachers) {
                        System.out.println("Name: " + teacher.getName() + ", ID: " + teacher.getId());
                    }
                    System.out.print("Enter Teacher ID: ");
                    int teacherId = scanner.nextInt();
                    
                    Teacher t = null ;
                    for (int i = 0; i < school.teachers.size(); i++) {
                        if (school.teachers.get(i).getId() == teacherId ) {
                             t = school.teachers.get(i);
                        }
                    }
                    scanner.nextLine(); 
                   

                    System.out.println("Available Students:");
                    for (Student s : school.students) {
                        System.out.println("Name: " + s.getName() + ", ID: " + s.getId());
                    }
                    System.out.print("Enter Student ID: ");
                    int STU = scanner.nextInt();
                    Student S = null;
                    for (int i = 0; i < school.students.size(); i++) {
                        if (school.students.get(i).getId() == STU ) {
                             S = school.students.get(i) ;
                        }else{
                            System.out.println("enter id of the student again : ");
                        }
                    }
                    scanner.nextLine(); 
                    
                    Subject subject = new Subject(subjectName, t, S);
                    school.addSubject(subject);
                    break;
                case 4:
                    school.displaySubjects();
                    break;
                case 5:
                    school.displayEmployeesSalaries();
                    break;
                case 6:
                    school.countStudentsInSubject();
                    break;
                case 7:
                    school.saveDataToFile();
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }
        } while (choice != 7);
    }
}

        
      
    
