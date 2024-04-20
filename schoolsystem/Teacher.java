
package schoolsystem;

import java.io.Serializable;

class Teacher extends Employee  implements Serializable{
    

    public Teacher(String name, int id, String address, String phoneNumber, String email, double basicSalary, int classesTaught1) {
    }

    public Teacher(String name, int id, String address, String phoneNumber, String email, double basicSalary
             ) {
        super(name, id, address, phoneNumber, email, basicSalary);
        
    }

    public Teacher(Teacher teacher) {
        super(teacher.getName(), teacher.getId(), teacher.getAddress(), teacher.getPhoneNumber(), teacher.getEmail(),
                teacher.getBasicSalary());
        
    }

   
    

    @Override
    public double getSalary() {
        return super.getSalary() ;
    }

    @Override
    public String toString() {
        return super.toString() ;
    }
}
