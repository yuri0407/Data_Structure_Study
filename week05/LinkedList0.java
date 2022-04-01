package week05;

class LinkedList0{
	private ListNode0 head;
	public LinkedList0(){
		head = null;
	}
	public void insertMiddleNode(ListNode0 pre, String data){       
		ListNode0 newNode = new ListNode0(data);
		newNode.link = pre.link;
		pre.link = newNode;
	}
	public void insertLastNode(String data){
		ListNode0 newNode = new ListNode0(data);
		if(head == null){
			this.head = newNode;
		}
		else{
			ListNode0 temp = head;
			while(temp.link != null) temp = temp.link;
			temp.link = newNode;
		}
	}
	public void deleteLastNode(){
		ListNode0 pre, temp;
		if(head == null)  return;
		if(head.link == null){
			head = null;
		}
		else{
			pre = head;
			temp = head.link;
			while(temp.link != null){
				pre = temp;
				temp = temp.link;
			}
			pre.link = null;
		}
	}
	public ListNode0 searchNode(String data){
		ListNode0 temp = this.head;
		while(temp != null){
			if(data == temp.getData())  
				return temp;
			else temp = temp.link;
		}
		return  temp;
	}
	public void reverseList(){
		ListNode0 next = head;
		ListNode0 current = null;
		ListNode0 pre = null;
		while(next != null){
			pre = current;
			current = next;
			next = next.link;
			current.link = pre;
		}
		head = current;
	}
	public void printList(){
		ListNode0 temp = this.head;
		System.out.printf("L = (");
		while(temp != null){
			System.out.printf(temp.getData());
			temp = temp.link;
			if(temp != null){
				System.out.printf(", ");
			}			
		}
		System.out.println(")");
	}
}