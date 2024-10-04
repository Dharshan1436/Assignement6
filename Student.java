package assignment6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student {
	private int id;
	private String firstName;
	private int age;
	private String gender;
	private String dept;
	private String city;
	private int rank;
	private List<String> contacts;

	public Student() {
		super();
	}

	public Student(int id, String firstName, int age, String gender, String dept, String city, int rank,
			List<String> contacts) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.age = age;
		this.gender = gender;
		this.dept = dept;
		this.city = city;
		this.rank = rank;
		this.contacts = contacts;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public List<String> getContacts() {
		return contacts;
	}

	public void setContacts(List<String> contacts) {
		this.contacts = contacts;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", age=" + age + ", gender=" + gender + ", dept="

				+ dept + ", city=" + city + ", rank=" + rank + ", contacts=" + contacts + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, city, contacts, dept, firstName, gender, id, rank);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return age == other.age && Objects.equals(city, other.city) && Objects.equals(contacts, other.contacts)
				&& Objects.equals(dept, other.dept) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gender, other.gender) && id == other.id && rank == other.rank;
	}

	public static void main(String[] args) {
		List<Student> studentList = Stream.of(
				new Student(1, "Rohit", 30, "Male", "Mechanical Engineering", "Mumbai", 122,
						Arrays.asList("+912632632782", "+1673434729929")),
				new Student(2, "Pulkit", 56, "Male", "Computer Engineering", "Delhi", 67,
						Arrays.asList("+912632632762", "+1673434723929")),
				new Student(3, "Ankit", 25, "Female", "Mechanical Engineering", "Kerala", 164,
						Arrays.asList("+912632633882", "+1673434709929")),
				new Student(4, "Satish Ray", 30, "Male", "Mechanical Engineering", "Kerala", 26,
						Arrays.asList("+9126325832782", "+1671434729929")),
				new Student(5, "Roshan", 23, "Male", "Biotech Engineering", "Mumbai", 12,
						Arrays.asList("+012632632782")),
				new Student(6, "Chetan", 24, "Male", "Mechanical Engineering", "Karnataka", 90,
						Arrays.asList("+9126254632782", "+16736784729929")),
				new Student(7, "Arun", 26, "Male", "Electronics Engineering", "Karnataka", 324,
						Arrays.asList("+912632632782", "+1671234729929")),
				new Student(8, "Nam", 31, "Male", "Computer Engineering", "Karnataka", 433,
						Arrays.asList("+9126326355782", "+1673434729929")),
				new Student(9, "Sonu", 27, "Female", "Computer Engineering", "Karnataka", 7,
						Arrays.asList("+9126398932782", "+16563434729929", "+5673434729929")),
				new Student(10, "Shubham", 26, "Male", "Instrumentation Engineering", "Mumbai", 98,
						Arrays.asList("+912632646482", "+16734323229929")))
				.collect(Collectors.toList());
		// 1. Find the list of students whose rank is in between 50 and 100
		List<Student> rankBetween50To100 = studentList.stream().filter(x -> x.rank > 50 && x.rank < 100)
				.collect(Collectors.toList());
		System.out.println(rankBetween50To100);
		// 2. Find the Students who stays in Karnataka and sort them by their names
		List<Student> staysInKarnataka = studentList.stream().filter(x -> x.city.equals("Karnataka"))
				.sorted(Comparator.comparing(x -> x.getFirstName())).collect(Collectors.toList());
		System.out.println(staysInKarnataka);
		// 3. Find all departments names
		List<String> departmentsNames = studentList.stream().map(x -> x.getDept()).distinct().toList();
		System.out.println(departmentsNames);
		// 4. Find all the contact numbers
		
		List<String> contactNumbers = studentList.stream().flatMap(x->x.getContacts().stream()).toList();
		System.out.println(contactNumbers);
		
		// 5. Group The Student By Department Names
		Map<String, List<Student>> StudentByDepartmentNames = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDept));
		System.out.println(StudentByDepartmentNames);
		
		// 6. Find the department who is having maximum number of students
		Map<String, Long> departmentCount = studentList.stream()
				.collect(Collectors.groupingBy(Student::getDept, Collectors.counting()));
		Optional<String> departmentWithMaxStudents = departmentCount.entrySet().stream()
				.max(Map.Entry.comparingByValue()).map(Map.Entry::getKey);
		System.out.println(departmentWithMaxStudents);
		
		// 7. Find the average age of male and female students
		Map<String, Double> averageAgeByGender = studentList.stream()
				.collect(Collectors.groupingBy(Student::getGender, Collectors.averagingInt(Student::getAge)));

		averageAgeByGender.forEach((gender, avgAge) -> {
			System.out.println("Gender: " + gender + ", Average Age: " + avgAge);
		});
		// 8. Find the highest rank in each department
		Map<String, Optional<Student>> highestRankInEachDept = studentList.stream().collect(
				Collectors.groupingBy(Student::getDept, Collectors.maxBy(Comparator.comparingInt(Student::getRank))));

		highestRankInEachDept.forEach((dept, student) -> {
			System.out.println("Department: " + dept + ", Highest Rank: " + student.orElse(null));
		});
		// 9 .Find the student who has second rank
		Optional<Student> secondRankedStudent = studentList.stream()
				.sorted(Comparator.comparingInt(Student::getRank).reversed()).skip(1).findFirst();

		System.out.println("Student with Second Highest Rank: " + secondRankedStudent.orElse(null));
	}
}