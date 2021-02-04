import java.io.File;
import java.text.DecimalFormat;
import java.util.Collections;
import java.util.InputMismatchException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

	public void addNewStudent(String firstName, String lastName) {
		studentList.add(new Student(firstName, lastName));
	}

	public void addNewStudent(int index, String firstName, String lastName) { // Overidden
		studentList.add(index, new Student(firstName, lastName));
	}

	public void removeStudent(int index) {
		studentList.remove(index);
	}

	public int getClassSize() {
		return studentList.size();
	}

	//////////////
	// METHODS //
	/////////////

	public void newStudentList() throws IOException // Gets, creates, and assings student names and objects
	{
		Scanner file = new Scanner(new File("StudentList.txt"));// Scanner that grabs the Student List
		while (file.hasNextLine()) {
			Scanner lineScanner = new Scanner(file.nextLine());
			addNewStudent(lineScanner.next(), lineScanner.next());
			while (lineScanner.hasNext()) {
				getStudent(studentList.size() - 1).getTranscript()
						.add(new Course(lineScanner.next(), lineScanner.next()));
			}
		}
		for (Student s : studentList) {
			s.setGPA();
		}
	}

	public void sortByGPA() { // sorts student list by GPA (highest to lowest)
		Collections.sort(studentList, new SortByGPA());
	}

	public void sortByLastName() { // sorts student list in alphabetical order by last name
		Collections.sort(studentList, new SortByLast());
	}

	public static String createLastName(String name) { // outputs the last name from a full name input

		String lastName;
		lastName = name.substring(name.indexOf(" "), name.length());
		return lastName;
	}

	public void createLastNames() { // sets each students last name
		for (int i = 0; i < studentList.size(); i++) {
			studentList.get(i).setLastName(createLastName(studentList.get(i).getName()));
		}
	}

	public void sortByPeriod() { // sorts student list by period

		Collections.sort(studentList, new SortByPeriod());
	}

	public void deleteStudent() {
		displayStudents();
		try {
			Scanner userInp = new Scanner(System.in);
			System.out.println("Index to remove: ");
			int choice = userInp.nextInt();
			removeStudent(choice);
		} catch (InputMismatchException e) {
			System.out.println("Sorry, that was not a valid input.");
			deleteStudent();
		}

	}

	public void addStudent() {
		try {
			Scanner userInp = new Scanner(System.in);
			System.out.println("Input name :");
			// addNewStudent(userInp.nextLine());
		} catch (InputMismatchException e) {
			System.out.println("Sorry, that was not a valid input.");
			addStudent();
		}

		// for (int i = 0; i < 3; i++) {
		// int p = i + 1;
		// System.out.println("Please enter course " + p + " name:");
		// String course = userInp.nextLine();
		// System.out.println("Please enter course " + p + " grade:");
		// String grade = userInp.nextLine();
		// getStudent(getClassSize() - 1).getTranscript().add(new Course(course, grade,
		// gradeConverter(grade)));
		// }

		displayStudents();
	}

	public void displayStudents() {
		DecimalFormat df2 = new DecimalFormat("#.##");
		for (Student s : studentList) {
			System.out.print("\n[" + studentList.indexOf(s) + "] " + s.getName() + "| ");
			for (Course c : s.getTranscript()) {
				System.out.print(c.getName() + ": " + c.getLetterGrade() + ", ");
			}
			System.out.print("GPA: " + df2.format(s.getGPA()));
		}
		System.out.print("\n\n");
	}
}
