/*
Doctor class. Builds on MedicalWorker class by adding a specialty field.
*/

public class Doctor extends MedicalWorker {
    private String specialty;
    public Doctor(String name, String specialty, String[] patients, int salary) {
        super("Doctor", name, patients, salary);
        this.specialty = specialty;
    }
    public String getSpecialty() {
        return specialty;
    }
    public String toString() {
        return super.toString() + " | Specialty: " + specialty;
    }
    public void treatPatients() {
        for (String p : getPatients()) {
            System.out.println("Treating " + p + "... done");
        }
    }
}