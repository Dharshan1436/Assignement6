package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Program6 {

	public static void main(String[] args) {
		String[] names = { "Aarav", "Vihaan", "Ishaan", "Reyansh", "Krishna", "Anaya", "Diya", "Riya", "Tanvi" };

		List<String> list = new ArrayList<>(Arrays.asList(names));
		Consumer<String> printUpperCase = x -> System.out.println(x.toUpperCase());
		list.forEach(printUpperCase);
	}

}
