
package baraaa;

import java.io.Serializable;


public class Person implements Serializable {
    int personIdentityNumber;
    String personName;
    String personGender;
    String personPhone;
    String personAddress;

    public Person() {
    }

    public Person(int personIdentityNumber, String personName, String personGender, String personPhone, String personAddress) {
        this.personIdentityNumber = personIdentityNumber;
        this.personName = personName;
        this.personGender = personGender;
        this.personPhone = personPhone;
        this.personAddress = personAddress;
    }

    
    
    
    
    public int getPersonIdentityNumber() {
        return personIdentityNumber;
    }

    public void setPersonIdentityNumber(int personIdentityNumber) {
        this.personIdentityNumber = personIdentityNumber;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getPersonGender() {
        return personGender;
    }

    public void setPersonGender(String personGender) {
        this.personGender = personGender;
    }

    public String getPersonPhone() {
        return personPhone;
    }

    public void setPersonPhone(String personPhone) {
        this.personPhone = personPhone;
    }

    public String getPersonAddress() {
        return personAddress;
    }

    public void setPersonAddress(String personAddress) {
        this.personAddress = personAddress;
    }

      
    
    
    @Override
    public String toString() {
        return "Person{" + "personIdentityNumber=" + personIdentityNumber + ", personName=" + personName + ", personGender=" + personGender + ", personPhone=" + personPhone + ", personAddress=" + personAddress + '}';
    }
    
    
    
    
}
