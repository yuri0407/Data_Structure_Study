package week07;

public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;   // ?��?��?�� ?��?�� �?
	public LinkedStack() {
		topNode = null;
	}
	
	// [?��고리�? 6-7] 구현: ?��?��?�� ?��?�� x ?��?��?���?
	public void push(E newItem) {
		topNode = new Node<>(newItem, topNode);
	}
	
	// [?��고리�? 6-8] 구현: ?��?��?��?�� ?��?�� ?��?��?���?
	public E pop() {
		if (isEmpty( )) return ERROR;
		else {
			Node<E> temp = topNode;
			topNode = topNode.next;
			return temp.item;
		}
	}
	
	// [?��고리�? 6-9] 구현: ?��?�� ?�� ?��?�� ?��?��주기
	public E top() {
		if (isEmpty()) return ERROR; 
		else return topNode.item;
	}
	
	// [?��고리�? 6-10] 구현: ?��?��?�� 비었?���? ?��?��?���?
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	// [?��고리�? 6-11] 구현: ?��?�� 비우�?
	public void popAll() {
		topNode = null;
	}

	//////////////////////////////////////////////
	public void printAll() {
		Node<E> t;
		System.out.print("Stack from top: ");
		for(t=topNode; t != null; t = t.next) {
			System.out.print(t.item + " ");
		}
		System.out.println();
	}
	
	public void copyStack(LinkedStack<E> stack) {
		LinkedStack<E> tmpStack = new LinkedStack<>();
		while(!isEmpty())
			tmpStack.push(pop());
		while(!tmpStack.isEmpty()) {
			E item = tmpStack.pop();
			push(item);
			stack.push(item);
		}
	}
} // 코드 6-4
