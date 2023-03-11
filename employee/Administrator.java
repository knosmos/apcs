/*
Administrator class. Contains a list of employees under their supervision.
*/

import java.util.ArrayList;
public class Administrator extends Employee {
    private ArrayList<Employee> employees;
    public Administrator(String name, int salary, ArrayList<Employee> employees) {
        super("Administrator", name, salary);
        this.employees = employees;
    }
    public ArrayList<Employee> getEmployees() {
        return employees;
    }
    public String toString() {
        String res = super.toString() + " Employees: [\n";
        for (Employee e : employees) {
            res += "    " + e.toString() + ",\n";
        }
        res += "]";
        return res;
    }
    public void embezzleFunds() {
        System.out.println("Embezzling funds...");
        System.out.println("Funds embezzled!");
    }
}