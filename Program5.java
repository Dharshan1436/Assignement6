package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Program5 {

	public static void main(String[] args) {
		String[] names = { "Aarav", "Vihaan", "Ishaan", "Reyansh", "Krishna", "Anaya", "Diya", "Riya", "Tanvi" };
		List<String> list = new ArrayList<>(Arrays.asList(names));
		 Predicate<String> lengthCondition = x -> x.length() > 5;
	        Predicate<String> substringCondition = x -> x.contains("an");
		List<String> newlist=list.stream().filter(lengthCondition.and(substringCondition)).collect(Collectors.toList());
		System.out.println(newlist);

	}

}
