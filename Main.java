import java.io.IOException;

// Objectives given here: https://docs.google.com/document/d/1VyqRG5wR3q0exFC8klmNL9SVNYCZzdsOd8hYDabRpMk/edit
public class Main {
    static Roster r = new Roster();

    public static void main(String[] args) throws IOException {
        // Leader: Cole
        // Members: Amanda, Ben, Owen

        mainMenu(r);


    }

    private static void mainMenu(Roster r) {
        // NOTE: Most methods should be able to be coded into the Roster class.
        // with that said, please don't code into the Main class. thx!
        addOrDeleteStudent(r);
        changeGradeOrSchedule();
        sortStudents();
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
        // sortLastName();
        // sortGPA();
        // sortPeriod();
    }
}