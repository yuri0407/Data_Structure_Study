package week07;

public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;   // ??? ??¬ κ°?
	public LinkedStack() {
		topNode = null;
	}
	
	// [?κ³ λ¦¬μ¦? 6-7] κ΅¬ν: ?€?? ?? x ?½??κΈ?
	public void push(E newItem) {
		topNode = new Node<>(newItem, topNode);
	}
	
	// [?κ³ λ¦¬μ¦? 6-8] κ΅¬ν: ?€??? ?? ?­? ?κΈ?
	public E pop() {
		if (isEmpty( )) return ERROR;
		else {
			Node<E> temp = topNode;
			topNode = topNode.next;
			return temp.item;
		}
	}
	
	// [?κ³ λ¦¬μ¦? 6-9] κ΅¬ν: ?€? ? ?? ?? €μ£ΌκΈ°
	public E top() {
		if (isEmpty()) return ERROR; 
		else return topNode.item;
	}
	
	// [?κ³ λ¦¬μ¦? 6-10] κ΅¬ν: ?€??΄ λΉμ?μ§? ??Έ?κΈ?
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	// [?κ³ λ¦¬μ¦? 6-11] κ΅¬ν: ?€? λΉμ°κΈ?
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
} // μ½λ 6-4
