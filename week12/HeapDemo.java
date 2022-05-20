package week12;

public class HeapDemo {

	public static void main(String[] args) {
	    	System.out.println("Heap w/ Exception!");
			Heap<Integer> h = new Heap<>(10);
			try {           
				h.insert(1);
				h.insert(10);
				h.insert(30); 
				h.heapPrint();
//				h.clear();
				h.insert(10);
				h.insert(30); 
				h.insert(20); 
				h.insert(40); h.heapPrint();
				h.deleteMax(); h.heapPrint();
//				h.insert(1); 
//				h.insert(3); // ���⼭ PQException
//				h.deleteMax();
			} catch (PQException e) {
				String msg = e.getMessage();
				System.out.println(msg);
				
			}
	  }
} // �ڵ� 8-4