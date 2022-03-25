package week04;

public class CircularLinkedListDemo {
	
	public static void main(String[] args) {
		System.out.println("Circular Linked List Demo!");
		CircularLinkedList<Integer> list = new CircularLinkedList<>();
		list.add(0, 300); // ����ڽ�
		list.add(0, 200);
		list.add(0, 100); list.printAll();
		list.append(500);
		list.append(600); list.printAll();
		list.remove(3); list.printAll();
		list.add(3, 250);
		list.add(1, 50);
		list.add(0, 10); list.printAll();
		list.append(700); list.printAll();
		list.remove(1);
		list.removeItem(600); list.printAll();
	}
} // �ڵ� 5-12
