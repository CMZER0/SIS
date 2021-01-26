public class Course {
    private String name; // String containing the name of the course
    private String grade; // String containing the grade.

    //////////////////
    // Constructors //
    //////////////////

    public Course(String name, String grade) {
        setName(name);
        setGrade(grade);
    }

    ///////////////////////
    // GETTERS & SETTERS //
    ///////////////////////

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    //////////////
    // METHODS //
    /////////////

}
