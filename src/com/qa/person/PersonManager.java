package com.qa.person;

import java.util.ArrayList;

import com.qa.person.domain.Person;

public class PersonManager {
	
	private ArrayList<Person> pplList = new ArrayList<Person>();
	
	public void newPerson(String name, String jobTitle, int age) {
		Person person = new Person(name, jobTitle, age);
		addPerson(person);
	}
	
	public void addPerson (Person person) {
		this.pplList.add(person);
	}
	
	public ArrayList<Person> getPeople() {
		return pplList;
	}
	
	public void printAll() {
		System.out.println("\n\n-----------------------------");
		System.out.println("----Full list of entries-----");
		System.out.println("-----------------------------");
		for (Person person : pplList) {
			System.out.println(person);
			System.out.println("-----------------------------");
		}
	}
	
	public void printAllWithStream() {
		System.out.println("\n\n-----------------------------");
		System.out.println("----Full list of entries-----");
		System.out.println("-----------------------------");
		pplList.stream().forEach(person -> {
			System.out.println(person);
			System.out.println("-----------------------------");
		});
	}
	
	public void search(String name) {
		int count = 0;
		for (Person person : this.pplList) {
			if (person.getName().toLowerCase().equals(name.toLowerCase())) {
				count++;
				System.out.println("--------Person Found!--------");
				System.out.println(person);
				System.out.println("-----------------------------");
			}
		}
		if (count == 0) System.out.println("Nobody found");
	}
}
