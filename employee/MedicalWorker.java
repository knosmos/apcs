/*
Medical Worker class; builds on Employee by adding list of patients
*/

import java.util.Arrays;
public class MedicalWorker extends Employee {
    private String[] patients;
    public MedicalWorker(String position, String name, String[] patients, int salary) {
        super(position, name, salary);
        this.patients = patients;
    }
    public String[] getPatients() {
        return patients;
    }
    public String toString() {
        return super.toString() + " | Patients: " + Arrays.toString(getPatients());
    }
}