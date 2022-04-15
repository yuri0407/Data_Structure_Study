package week07;

public class ArrayQueueText {
	public static void main(String[] args) {
		ArrayQueue<Integer> aq = new ArrayQueue<>();
		Integer data;
		
		aq.enqueue(100);	aq.enqueue(200);
		aq.enqueue(300);	aq.enqueue(400);
		aq.printAll();
		data = aq.dequeue();
		aq.printAll();
	}
}
