/* Generic Employee class, storing name, salary, and position of an employee as well as a toString method */

public class Employee {
    private String name;
    private int salary;
    private String position;

    public Employee(String position, String name, int salary) {
        this.position = position;
        this.name = name;
        this.salary = salary;
    }
    public String getName() {
        return name;
    }
    public int getSalary() {
        return salary;
    }
    public String getPosition() {
        return position;
    }
    public void setSalary(int salary) {
        this.salary = salary;
    }
    public void setPosition(String position) {
        this.position = position;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String toString() {
        return String.format("%s (%s) => Salary: $%d", getName(), getPosition(), getSalary());
    }
}