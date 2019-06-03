package commands;

import registrations.GRClass;
import registrations.Student;

public abstract class AbstractEnrollementCommand implements ICommand {

    protected Student student;
    protected GRClass aClass;
    protected boolean somethingChange;

    public AbstractEnrollementCommand(Student student, GRClass aClass) {
        this.student = student;
        this.aClass = aClass;
    }

    public void registerStudent(){
        // drop student from the class
        somethingChange = aClass.dropStudent(student);


        System.out.println(student.getName() + " registered for " + aClass.getName());
    }

    public void dropStudent(){
        // drop student from the class
        somethingChange = aClass.dropStudent(student);


        System.out.println(student.getName() + " dropped for " + aClass.getName());
    }
}
