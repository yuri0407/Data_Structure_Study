package week04;
import java.util.Iterator;

public class LinkedListIterator implements Iterator<Node>{
	private Node current;
	public LinkedListIterator(LinkedList list) {
		current = list.getNode(-1); // �뜑誘� �뿤�뱶
	}

	public boolean hasNext() {
		return current.next != null;
	}

	public Node next() {
		return current = current.next;
	}
}