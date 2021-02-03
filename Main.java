import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

// Objectives given here: https://docs.google.com/document/d/1VyqRG5wR3q0exFC8klmNL9SVNYCZzdsOd8hYDabRpMk/edit
public class Main {
    static Roster r = new Roster();

    public static void main(String[] args) throws IOException {
        // Leader: Cole
        // Members: Amanda, Ben, Owen
        r.fillStudentList();
        r.fillCourses();
        r.calculateGPA();
        r.createLastNames();
        mainMenu(r);
    }

    private static void mainMenu(Roster r) {
        // NOTE: Most methods should be able to be coded into the Roster class.
        // with that said, please don't code into the Main class. thx!
        try {
            Scanner actionChoiceInp = new Scanner(System.in);
            System.out
                    .print("Main Menu\n1) Sort Students\n2) Add/Delete Students\n3) Change Students Grade Schedule\n");
            int actionChoice = actionChoiceInp.nextInt();
            switch (actionChoice) {
                case 1:
                    sortStudents();
                    break;
                case 2:
                    addOrDeleteStudent(r);
                    break;
                case 3:
                    changeGradeOrSchedule();
                    break;
            }
        } catch (InputMismatchException e) {
            System.out.println("Sorry, that was not a valid input.");
            mainMenu(r);
        }
    }

    private static void addOrDeleteStudent(Roster r) {
        r.addStudent();
        // removeStudent();
    }

    private static void changeGradeOrSchedule() {
        // changeGrade();
        // changeSchedule();
    }

    private static void sortStudents() {
        System.out.println("Would you like to 1 sort by GPA, 2 by last name, or 3 by period?");
        Scanner sortChoiceInp = new Scanner(System.in);
        int sortChoice = sortChoiceInp.nextInt();
        if (sortChoice == 1) {
            r.sortByGPA();
        } else if (sortChoice == 2) {
            r.sortByLastName();
        } else {
            r.sortByPeriod();
        }

        r.displayStudents();

    }
}