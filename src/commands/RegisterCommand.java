package commands;

import registrations.GRClass;
import registrations.Student;

public class RegisterCommand extends AbstractEnrollementCommand{

   private boolean somethingChange = false;

    public RegisterCommand(Student student, GRClass aClass) {
        super(student, aClass);
    }

    @Override
    public void execute() {
      registerStudent();
    }

    @Override
    public void unexecute() {
        if (somethingChange){
           dropStudent();
        }
    }
}
