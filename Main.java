// Objectives given here: https://docs.google.com/document/d/1VyqRG5wR3q0exFC8klmNL9SVNYCZzdsOd8hYDabRpMk/edit
public class Main {
    public static void main(String[] args) {
        // Leader: Cole
        // Members: Amanda, Ben, Owen
        //mainMenu();
    	
    	Roster r = new Roster();
    	r.addStudents();
    
        
    }

    private static void mainMenu() {
        // NOTE: All methods should be able to be coded into the Roster class.
        // with that said, please don't code into the Main class. thx!
        addOrDeleteStudent();
        changeGradeOrSchedule();
        sortStudents();
    }

    private static void addOrDeleteStudent() {
        // addStudent();
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