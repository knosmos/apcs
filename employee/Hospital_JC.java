/*
Design and implement a set of classes that define the employees of a hospital: doctor, nurse, administrator. Include methods
in each class that are named according to the services provided by that person and that print an appropriate message. Create
a main driver class to instantiate several of the classes.

Jieruei Chang
Java 18.0.1.1
3/10/2023
*/

import java.util.ArrayList;
public class Hospital_JC {
    public static void main(String[] args) {
        // Demonstrate all Hospital Employee classes
        ArrayList<Employee> employees = new ArrayList<Employee>();
        employees.add(new Doctor("Schneize von Kopff", "Infectious Diseases", new String[] {"Alice", "Bob"}, 100000));
        employees.add(new Doctor("Hart Vintrical", "Cardiology", new String[] {"Carol", "Donald", "Ellie"}, 130000));
        employees.add(new Nurse("Mary", new String[] {"Felix", "Gertie", "Harold", "Indy"}, 50000));
        
        Administrator admin = new Administrator("Ebenezer Scrooge", 200000, employees);
        
        // Print
        System.out.println("Hospital Employees:");
        System.out.println(admin);
        System.out.println();

        // Use various services of different employees
        Doctor vonKopff = (Doctor) employees.get(0);
        System.out.println(vonKopff.getName() + ": treating patients...");
        vonKopff.treatPatients();
        System.out.println();

        Nurse mary = (Nurse) employees.get(2);
        System.out.println(mary.getName() + ": checking patient vitals...");
        mary.checkVitals();
        System.out.println();

        System.out.println(admin.getName() + ": embezzling funds...");
        admin.embezzleFunds();
        System.out.println();

        // Show how "is-a" relationship works by checking if two different objects from different classes are equal
        System.out.println("Is " + vonKopff.getName() + " equal to " + mary.getName() + "?");
        System.out.println(
            employees.get(0).equals(employees.get(2)) ? "von Kopff = Mary" : "von Kopff != Mary"
        );
    }
}

/*
OUTPUT.

Hospital Employees:
Ebenezer Scrooge (Administrator) => Salary: $200000 Employees: [
    Schneize von Kopff (Doctor) => Salary: $100000 | Patients: [Alice, Bob] | Specialty: Infectious Diseases,
    Hart Vintrical (Doctor) => Salary: $130000 | Patients: [Carol, Donald, Ellie] | Specialty: Cardiology,
    Mary (Nurse) => Salary: $50000 | Patients: [Felix, Gertie, Harold, Indy],
]

Schneize von Kopff: treating patients...
Treating Alice... done
Treating Bob... done

Mary: checking patient vitals...
Checking vitals for Felix... done
Checking vitals for Gertie... done
Checking vitals for Harold... done
Checking vitals for Indy... done

Ebenezer Scrooge: embezzling funds...
Embezzling funds...
Funds embezzled!

Is Schneize von Kopff equal to Mary?
von Kopff != Mary
*/