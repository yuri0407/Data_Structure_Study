package week05;
import java.util.NoSuchElementException;

public class SList <E extends Comparable<E>>{
	protected Node0 head;  // 연결 리스트의 첫 노드 가리킴
	private   int  size;
	public Node0 getHead() { return head; }
	public void setHead(Node0 n) { head= n;}
	public SList(){       // 연결 리스트 생성자
		head = null;
		size = 0;
	}
	public int size() { return size; }
	public boolean isEmpty() { return size == 0; }

	public void insertFront(E newItem){ // 연결리스트 맨 앞에 새 노드 삽입
		head = new Node0(newItem, head);
		size++;
	}
	
	public void insertAfter(E newItem, Node0 p){ // 노드 p 바로 다음에 새 노드 삽입
		p.setNext(new Node0(newItem, p.getNext()));
		size++;
	}
	public void deleteFront(){       // 리스트의 첫 노드 삭제
		if (isEmpty()) throw new NoSuchElementException();
		head = head.getNext();
		size--;
	}
	
	public void deleteAfter(Node0 p){ // p가 가리키는 노드의 다음 노드를 삭제
		if (p == null) throw new NoSuchElementException();
		Node0 t = p.getNext();
		p.setNext(t.getNext());
		t.setNext(null);
		size--;
	}

	 public int search(E target) {   // target을 탐색  
		 Node0 p = head;
		 for (int  k = 0; k < size ;k++){
			 if (target == p.getItem()) return k;
			 p = p.getNext(); 
		 }
		 return -1; // 탐색을 실패한 경우 -1 리턴
	 }
	 public void print(){  // 연결 리스트 노드들의 항목들을 차례로 출력
			for (Node0 p = head; p != null; p = p.getNext()) 
				System.out.print(p.getItem()+"\t ");
			System.out.println();
		}
}
