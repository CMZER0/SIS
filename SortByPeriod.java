import java.util.Comparator;
public class SortByPeriod implements Comparator<Student>
{
    public int compare (Student s1, Student s2)
    {
	return s1.getCourse(0).getName().compareTo(s2.getCourse(0).getName());
    }
}
