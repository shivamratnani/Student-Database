import java.io.*;

public class Student extends Person{
	String studentID;
	public Student(String name, String studentID) {
		super(name);
		this.studentID = studentID;
	}
	
	@Override
	public void print() {
		System.out.println("\nStudent Name: " + name + "\nStudent ID: " + studentID);
	}
	public String searchID() {
		return studentID;
	}
}
