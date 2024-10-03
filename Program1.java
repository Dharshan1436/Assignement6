package assignment6;
@FunctionalInterface
interface Sum {
    int add(int a, int b);
}

public class Program1 {

	public static void main(String[] args) {
		
		Sum sum = (a,b) -> a + b;
		int result = sum.add(5,10);
        System.out.println("The sum is: " + result);
	}

}
