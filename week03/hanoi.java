package week03;

public class hanoi {
	public static int count1 = 0;	//ȣ��Ƚ��
	public static int count2 = 0;	//�̵�Ƚ��
	
	public static void move(int n, char a, char b, char c) {
		count1++;
		if(n > 0) {
			move(n-1, a, c, b);
			count2++;
			System.out.println(a+"�� �ִ� ������ "+b+"�� �ű��.");
			move(n-1, c, b, a);
		}
	}
	public static void main(String[] args) {
		move(5, 'A', 'B', 'C');
		System.out.println("ȣ�� Ƚ�� : "+count1);
		System.out.println("�̵� Ƚ�� : "+count2);
		
	}
}
