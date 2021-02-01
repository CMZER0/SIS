public class Course {
    protected String name; // String containing the name of the course
    protected String letterGrade;// String containing the letter grade
    protected double grade; // String containing the  number grade.

    //////////////////
    // Constructors //
    //////////////////

    public Course(String name, String letterGrade, double grade) {
        setName(name);
        setLetterGrade(letterGrade);
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
    
    public String getLetterGrade()
    {
	return letterGrade;
    }
    
    public void setLetterGrade(String letterGrade)
    {
	this.letterGrade = letterGrade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    //////////////
    // METHODS //
    /////////////

}
