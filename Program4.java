package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Program4 {

	public static void main(String[] args) {
		Integer[] numbers = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = new ArrayList<>(Arrays.asList(numbers));
		int sum = list.stream().filter(x -> x % 2 == 0).map(x -> x * x).reduce(0, (x, y) -> x + y);
		System.out.println("Sum of squares of even numbers: " + sum);
	}

}
