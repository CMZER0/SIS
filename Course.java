import java.util.ArrayList;
import java.util.Arrays;

public class Course {
    protected String name; // String containing the name of the course
    protected String letterGrade;// String containing the letter grade
    protected double grade; // String containing the number grade.

    //////////////////
    // Constructors //
    //////////////////

    public Course(String name, String letterGrade) {
        setName(name);
        setLetterGrade(letterGrade);
        setDoubleGrade(letterGrade);
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

    public void setDoubleGrade(String in) // converts the given letter grade and returns the number grade(on
                                          // a 4pt scale)
    {
        ArrayList<Double> gradeScaleDoubles = new ArrayList<>(12);
        gradeScaleDoubles.addAll(Arrays.asList(4.0, 4.0, 3.7, 3.3, 3.0, 2.7, 2.3, 2.0, 1.7, 1.3, 1.0, 0.7, 0.0));
        ArrayList<String> gradeScaleStrings = new ArrayList<>(12);
        gradeScaleStrings
                .addAll(Arrays.asList("A+", "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F"));
        this.grade = gradeScaleDoubles.get(gradeScaleStrings.indexOf(in));
    }

    public double getDoubleGrade() {
        return grade;
    }

    //////////////
    // METHODS //
    /////////////

}
