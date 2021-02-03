import java.io.*;

public class GraduateStudent extends Student {
	String major;

	public GraduateStudent(String name, String studentID, String major) {
		super(name, studentID);
		this.major = major;
	}

	@Override
	public void print() {
		System.out.println("\nStudent name: " + name + "\nStudent Id: " + studentID + "\nMajor: " + major);
	}
	
	public String compareMajorEquals() {
		return major;
	}
}
