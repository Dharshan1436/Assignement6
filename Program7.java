package assignment6;

import java.util.function.Function;

public class Program7 {

	public static void main(String[] args) {

		Function<Double, Double> area = radius -> Math.PI * radius * radius;

		double radius = 5.0;

		double result = area.apply(radius);

		System.out.println("Area of the circle with radius " + radius + " is: " + result);
	}
}
