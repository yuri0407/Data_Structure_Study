package week03;

import java.util.Scanner;

public class Basic3 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		
		String name;
		System.out.print("이름을 입력하세요 : ");
		name = scn.next();
		
		if(name.equals("홍길동"))
			System.out.printf("이름이 %s입니다.\n", name);
		else
			System.out.printf("%s이 아닙니다.\n", name);
		
		scn.close();
	}
}
