import java.io.*;

public class Undergraduate extends Student {
	String grade;

	public Undergraduate(String name, String studentID, String grade) {
		super(name, studentID);
		this.grade = grade;
	}

	@Override
	public void print() {
		System.out.println("\nStudent name: " + name + "\nStudent Id: " + studentID + "\nGrade: " + grade);
	}

	public String compareGradeEquals() {
		return grade;
	}
}
 