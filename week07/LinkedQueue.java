package week07;

public class LinkedQueue<E> implements QueueInterface<E>{
	private Node<E> tail;
	private final E ERROR = null; // ������ ���� ��
	public LinkedQueue( ) {
		tail = null;
	}
 
	// [�˰��� 7-7] ����: ť�� ���� �����ϱ�
	public void enqueue(E newItem) {
		Node<E> newNode = new Node<>(newItem);
		if (isEmpty( )) {
			newNode.next = newNode;
			tail = newNode;
		} else {
			newNode.next = tail.next;
			tail.next = newNode;
			tail = newNode;
		}
	}
		
	// [�˰��� 7-8] ����: ť���� ���� �����ϱ�
	public E dequeue( ) {
		if (isEmpty( )) return ERROR;
		else {
			Node<E> front = tail.next;
			if (front == tail) 	// only one item in queue
				tail = null;
			else   // more than one item
				tail.next = front.next;
			return  front.item; 
		}
	}
		
	// [�˰��� 7-9] ����: ť�� �� �� ���� �˷��ֱ�
	public E front() {
		if (isEmpty()) return ERROR; 
		else return tail.next.item;	// tail.next: front
	}
		
	// [�˰��� 7-10] ����: ť�� ������� Ȯ���ϱ�
	public boolean isEmpty() {
		return (tail == null);
	}
		 
	// [�˰��� 7-11] ����: ť ����
	public void dequeueAll ( ) {
			tail = null;
	} 
	
	/////////////////////////////////////////////////////
	public void printAll() {
		Node<E> t = tail;
		System.out.println("Queue from front to tail");
		if (!isEmpty()) 
			do {
				t = t.next;
				System.out.println(t.item);
			} while (t != tail);
		else System.out.println("Empty Queue!");
	}
} // �ڵ� 7-4
