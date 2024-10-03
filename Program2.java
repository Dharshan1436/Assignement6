package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Program2 {

	public static void main(String[] args) {
		String[] names = { "Aarav", "Vihaan", "Ishaan", "Reyansh", "Krishna", "Anaya", "Diya", "Riya",
				"Tanvi" };

		List<String> list = new ArrayList<>(Arrays.asList(names));
List<String> StartWithA=list.stream().filter(x->x.startsWith("A")).collect(Collectors.toList());
System.out.println(StartWithA);
	}

}
