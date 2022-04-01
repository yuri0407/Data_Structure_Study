package week05;

	public class Node0  <E extends Comparable<E>>{
		private E    item;
		private Node0 next;
		
		public Node0(E newItem, Node0<E> p){ // 持失切
			item  = newItem;
			next  = p;
		}
		// get 五社球人 set 五社球
		public E    getItem() { return item;}
	    public Node0 getNext() { return next;}
	    public void setItem(E newItem)  { item = newItem;}
	    public void setNext(Node0 n) 	{ next = n;}
	}
