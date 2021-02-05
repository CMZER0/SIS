import java.io.IOException;

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
	r.displayStudents();
        mainMenu();

        System.out.println("Pull on 2.1.21");


        r.fillStudentList();
        r.fillCourses();
        r.calculateGPA();
        r.createLastNames();
        mainMenu();

    }

   
    private static void mainMenu(Roster r) {
        // NOTE: Most methods should be able to be coded into the Roster class.
        // with that said, please don't code into the Main class. thx!
      
        try {
            Scanner input = new Scanner(System.in);
            System.out.print(
                    "Main Menu\n1) Sort Students\n2) Add/Delete Students\n3) Change Students Grade or Schedule\n4) Exit\n");
            int userIn = input.nextInt();
            switch (userIn) {
                case 1:
                    sortStudents();
                    break;
                case 2:
                    addOrDeleteStudent();
                    break;
                case 3:
                    changeGradeOrSchedule();
                    break;
                case 4:
                    System.exit(0);
            }
            mainMenu();
        } catch (InputMismatchException e) {
            System.out.println("Sorry, that was not a valid input.");
            mainMenu();
        }
    }

    private static void addOrDeleteStudent() {
	Scanner input = new Scanner(System.in);
        System.out.print("Would you like to \n1) Add Student \n2) Delete Student");
        int userIn = input.nextInt();
        if(userIn == 1)
        {
        r.addStudent();
        }
        else
        {
         r.deleteStudent();
        }
       
    }

    private static void changeGradeOrSchedule() {
      
	try {
	Scanner input = new Scanner(System.in);
        System.out.print("Would you like to \n1) Change Student's Schedule \n2) Change Student's Grade");
        int userIn = input.nextInt();
        if(userIn == 1)
        {
        r.changeSchedule();
        }
        else
        {
         r.changeGrade();
        }
	}
	catch (InputMismatchException e) {
	    System.out.println("Sorry, that was not a valid input.");
            sortStudents();
	}
	
    }

    private static void sortStudents() {
        try {
            Scanner sortChoiceInp = new Scanner(System.in);
            System.out.println("Sort Students\n1) Sort by GPA\n2) Sort by Last Name\n3) Sort by Period");
            int sortChoice = sortChoiceInp.nextInt();
            switch (sortChoice) {
                case 1:
                    r.sortByGPA();
                    break;
                case 2:
                    r.sortByLastName();
                    break;
                case 3:
                    r.sortByPeriod();
                    break;
            }
            r.displayStudents();
        } catch (InputMismatchException e) {
            System.out.println("Sorry, that was not a valid input.");
            sortStudents();
        }
    }
}
