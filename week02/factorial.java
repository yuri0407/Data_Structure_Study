package week02;

public class factorial {
	public static int fact1(int n) {
		int tmp = 1;
		for(int i = 2; i <= n; i++) {
			tmp = tmp * i;
		}
		return tmp;
	}
	
	public static int fact2(int n) {
		if(n == 0)
			return 1;
		else
			return n * fact2(n - 1); 
	}

	public static void main(String[] args) {
		System.out.println(fact1(5));
		System.out.println(fact2(5));
		

	}

}
