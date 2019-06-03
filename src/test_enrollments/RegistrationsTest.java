package test_enrollments;

import commands.CommandType;
import commands.ICommand;
import commands.RegisterCommand;
import registrations.GRClass;
import registrations.Student;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingDeque;

public class RegistrationsTest {

    private static Queue<ICommand> commandsQueue = new LinkedBlockingDeque<>();

    private static  Scanner console = new Scanner(System.in);

    private static Student[] students;
    private static GRClass[] classes;
    public static void main(String[] args) {
        // get some classes and students to test with
        students = getStudents();
        classes = getClasses();

        // present a menu to the user to give them actions to perfrom
        printMenuAndChoose();

        console.close();
    }

    public static void printMenuAndChoose(){

        while (true){
            printMenu();
            makeUserChoice();
        }

    }

    public static void printMenu(){
        // show menu options

        CommandType[] types = CommandType.values()
        for (int i = 0; i < types.length; i++) {
            System.out.println((i + 1) + ", " + types[i].toString());
        }
        // execute menu options
        System.out.println("x: execute all commands in the command queue");
        // print out as "undo" option

    }

    public static void makeUserChoice(){
        // perform the user's choice
        String choice = console.nextLine();
        switch (choice){
            case "1":
                registerStudent();
                break;
            case "2":
                dropStudent();
                break;
            case "x":
                executeQueueCommand();
                break;

        }
    }

    public static void executeQueueCommand(){
        while (!commandsQueue.isEmpty()
             ) {
            ICommand command = commandsQueue.remove();
            command.execute();

            // keep track of the executed command
            // can undo later
        }
    }

    public static void registerStudent(){
        ICommand register = new RegisterCommand(
                getStudentFromUSer(), getClassFromUser());
        commandsQueue.add(register);
    }

    public static void dropStudent(){
        ICommand drop = new RegisterCommand(
                getStudentFromUSer(), getClassFromUser());
        commandsQueue.add(drop);
    }

    public static Student getStudentFromUSer(){
        System.out.println("Enter a student name: ");
        String studentName = console.nextLine();
        for (int i = 0; i < students.length; i++) {
            if (students[i].getName().equals(studentName)){
                return students[i];
            }
        }
        throw new IllegalStateException("Error finding student: " + studentName);
    }

    public static GRClass getClassFromUser(){
        System.out.println("Enter a class name: ");
        String className = console.nextLine();
        for (int i = 0; i < classes.length; i++) {
            if (classes[i].getName().equals(className)){
                return classes[i];
            }
        }
        throw new IllegalStateException("Error finding classes: " + className);

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
