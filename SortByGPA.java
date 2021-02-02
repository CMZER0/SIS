import java.util.Comparator;
public class SortByGPA implements Comparator<Student>
{
    public int compare (Student s1, Student s2)
    {
	if(s1.getGPA() < s2.getGPA())
	{
	    return 1;
	}
	else
	{
	    return -1;
	}
    }
}
