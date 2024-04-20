
package schoolsystem;
import java.io.Serializable;

class Student implements Serializable{
    private int id;
    private String name;
    private String level;

    public Student() {
    }

    public Student(int id, String name, String level) {
        this.id = id;
        this.name = name;
        this.level = level;
    }

    public Student(Student student) {
        this.id = student.getId();
        this.name = student.getName();
        this.level = student.getLevel();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLevel() {
        return level;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "Student Details: \n" +
                "ID: " + id + "\n" +
                "Name: " + name + "\n" +
                "Level: " + level;
    }
}
