package week04;

import java.util.Scanner;

public class ArrEx01 {
	public static void arrDel(int[] abc, int ii) {
		int i;
		for (i = ii; i < abc.length-1; i++) {
			abc[i] = abc[i+1];
		}
		abc[i] = 0;
	}
	
	public static void arrIns(int[] abc, int ii, int val) {
		int i;
		for (i = abc.length-1; i > ii; i--) {
			abc[i] = abc[i-1];
		}
		abc[i] = val;
	}
	
	public static void main(String[] args) {
		int i, idx, value;
		Scanner scn = new Scanner(System.in);
		System.out.print("삭제할 index 입력 : ");
		idx = scn.nextInt();
		
		int[] def = {10, 20, 30, 40, 50};
		arrDel(def, idx);
		
		for (i = 0; i < def.length; i++) {
			System.out.println(def[i]);
		}
		
		System.out.print("삽입할 index 입력 : ");
		idx = scn.nextInt();
		
		System.out.print("삽입할 value 입력 : ");
		value = scn.nextInt();
		arrIns(def, idx, value);
		
		for (i = 0; i < def.length; i++) {
			System.out.println(def[i]);
		}

	}
}
