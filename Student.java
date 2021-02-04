import java.util.ArrayList;

public class Student {
    private String firstName; // String containing the firstName of the student.
    private String lastName;
    private ArrayList<Course> transcript = new ArrayList<>(); // Arraylist holding each course.
    private double GPA;
    //////////////////
    // Constructors //
    //////////////////

    public Student(String firstName, String lastName) {
        setName(firstName, lastName);
    }

    ///////////////////////
    // GETTERS & SETTERS //
    ///////////////////////
    public String getName() {
        return firstName + " " + lastName;
    }

    public void setName(String firstName, String lastName) {
        setfirstName(firstName);
        setLastName(lastName);
    }

    public String getfirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public double getGPA() {
        return GPA;
    }

    public void setGPA() {
        for (Course c : transcript) {
            this.GPA = (getCourse(c).getDoubleGrade() + getCourse(c).getDoubleGrade() + getCourse(c).getDoubleGrade())
                    / getTranscript().size();
        }
    }

    public ArrayList<Course> getTranscript() {
        return transcript;
    }

    public void setTranscript(ArrayList<Course> transcript) {
        this.transcript = transcript;
    }

    public Course getCourse(int index) {
        return getTranscript().get(index);
    }

    public Course getCourse(Course c) { // Overidden Method to return instead based off given Course c
        return getTranscript().get(getTranscript().indexOf(c));
    }

    public void setCourse(Course c) {
        getTranscript().add(c);
    }

    public void setCourse(Course c, int index) { // Overidden Method to add new Course c at given index
        getTranscript().add(index, c);
    }

    //////////////
    // METHODS //
    /////////////

}
