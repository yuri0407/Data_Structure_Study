package week03;

public class Basic2 {
	

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		//Ȧ�� ����ϱ�
		//����Ʈ �Ҽ��� ���
		System.out.println("1 3 5 7 9");
		
		//for������ ���
		for (int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}
		
		//if���� ����ؼ� ���
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 1)
				System.out.println(i);
		}
		
		//if���� ����ؼ� ���(2)
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 0)
				continue;
			System.out.println(i);
		}
		
		//���� ��
		for (int k = 0; k < 10; k++) {
			System.out.println(k);
		}	
//		System.out.println(k);
		
		
		//while���� ����Ͽ� ���
		int i = 1;
		while(i<=10) {
			if(i%2 == 0) {
				i++;
				continue;
			}
			System.out.println(i);
			i++;
		}
			
		
	}
	
}
