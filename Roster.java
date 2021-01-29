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
    
    public void removeStudent(int index)
    {
    	studentList.remove(index);
    }
    
    public int classSize()
    {
    	return studentList.size();
    }

    //////////////
    // METHODS //
    /////////////
    
    public void deleteStudent() 
    {
    	
    	displayStudents();
		Scanner userInp = new Scanner(System.in);
		System.out.println("Select what student you would like to delete");
		int choice = userInp.nextInt();
		
		System.out.println(getStudent(choice).getName() + " will be removed.");
		removeStudent(choice);
		
		
		
    }
    
    public void addStudents()
    {
    	Scanner userInp = new Scanner(System.in);
		System.out.println("What is the name of your new student?");
		String Name = userInp.nextLine();
		addNewStudent(Name);
		
		for (int i = 0; i < 3; i++)
		{
			int p= i +1;
			Scanner userInp2 = new Scanner(System.in);
			System.out.println("Please enter course " + p + " name");
			String course = userInp2.nextLine();
			Scanner userInp3 = new Scanner(System.in);
			System.out.println("Please enter course " + p + " grade");
			String grade = userInp3.nextLine();
			getStudent(classSize() - 1).getTranscript().add(new Course(course, grade));
		}
		
		displayStudents();
    }
    
    public void displayStudents()
    {
    	
    	for (int i = 0; i < classSize(); i++)
    	{
    		System.out.println(i + ", " + getStudent(i).getName() + " " + getStudent(i).getCourse(0).getName() + " " + getStudent(i).getCourse(0).getGrade() + " " + getStudent(i).getCourse(1).getName() + " " + getStudent(i).getCourse(1).getGrade() + " " + getStudent(i).getCourse(2).getName() + " " + getStudent(i).getCourse(2).getGrade());
    	}
    }

}
