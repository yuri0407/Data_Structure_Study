package week07;

public class Palindrome {
	private static boolean isPalindrom(String A) {
		LinkedStack s = new LinkedStack();
		LinkedQueue q = new LinkedQueue();
		for(int i=0; i < A.length(); i++) {
			s.push(A.charAt(i));   // ���ڿ� A�� i��° ����
			q.enqueue(A.charAt(i));
		}
		while(!s.isEmpty() && s.pop() == q.dequeue()) {
		}
		if(s.isEmpty()) return true; 
		else return false;
	}
	
	public static void main(String[] args) {
		System.out.println("Palindrom Check!");
		String str = "lioninoil";   // �׽�Ʈ ���ڿ�
		boolean t = isPalindrom(str);
		System.out.println(str + " is Palindrom?: " + t);
	}
} // �ڵ� 7-9