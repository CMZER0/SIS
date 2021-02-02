import java.io.File;
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

		for (int i = 0; i < 24; i++) {
			String firstName = studentFile.next();
			String lastName = studentFile.next();
			studentFile.nextLine();
			addNewStudent(firstName + " " + lastName);
		}

	}

	public void fillCourses() throws IOException {
		Scanner input = new Scanner(new File("StudentList.txt"));

		while (input.hasNext()) {
			studentList.add(new Student(input.next()));

			input.next();
			input.next();
			String per1Class = input.next();
			String per1LetterGrade = input.next();
			String per2Class = input.next();
			String per2LetterGrade = input.next();
			String per3Class = input.next();
			String per3LetterGrade = input.next();

			double per1NumberGrade = Course.getGradeDouble(per1LetterGrade);
			double per2NumberGrade = Course.getGradeDouble(per2LetterGrade);
			double per3NumberGrade = Course.getGradeDouble(per3LetterGrade);

			getStudent(i).getTranscript().add(new Course(per1Class, per1LetterGrade, per1NumberGrade));
			getStudent(i).getTranscript().add(new Course(per2Class, per2LetterGrade, per2NumberGrade));
			getStudent(i).getTranscript().add(new Course(per3Class, per3LetterGrade, per3NumberGrade));
		}
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
			getStudent(classSize() - 1).getTranscript().add(new Course(course, grade, getGradeDouble(grade)));
		}

		displayStudents();
	}

	public void displayStudents() {
		for (Student s : studentList) {
			System.out.print("\n" + studentList.indexOf(s) + " " + s.getName() + "| ");
			for (Course c : s.getTranscript()) {
				System.out.print(c.getName() + ": " + c.getGradeDouble() + ", ");
			}
		}
	}
}
