public class Course {
    protected String name; // String containing the name of the course
    protected String letterGrade;// String containing the letter grade
    protected double grade; // String containing the number grade.

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

    public String getLetterGrade() {
        return letterGrade;
    }

    public void setLetterGrade(String letterGrade) {
        this.letterGrade = letterGrade;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public static double getGradeDouble(String letterGrade) {
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

    //////////////
    // METHODS //
    /////////////

}
