package week07;

// ���� ����Ʈ Ŭ���� LinkedList<E> ��ӹޱ�
public class InheritedQueue<E> extends LinkedList<E> implements QueueInterface<E> {
	public InheritedQueue() {
		super();
	}

	public void enqueue(E newItem) {
		append(newItem);
	}

	public E dequeue() {
		return remove(0);
	}

	public E front() {
		return get(0);
	}

	public void dequeueAll() {
		clear();
	}
	
} // �ڵ� 7-6