package week03;

public class Basic2 {
	

	public static void main(String[] args) {
		for (int i = 1; i <= 10; i++) {
			System.out.println(i);
		}
		
		//홀수 출력하기
		//프린트 할수로 출력
		System.out.println("1 3 5 7 9");
		
		//for문으로 출력
		for (int i = 1; i <= 10; i+=2) {
			System.out.println(i);
		}
		
		//if문을 사용해서 출력
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 1)
				System.out.println(i);
		}
		
		//if문을 사용해서 출력(2)
		for (int i = 1; i <= 10; i++) {
			if(i%2 == 0)
				continue;
			System.out.println(i);
		}
		
		//오류 예
		for (int k = 0; k < 10; k++) {
			System.out.println(k);
		}	
//		System.out.println(k);
		
		
		//while문을 사용하여 출력
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
