/*
Nurse class. Extends MedicalWorker with checkVitals (nurse duty) method.
*/

import java.util.Arrays;
public class Nurse extends MedicalWorker {
    private String[] patients;
    public Nurse(String name, String[] patients, int salary) {
        super("Nurse", name, patients, salary);
    }
    public void checkVitals() {
        for (String p : getPatients()) {
            System.out.println("Checking vitals for " + p + "... done");
        }
    }
}