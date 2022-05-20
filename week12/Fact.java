package week12;

public class Fact {
//	public static long factorial(int n) {
//		long fct=1;
//		for(int i=n; i>0; i--)
//			fct *= i;
//		
//		return fct;
//	}
	
	public static long factorial(int n) {
		if(n == 1)
			return 1;
		else
			return n * factorial(n-1);
	}
	
	public static void main(String[] args) {
		int n=5;
		System.out.println(factorial(n));
	}
}
