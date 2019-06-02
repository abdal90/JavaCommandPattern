package test_enrollments;

import registrations.GRClass;
import registrations.Student;

public class RegistrationsTest {

    public static void main(String[] args) {
        // get some classes and students to test with
        Student[] students = getStudents();
        GRClass[] classes = getClasses();
        // present a menu to the user to give them actions to perfrom
    }

    public static GRClass[] getClasses(){
        return new GRClass[] {new GRClass("IT 426", "TC 120", 4),
                new GRClass("IT 333", "TC 206", 4),
                new GRClass("IT 301", "KC 309", 4)};
    }



    public static Student[] getStudents(){
        return new Student[] {new Student("Lindsey"), new Student("Barrack"), new Student("Tyler"),
                new Student("Susan"), new Student("Joseph")};
    }

}
