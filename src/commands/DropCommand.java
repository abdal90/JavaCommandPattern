package commands;

import registrations.GRClass;
import registrations.Student;

public class DropCommand extends AbstractEnrollementCommand{

    public DropCommand(Student student, GRClass aClass) {
        super(student, aClass);
    }

    @Override
    public void execute() {
      dropStudent();
    }

    @Override
    public void unexecute() {

        if (!somethingChange){
            registerStudent();
        }
    }
}
