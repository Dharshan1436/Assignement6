package assignment6;

import java.util.function.BiFunction;

public class Program8 {

	public static void main(String[] args) {

		BiFunction<String, String, String> concatenate = (x, y) -> x + " " + y;

		String result = concatenate.apply("Dharshan", "PL");

		System.out.println(result);
	}
}
