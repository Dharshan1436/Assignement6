package assignment6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Program10 {

	public static void main(String[] args) {
		Integer[] nums = { 10, 20, 56, 0, 3, 545, 2, 4, 6, 5, 1458, 8 };
		List<Integer> list = new ArrayList<>(Arrays.asList(nums));
		Optional<Integer> maxValue = list.stream().max(Integer::compareTo);

		maxValue.ifPresent(max -> System.out.println("Maximum value: " + max));

	}

}
