package com.qa.person.menu;

import java.util.Scanner;

import com.qa.person.PersonManager;

public class Menu {

	public void launch() {
		PersonManager pm = new PersonManager();
		Scanner s = new Scanner(System.in);
		int choice = 0;
		boolean exit = false;
		
		outer:
		while(!exit) {
			
			System.out.println(" ---------------OPTIONS----------------");
			System.out.println("|Create person                     | 1 |");
			System.out.println("|Search for a specific person      | 2 |");
			System.out.println("|Output all people to console      | 3 |");
			System.out.println("|Exit                              | 4 |");
			System.out.println(" --------------------------------------");
			System.out.println("|Please select an option (1, 2, 3 or 4)|");
			System.out.println(" --------------------------------------");
			System.out.print("Input: ");
			
			try {
				choice = s.nextInt();
				if (choice > 4 || choice <= 0) {
					System.out.println("\n     ERROR: Please enter 1, 2, 3 or 4!\n");
					continue outer;
				}
			} catch (Exception e) {
				System.out.println("\nERROR: Value entered was not an integer!\n");
				s.next();
				continue;
			}
			
			switch (choice) {
				case 1:
					System.out.println("Please enter some details for your new person...");
					System.out.print("Name: ");
					String name = s.next();
					System.out.print("Job Title: ");
					String jobTitle = s.next();
					System.out.print("Age: ");
					int age = s.nextInt();
					pm.newPerson(name, jobTitle, age);
					break;
				case 2:
					System.out.println("Please enter a name to search for...");
					System.out.print("Name: ");
					String searchName = s.next();
					pm.search(searchName);
					break;
				case 3:
					pm.printAll();
					break;
				case 4:
					exit = true;
					System.out.println("\nSuccessfully exited application.");
					break;
				default:
					System.out.println("You have entered an invalid operation. Try Again.");
					s.next();
					continue;
			}
		}
		s.close();
	}
}
