package assignment6;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;
	private double salary;

	public Person() {
		super();
	}

	public Person(String name, int age, double salary) {
		super();
		this.name = name;
		this.age = age;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", salary=" + salary + "]";
	}

}

public class Program3 {

	public static void main(String[] args) {
		Person p1 = new Person("Dharshan", 20, 20000);
		Person p2 = new Person("naveen", 18, 25000);
		Person p3 = new Person("raju", 22, 15000);
		Person p4 = new Person("maju", 25, 35000);
		Person p5 = new Person("ravi", 21, 30000);
		List<Person> person = new ArrayList<Person>();
		person.add(p1);
		person.add(p2);
		person.add(p3);
		person.add(p4);
		person.add(p5);
		 System.out.println("Original List:");
		System.out.println(person);
		List<Person> sortedPersons = person.stream().sorted(Comparator.comparingInt(Person::getAge))
				.collect(Collectors.toList());
		System.out.println("Sorted by Age:");
		System.out.println(sortedPersons);
	}

}
