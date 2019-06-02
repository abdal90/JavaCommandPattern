package registrations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GRClass {

    // track number of seats, class name, location, enrolled students
    private String name;
    private String location;
    private int seats;

    // students enrolled or on the waiting list
    private List<Student> enrolledStudents = new ArrayList<>();
    private List<Student> waitListedStudents = new ArrayList<>();

    public GRClass(String name, String location, int seats) {
        this.name = name;
        this.location = location;
        this.seats = seats;
    }

    public void registerStudent(Student student){
        // quietly ignore unsuccessful registrations
        if (!hasStudent(student)){
            // is the class full?
            if (enrolledStudents.size() == seats){
                // add the student to the waitlist
                waitListedStudents.add(student);
            }else {
                enrolledStudents.add(student);
            }
        }
    }

    public void dropStudent(Student student){
        if (hasStudent(student)){
            // wait list
            if (waitListedStudents.contains(student)){
                waitListedStudents.remove(student);
            }else{
                enrolledStudents.remove(student); //should be successful

                if (waitListedStudents.size() > 0){
                    enrolledStudents.add(waitListedStudents.get(0));
                }
            }
        }
    }

    public boolean hasStudent(Student student){
        // determine if the student is enrolled or on the wait list

        return enrolledStudents.contains(student) || waitListedStudents.contains(student);
    }



    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public int getSeats() {
        return seats;
    }

    public List<Student> getEnrolledStudents() {
        return Collections.unmodifiableList(enrolledStudents);
    }

    public List<Student> getWaitListedStudents() {
        return Collections.unmodifiableList(waitListedStudents);
    }

    @Override
    public String toString() {
        return name;
    }
}
