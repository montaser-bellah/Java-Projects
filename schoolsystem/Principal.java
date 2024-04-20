
package schoolsystem;

import java.io.Serializable;

class Principal extends Employee  implements Serializable{
    private double principalBonus;

    public Principal() {
    }

    public Principal(String name, int id, String address, String phoneNumber, String email, double basicSalary,
             double principalBonus) {
        super(name, id, address, phoneNumber, email, basicSalary);
        this.principalBonus = principalBonus;
    }

    public double getPrincipalBonus() {
        return principalBonus;
    }

    public void setPrincipalBonus(double principalBonus) {
        this.principalBonus = principalBonus;
    }

    @Override
    public double getSalary() {
        return super.getSalary() + principalBonus;
    }

    @Override
    public String toString() {
        return super.toString() + "\nPrincipal Bonus: " + principalBonus;
    }
}