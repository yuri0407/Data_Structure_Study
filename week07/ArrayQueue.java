package week07;
public class ArrayQueue<E> implements QueueInterface<E> {

	private E queue[];
	private int front, tail, numItems;
	private static final int DEFAULT_CAPACITY = 64;
	private final E ERROR = null;  // ������ ���� ��

	public ArrayQueue() { // ������ 1
		queue = (E[]) new Object[DEFAULT_CAPACITY];
		front = 0;
		tail = DEFAULT_CAPACITY - 1;
		numItems = 0;
	}

	public ArrayQueue(int n) { // ������ 2
		queue = (E[]) new Object[n];
		front = 0;
		tail = n - 1;
		numItems = 0;
	}

	// [�˰��� 7-1] ����: ť�� ���� �����ϱ�
	public void enqueue(E newItem) {
		if (isFull()) System.out.println("Queue Full!");
		else {
			tail = (tail+1) % queue.length;
			queue[tail] = newItem;
			++numItems;
		}
	}

	// [�˰��� 7-2] ����: ť�� �� á���� Ȯ���ϱ�
	public boolean isFull() {
		return (numItems == queue.length);
	}
 
	// [�˰��� 7-3] ����: ť���� ���� �����ϱ�
	public E dequeue() {
		if (isEmpty()) return ERROR;
		else {
			E queueFront = queue[front];
			front = (front+1) % queue.length;
			--numItems;
			return queueFront;
		}
	}

	// [�˰��� 7-5] ����: ť�� �� �� ���� �˷��ֱ�
	public E front() {
		if (isEmpty()) return ERROR;
		else return queue[front];
	}

	// [�˰��� 7-4] ����: ť�� ������� Ȯ���ϱ�
	public boolean isEmpty( ) {
		return (numItems == 0);
	}

	// [�˰��� 7-6] ����: ť ����
	public void dequeueAll ( ) {
		queue = (E[]) new Object[queue.length];
		front = 0;
		tail = queue.length - 1;
		numItems = 0;
	}

	//////////////////////////////////////////////////////////////////
	public void printAll() {
		int j = front;
		System.out.print("PrintAll: ");
		for(int i = 0; i < numItems; i++) {
			System.out.print(queue[j] + " ");
			j = (j+1) % queue.length;
		}
		System.out.println();
	}
}  // �ڵ� 7-2
