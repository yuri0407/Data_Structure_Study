package week07;

public class LinkedStack<E> implements StackInterface<E> {
	private Node<E> topNode;
	private final E ERROR = null;   // ?„?˜?˜ ?—?Ÿ¬ ê°?
	public LinkedStack() {
		topNode = null;
	}
	
	// [?•Œê³ ë¦¬ì¦? 6-7] êµ¬í˜„: ?Š¤?ƒ?— ?›?†Œ x ?‚½?…?•˜ê¸?
	public void push(E newItem) {
		topNode = new Node<>(newItem, topNode);
	}
	
	// [?•Œê³ ë¦¬ì¦? 6-8] êµ¬í˜„: ?Š¤?ƒ?—?„œ ?›?†Œ ?‚­? œ?•˜ê¸?
	public E pop() {
		if (isEmpty( )) return ERROR;
		else {
			Node<E> temp = topNode;
			topNode = topNode.next;
			return temp.item;
		}
	}
	
	// [?•Œê³ ë¦¬ì¦? 6-9] êµ¬í˜„: ?Š¤?ƒ ?ƒ‘ ?›?†Œ ?•Œ? ¤ì£¼ê¸°
	public E top() {
		if (isEmpty()) return ERROR; 
		else return topNode.item;
	}
	
	// [?•Œê³ ë¦¬ì¦? 6-10] êµ¬í˜„: ?Š¤?ƒ?´ ë¹„ì—ˆ?Š”ì§? ?™•?¸?•˜ê¸?
	public boolean isEmpty() {
		return (topNode == null);
	}
	
	// [?•Œê³ ë¦¬ì¦? 6-11] êµ¬í˜„: ?Š¤?ƒ ë¹„ìš°ê¸?
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
} // ì½”ë“œ 6-4
