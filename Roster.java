import java.util.ArrayList;
import java.util.Scanner;

public class Roster {
    private ArrayList<Student> studentList = new ArrayList<>(); // ArrayList containing the list of students

    ///////////////////////
    // GETTERS & SETTERS //
    ///////////////////////

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent(int index) {
        return studentList.get(index);
    }

    public void setStudent(int index, Student element) {
        studentList.set(index, element);
    }

    public void addStudent(Student e) {
        studentList.add(e);
    }

    public void addStudent(int index, Student e) { // Overidden
        studentList.add(index, e);
    }

    public void addNewStudent(String name) {
        studentList.add(new Student(name));
    }

    public void addNewStudent(int index, String name) { // Overidden
        studentList.add(index, new Student(name));
    }

    //////////////
    // METHODS //
    /////////////
    
    
    public static void addStudent()
    {
    	Scanner userInp = new Scanner(System.in); 
    	System.out.println("What is the name of the student you would like to add?");
	    String student = userInp.nextLine();
	    // Add student to roster
	    
	    
	    	Scanner userInp2 = new Scanner(System.in); 
	    	System.out.println("What is the name of thr first class for this student");
		    String course1 = userInp2.nextLine();
		    
		    Scanner userInp3 = new Scanner(System.in); 
		    System.out.println("What is the grade for the first class for this student");
		    String grade1 = userInp3.nextLine();
		    
		    Scanner userInp4 = new Scanner(System.in); 
	    	System.out.println("What is the name of thr first class for this student");
		    String course2 = userInp4.nextLine();
		    
		    Scanner userInp5 = new Scanner(System.in); 
		    System.out.println("What is the grade for the first class for this student");
		    String grade2 = userInp5.nextLine();
		    
		    Scanner userInp6 = new Scanner(System.in); 
	    	System.out.println("What is the name of thr first class for this student");
		    String course3 = userInp6.nextLine();
		    
		    Scanner userInp7 = new Scanner(System.in); 
		    System.out.println("What is the grade for the first class for this student");
		    String grade3 = userInp7.nextLine();
		    
		    
		    
		    //set new student based on user imputted paramaters.
		    
	    
    }
    
    public static void deleteStudent()
    {
    	//display roster and grades
    	
    	Scanner userInp = new Scanner(System.in); 
    	System.out.println("Please select the roster number of the student you would like to delete");
	    int student = userInp.nextInt();
	    
	    //delete from roster and student list
    	
    	
    }

}
