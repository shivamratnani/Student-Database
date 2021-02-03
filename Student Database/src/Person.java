import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Person {
	public String name;
	public Person(String name) {
		this.name = name;
	}

	public void print() {
			System.out.println("\nName: " + name);
	}
	public String searchName() {
		return name;
	}
}
