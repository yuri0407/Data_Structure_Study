package week03;

public class hanoi {
	public static int count1 = 0;	//호출횟수
	public static int count2 = 0;	//이동횟수
	
	public static void move(int n, char a, char b, char c) {
		count1++;
		if(n > 0) {
			move(n-1, a, c, b);
			count2++;
			System.out.println(a+"에 있는 원반을 "+b+"로 옮긴다.");
			move(n-1, c, b, a);
		}
	}
	public static void main(String[] args) {
		move(5, 'A', 'B', 'C');
		System.out.println("호출 횟수 : "+count1);
		System.out.println("이동 횟수 : "+count2);
		
	}
}
