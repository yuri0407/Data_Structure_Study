package week13;

public class Factorial {
//	public static int fact(int n) {
//		int f = 1;
//		
//		
//		
//		for(int i=n; i>0; i--) {
//			f *= i;
//		}
//		
//		return f;
//	}
	public static int fact(int n) {
		if(n < 0)
			n = -n;
		if(n == 1)
			return 1;
		else
			return n * fact(n-1);
	}
	public static void main(String[] args) {
		int n = 5;
		System.out.println(fact(n));
	}
}
