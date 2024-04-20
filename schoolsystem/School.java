
package schoolsystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;



 class School implements Serializable {
    ArrayList<Student> students;
    Principal principal;
    ArrayList<Teacher> teachers;
     ArrayList<Subject> subjects;

    public School() {
        students = new ArrayList<>();
        teachers = new ArrayList<>();
        subjects = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public void displaySubjects() {
        if (subjects.isEmpty()) {
            System.out.println("No subjects available.");
        } else {
            for (int i = 0; i < subjects.size(); i++) {
                System.out.println(subjects.toString());
            }
            }
        }
    

    public void displayEmployeesSalaries() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select employee type: ");
        System.out.println("1. Principal");
        System.out.println("2. Teacher");
        int choice = scanner.nextInt();
        scanner.nextLine(); 

        switch (choice) {
            case 1:
                System.out.println(principal.getSalary());
                break;
            case 2:
                for (int i = 0; i < teachers.size(); i++) {
                    System.out.println(teachers.get(i).getSalary());
                }
                
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public void countStudentsInSubject() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the subject name: ");
        String subjectName = scanner.nextLine();

        int count = 0;
        for (Subject subject : subjects) {
            if (subject.getName().equalsIgnoreCase(subjectName)) {
                count++;
            }
        }

        System.out.println("Number of students registered in " + subjectName + ": " + count);
    }

    public void saveDataToFile() throws FileNotFoundException, IOException {
        
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("project.dat"));
            out.writeObject(students);
            out.writeObject(teachers);
            out.writeObject(subjects);
            out.close();
            
            
        
    }

    public void readDataFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("project.dat"));
            students = (ArrayList<Student>) in.readObject();
            teachers = (ArrayList<Teacher>) in.readObject();
            subjects = (ArrayList<Subject>) in.readObject();
            in.close();
            
           
        
    }
}
    