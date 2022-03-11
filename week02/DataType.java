package week01;

public class DataType {
	public static int seq(int n) {
		if(n == 1)
			return 1;
		else
			return seq(n-1) + 3;
	}
	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.print(seq(i) + " ");
		}
	}
}
