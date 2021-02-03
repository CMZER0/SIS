import java.io.IOException;
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

        System.out.println("Pull on 2.1.21");

    }

    private static void mainMenu(Roster r) {
        // NOTE: Most methods should be able to be coded into the Roster class.
        // with that said, please don't code into the Main class. thx!
	System.out.println("Would you like to 1 sort the students, 2 add or delete students, or 3 change a students grade or schedule?");
        Scanner actionChoiceInp = new Scanner(System.in);
        int actionChoice = actionChoiceInp.nextInt();
        if(actionChoice == 1)
        {
            sortStudents();
        }
        else if(actionChoice == 2)
        {
            addOrDeleteStudent(r);
        }
        else
        {
            changeGradeOrSchedule();
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
        if(sortChoice == 1)
        {
            r.sortByGPA();
        }
        else if(sortChoice == 2)
        {
            r.sortByLastName();
        }
        else
        {
            r.sortByPeriod();
        }
        
	r.displayStudents();
        
    }
}