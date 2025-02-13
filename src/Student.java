/**
 * A subclass of Person that represents a Student
 *
 * Created for Menlo School CS2
 *
 * @author: Ms. Namasivayam & Mr. Blick
 * @version: 2022-2023
 */

public class Student extends Person {

    private int grade;

    // Constructor
    public Student(String firstName, String lastName, String phoneNumber, int grade)
    {
        super(firstName, lastName, phoneNumber);
        this.grade = grade;
    }

    // Getter for grade
    public int getGrade()
    {
        return grade;
    }

    // toString Method
    @Override
    public String toString()
    {
        return super.toString() + " Grade: " + grade;
    }
}
