import java.util.*;

public class Database {
	public static void main(String[] args) throws InterruptedException {
		try {
			Scanner scanner = new Scanner(System.in);
			int programRun = 1;
			List<Person> people = new ArrayList<Person>();

			while (programRun == 1) {
				System.out.println("\nEnter 0 to stop program");
				System.out.println("Enter 1 to enter a person's information");
				System.out.println("Enter 2 to print all People, Students, Undergraduates, or GraduateStudents");
				System.out.println("Enter 3 to print all people with the same grade level");
				System.out.println("Enter 4 to print all people with the same major");
				System.out.println("Enter 5 to search by name or Student ID");
				System.out.println("\nIf there is a blank space after enter please press enter again! ");
				System.out.println("\n\nEnter what you would like to do: ");
				int userInput = scanner.nextInt();
				while (userInput < 1 && userInput > 5) {
					System.out.println("Enter 1 through 5 only! Try again: ");
					userInput = scanner.nextInt();
				}
				if (userInput == 0) {
					System.out.println("Thank you!");
					System.exit(0);
				}
				if (userInput == 1) {
					scanner.nextLine();
					System.out.println("Enter 1 for person: ");
					System.out.println("Enter 2 for Students: ");
					System.out.println("Enter 3 for Undergraduates: ");
					System.out.println("Enter 4 for GraduateStudents: ");
					int whatPrint = scanner.nextInt();
					while (whatPrint < 1 && whatPrint > 4) {
						System.out.println("Enter 1 through 4 only! Try again: ");
						whatPrint = scanner.nextInt();
					}
					System.out.println("How many people would you like to enter: ");
					int peopleNum = scanner.nextInt();
					if (people.size() == 10) {
						System.out.println("10 people already entered!");
						peopleNum = 0;
					}
					while ((people.size() + peopleNum > 10) && peopleNum != 0) {
						System.out.println("Enter less than 11 people! Try again: ");
						peopleNum = scanner.nextInt();
					}
					int peopleRun = 0;
					for (int i = 0; i < peopleNum; i++) {
						scanner.nextLine();
						System.out.println("Enter student name: ");
						String name = scanner.nextLine();
						name = name.trim();
						if (whatPrint == 1) {
							people.add(new Person(name));
							continue;
						}
						System.out.println("Enter studentID: ");
						String studentID = scanner.nextLine();
						if (whatPrint == 2) {
							people.add(new Student(name, studentID));
							continue;
						}
						if (whatPrint != 4) {
							System.out.println("Enter grade (freshman, sophmore, junior, & senior): ");
							String grade = scanner.nextLine();
							grade = grade.trim();
							while (!(grade.equals("freshman") || grade.equals("sophmore") || grade.equals("junior")
									|| grade.equals("senior"))) {
								System.out.println("You can only enter freshman, sophmore, junior, or senior!");
								grade = scanner.nextLine();
								grade = grade.trim();
							}
							if (whatPrint == 3) {
								people.add(new Undergraduate(name, studentID, grade));
								continue;
							}
						}
						System.out.println("Enter major: ");
						String major = scanner.nextLine();
						if (whatPrint == 4) {
							people.add(new GraduateStudent(name, studentID, major));
							continue;
						}
					}
				}

				if (userInput == 2) {
					if (people.size() != 0) {
						for (int i = 0; i < people.size(); i++) {
							if ((people.get(i) instanceof Person) && !people.get(i).name.equals(null)) {
								((Person) people.get(i)).print();
							}
						}

					} else {
						System.out.println("You have no people in your program!");
					}
				}

				if (userInput == 3) {
					scanner.nextLine();
					int anyprint = 0;
					System.out.println("Enter the grade you want printed out :");
					String gradePrint = scanner.nextLine();
					gradePrint = gradePrint.trim();
					while (!(gradePrint.equals("freshman") || gradePrint.equals("sophmore")
							|| gradePrint.equals("junior") || gradePrint.equals("senior"))) {
						System.out.println("You can only enter freshman, sophmore, junior, or senior!");
						gradePrint = scanner.nextLine();
						gradePrint = gradePrint.trim();
					}
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i) instanceof Undergraduate) {
							if (((Undergraduate) people.get(i)).compareGradeEquals().equals(gradePrint)) {
								((Undergraduate) people.get(i)).print();
								anyprint++;
							}
							if (anyprint == 0 && i == people.size() - 1) {
								System.out.println("No people in that grade!");
							}
						}
					}
				}

				if (userInput == 4) {
					scanner.nextLine();
					int anyPrint = 0;
					System.out.println("Enter the major you want printed out :");
					String majorPrint = scanner.nextLine();
					majorPrint = majorPrint.trim();
					for (int i = 0; i < people.size(); i++) {
						if (people.get(i) instanceof GraduateStudent) {
							if (((GraduateStudent) people.get(i)).compareMajorEquals().equals(majorPrint)) {
								((GraduateStudent) people.get(i)).print();
								anyPrint++;
							}
							if (anyPrint == 0 && i == people.size() - 1) {
								System.out.println("No majors by that name!");
							}
						}
					}
				}

				if (userInput == 5) {
					scanner.nextLine();
					int anyprints = 0;

					System.out.println("Enter 1 for searching by name \nEnter 2 for searching by Student ID");
					int whichOne = scanner.nextInt();
					while (whichOne != 1 && whichOne != 2) {
						System.out.println("Enter 1 or 2 only! Try again: ");
						whichOne = scanner.nextInt();
					}
					if (whichOne == 1) {
						scanner.nextLine();
						System.out.println("Enter the name you want to find :");
						String namePrint = scanner.nextLine();
						namePrint = namePrint.trim();
						for (int i = 0; i < people.size(); i++) {
							if (people.get(i) instanceof Person) {
								if (((Person) people.get(i)).searchName().equals(namePrint)) {
									anyprints++;
									((Person) people.get(i)).print();
								}
								if (anyprints == 0 && i == people.size() - 1) {
									System.out.println("No person by that name!");
								}
							}
						}
					}
					if (whichOne == 2) {
						scanner.nextLine();
						System.out.println("Enter the Student ID you want to find :");
						String idPrint = scanner.nextLine();
						idPrint = idPrint.trim();
						for (int i = 0; i < people.size(); i++) {
							if (people.get(i) instanceof Student) {
								if (((Student) people.get(i)).searchID().equals(idPrint)) {
									anyprints++;
									((Person) people.get(i)).print();
								}
								if (anyprints == 0 && i == people.size() - 1) {
									System.out.println("No person by that Student ID!");
								}
							}
						}
					}
				}
			}
		} catch (InputMismatchException e) {
			System.out.println("Please enter a valid input! ");
			System.out.println("Program is exiting! ");
			System.exit(0);
		} catch (ClassCastException q) {
			System.out.println("This student doesn't have a Student ID, grade, or major specified! ");
			System.out.println("Program is exiting! ");
			System.exit(0);
		}
	}
}
