import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.io.IOException;
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

	public void removeStudent(int index) {
		studentList.remove(index);
	}

	public int classSize() {
		return studentList.size();
	}

	//////////////
	// METHODS //
	/////////////

	public void fillStudentList() throws IOException // Gets student names, creates Student objects, assigns Student
														// name,and puts them in studentList
	{
		Scanner studentFile = new Scanner(new File("StudentList.txt"));// Scanner that grabs the Student List

		while (studentFile.hasNext()) {
			String firstName = studentFile.next();
			String lastName = studentFile.next();
			studentFile.nextLine();
			addNewStudent(firstName + " " + lastName);
		}

	}

	public void fillCourses() throws IOException // Gets courses from text file and puts them in courses AL
	{
		Scanner courseFile = new Scanner(new File("StudentList.txt"));

		for (int i = 0; i < studentList.size(); i++) {
			courseFile.next();
			courseFile.next();
			String per1Class = courseFile.next();
			String per1LetterGrade = courseFile.next();
			String per2Class = courseFile.next();
			String per2LetterGrade = courseFile.next();
			String per3Class = courseFile.next();
			String per3LetterGrade = courseFile.next();

			double per1NumberGrade = gradeConverter(per1LetterGrade);
			double per2NumberGrade = gradeConverter(per2LetterGrade);
			double per3NumberGrade = gradeConverter(per3LetterGrade);

			getStudent(i).getTranscript().add(new Course(per1Class, per1LetterGrade, per1NumberGrade));
			getStudent(i).getTranscript().add(new Course(per2Class, per2LetterGrade, per2NumberGrade));
			getStudent(i).getTranscript().add(new Course(per3Class, per3LetterGrade, per3NumberGrade));
		}
	}

	public double gradeConverter(String letterGrade) // converts the given letter grade and returns the number grade(on
														// a 4pt scale)
	{
		double numberGrade;
		if (letterGrade.equals("A+")) {
			numberGrade = 4.0;
		} else if (letterGrade.equals("A")) {
			numberGrade = 4.0;
		} else if (letterGrade.equals("A-")) {
			numberGrade = 3.7;
		} else if (letterGrade.equals("B+")) {
			numberGrade = 3.3;
		} else if (letterGrade.equals("B")) {
			numberGrade = 3.0;
		} else if (letterGrade.equals("B-")) {
			numberGrade = 2.7;
		} else if (letterGrade.equals("C+")) {
			numberGrade = 2.3;
		} else if (letterGrade.equals("C")) {
			numberGrade = 2.0;
		} else if (letterGrade.equals("C-")) {
			numberGrade = 1.7;
		} else if (letterGrade.equals("D+")) {
			numberGrade = 1.3;
		} else if (letterGrade.equals("D")) {
			numberGrade = 1.0;
		} else if (letterGrade.equals("D-")) {
			numberGrade = 0.7;
		} else {
			numberGrade = 0;
		}

		return numberGrade;
	}

	private static DecimalFormat df2 = new DecimalFormat("#.##");

	public void displayTranscript() {
		for (int i = 0; i < studentList.size(); i++) {
			System.out.println();
			System.out.printf(i + ") " + studentList.get(i).getName() + " " + studentList.get(i).getCourse(0).getName()
					+ " " + studentList.get(i).getCourse(0).getLetterGrade() + " "
					+ studentList.get(i).getCourse(1).getName() + " " + studentList.get(i).getCourse(1).getLetterGrade()
					+ " " + studentList.get(i).getCourse(2).getName() + " "
					+ studentList.get(i).getCourse(2).getLetterGrade() + " GPA: "
					+ df2.format(studentList.get(i).getGPA()));

		}
	}

	public void calculateGPA() // calculates and assigns student GPA
	{
		for (int i = 0; i < studentList.size(); i++) {
			double calculatedGPA;
			calculatedGPA = (studentList.get(i).getCourse(0).getGrade() + studentList.get(i).getCourse(1).getGrade()
					+ studentList.get(i).getCourse(2).getGrade()) / 3;
			studentList.get(i).setGPA(calculatedGPA);
		}
	}

	public void sortByGPA() // sorts student list by GPA (highest to lowest)
	{
		Collections.sort(studentList, new SortByGPA());
	}

	public void sortByLastName() // sorts student list in alphabetical order by last name
	{
		Collections.sort(studentList, new SortByLast());
	}

	public static String createLastName(String name) // outputs the last name from a full name input
	{
		String lastName;
		lastName = name.substring(name.indexOf(" "), name.length());
		return lastName;
	}

	public void createLastNames() // sets each students last name
	{
		for (int i = 0; i < studentList.size(); i++) {
			studentList.get(i).setLastName(createLastName(studentList.get(i).getName()));
		}
	}

	public void sortByPeriod() // sorts student list by period
	{
		Collections.sort(studentList, new SortByPeriod());
	}

	public void deleteStudent() {
		displayStudents();
		Scanner userInp = new Scanner(System.in);
		System.out.println("Select what student you would like to delete");
		int choice = userInp.nextInt();
		System.out.println(getStudent(choice).getName() + " will be removed.");
		removeStudent(choice);
	}

	public void addStudent() {
		Scanner userInp = new Scanner(System.in);
		System.out.println("What is the name of your new student?");
		String Name = userInp.nextLine();
		addNewStudent(Name);
		

		for (int i = 0; i < 3; i++) {
			int p = i + 1;
			System.out.println("Please enter course " + p + " name:");
			String course = userInp.nextLine();
			System.out.println("Please enter course " + p + " grade:");
			String grade = userInp.nextLine();
			getStudent(classSize() - 1).getTranscript().add(new Course(course, grade, gradeConverter(grade)));
		}
		studentList.get(studentList.size()-1).setLastName(createLastName(Name));
		double calculatedGPA = 0;
		calculatedGPA = (studentList.get(studentList.size()-1).getCourse(0).getGrade() + studentList.get(studentList.size()-1).getCourse(1).getGrade()
			+ studentList.get(studentList.size()-1).getCourse(2).getGrade()) / 3;
	studentList.get(studentList.size()-1).setGPA(calculatedGPA);
		displayStudents();
		
	}

	public void displayStudents() {
		for (Student s : studentList) {
			System.out.print("\n[" + studentList.indexOf(s) + "] " + s.getName() + "| ");
			for (Course c : s.getTranscript()) {
				System.out.print(c.getName() + ": " + c.getLetterGrade() + ", ");
			}
			System.out.print("GPA: " + df2.format(s.getGPA()));
		}
		System.out.print("\n\n");
	}
	
	  
	    public void changeSchedule()
	    {
	    	//Note from 2-2-21: Should work as long as we get numbers on the student list
		System.out.println();
	    	Scanner userInput = new Scanner(System.in);
	    	System.out.println("Which student's schedule would you like to change?");
	    	displayStudents();
	    	int choice = userInput.nextInt();
	    	
	    	Scanner firstClassInput = new Scanner(System.in);
	    	System.out.println("What is the student's first class?");
	    	String courseOne = firstClassInput.nextLine();
	    	getStudent(choice).getCourse(0).setName(courseOne);
	    	
	    	Scanner gradeOneInput = new Scanner(System.in);
	    	System.out.println("What is the student's first class grade?");
	    	String gradeOne = gradeOneInput.nextLine();
	    	getStudent(choice).getCourse(0).setLetterGrade(gradeOne);
	    	
	    	Scanner secondClassInput = new Scanner(System.in);
	    	System.out.println("What is the student's second class?");
	    	String courseTwo = secondClassInput.nextLine();
	    	getStudent(choice).getCourse(1).setName(courseTwo);
	    	
	    	Scanner gradeTwoInput = new Scanner(System.in);
	    	System.out.println("What is the student's second class grade?");
	    	String gradeTwo = gradeTwoInput.nextLine();
	    	getStudent(choice).getCourse(1).setLetterGrade(gradeTwo);
	    	
	    	Scanner thirdClassInput = new Scanner(System.in);
	    	System.out.println("What is the student's third class?");
	    	String courseThree = thirdClassInput.nextLine();
	    	getStudent(choice).getCourse(2).setName(courseThree);
	    	
	    	Scanner gradeThreeInput = new Scanner(System.in);
	    	System.out.println("What is the student's third grade?");
	    	String gradeThree = gradeThreeInput.nextLine();
	    	getStudent(choice).getCourse(2).setLetterGrade(gradeThree);
	    	
	    	studentList.get(choice).getCourse(0).setGrade(gradeConverter(gradeOne));
	    	studentList.get(choice).getCourse(1).setGrade(gradeConverter(gradeTwo));
	    	studentList.get(choice).getCourse(2).setGrade(gradeConverter(gradeThree));
	    	
	    	
	    	
	    	double calculatedGPA;
		calculatedGPA = (studentList.get(choice).getCourse(0).getGrade() + studentList.get(choice).getCourse(1).getGrade()
				+ studentList.get(choice).getCourse(2).getGrade()) / 3;
		studentList.get(choice).setGPA(calculatedGPA);
	    	displayStudents();
	    	
	    	
	    }
	    
	    
	    public void changeGrade()
	    {
	    	System.out.println();
	    	Scanner userInput = new Scanner(System.in);
	    	System.out.println("Which student's grade would you like to change?");
	    	displayStudents();
	    	int choice = userInput.nextInt();
	    	System.out.println(" ");
	    	
	    	Scanner gradeOneInput = new Scanner(System.in);
	    	System.out.println("What is the student's first grade?");
	    	String gradeOne = gradeOneInput.nextLine();
	    	getStudent(choice).getCourse(0).setLetterGrade(gradeOne);
	    	
	    	Scanner gradeTwoInput = new Scanner(System.in);
	    	System.out.println("What is the student's second grade?");
	    	String gradeTwo = gradeTwoInput.nextLine();
	    	getStudent(choice).getCourse(1).setLetterGrade(gradeTwo);
	    	
	    	Scanner gradeThreeInput = new Scanner(System.in);
	    	System.out.println("What is the student's third grade?");
	    	String gradeThree = gradeThreeInput.nextLine();
	    	getStudent(choice).getCourse(2).setLetterGrade(gradeThree);
	    	studentList.get(choice).getCourse(0).setGrade(gradeConverter(gradeOne));
	    	studentList.get(choice).getCourse(1).setGrade(gradeConverter(gradeTwo));
	    	studentList.get(choice).getCourse(2).setGrade(gradeConverter(gradeThree));
	    	
	    	
	    	
	    	double calculatedGPA;
		calculatedGPA = (studentList.get(choice).getCourse(0).getGrade() + studentList.get(choice).getCourse(1).getGrade()
				+ studentList.get(choice).getCourse(2).getGrade()) / 3;
		studentList.get(choice).setGPA(calculatedGPA);
	    	displayStudents();
	    }
}

