
package schoolsystem;

import java.io.Serializable;

class Subject implements Serializable{
    private String name;
    private Teacher teacher;
    private Student student;

    public Subject() {
    }

    public Subject(String name, Teacher teacher, Student student) {
        this.name = name;
        this.teacher = teacher;
        this.student = student;
    }

    public String getName() {
        return name;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public Student getStudent() {
        return student;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Subject Details: \n" +
                "Name: " + name + "\n" +
                "Teacher: " + teacher.getName() + "\n" +
                "Student: " + student.getName();
    }
}