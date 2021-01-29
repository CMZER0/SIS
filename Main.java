// Objectives given here: https://docs.google.com/document/d/1VyqRG5wR3q0exFC8klmNL9SVNYCZzdsOd8hYDabRpMk/edit
public class Main {

    public static void main(String[] args) {
        // Leader: Cole
        // Members: Amanda, Ben, Owen
        mainMenu();
    }

    private static void mainMenu() {
        // NOTE: Most methods should be able to be coded into the Roster class.
        // with that said, please don't code into the Main class. thx!
        Roster r = new Roster();
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