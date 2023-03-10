public class Doctor extends Employee {
    private String specialty;
    public Doctor(String name, String specialty, String[] patients, int salary) {
        super(name);
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
}