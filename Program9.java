package assignment6;
@FunctionalInterface
interface Function{
	Integer square(Integer x);
	  default void print(Integer x) {
		  System.out.println(x);
	  }
	
}
public class Program9 {

	public static void main(String[] args) {
		Function s=x->x*x;
		int result=s.square(10);
		s.print(result);

	}

}
