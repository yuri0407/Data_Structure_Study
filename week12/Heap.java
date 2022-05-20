package week12;

public class Heap<E extends Comparable> implements PQInterface<E> {
	private E[] A;
	private int numItems;

	public Heap(int arraySize) {
		A = (E[]) new Comparable[arraySize];
		numItems = 0;
	}

	public Heap(E[] B, int numElements) {
		A = B; // �迭 ���۷��� ����
		numItems = numElements;
	}

	// [�˰��� 8-2] ����: ���� ���� �����ϱ�(��� �˰��� ����)
	public void insert(E newItem) throws PQException {
		// �� A[0...numItems-1]�� ���� newItem�� �����Ѵ�(�߰��Ѵ�)
		if (numItems < A.length) {
			A[numItems] = newItem;
			percolateUp(numItems);
			numItems++;
		} else throw new PQException("HeapErr: Insert()-Overflow!");
	} 

	// ��������� percolateUp()
	private void percolateUp(int i) {
		// A[i]���� �����ؼ� �� ������ �����ϵ��� �����Ѵ�
		// A[0...i-1]�� �� ������ �����ϰ� ����
		int parent = (i - 1) / 2;
		if (parent >= 0 && A[i].compareTo(A[parent]) > 0) {
			E tmp = A[i];
			A[i] = A[parent];
			A[parent] = tmp;
			percolateUp(parent);
		}
	}

	// [�˰��� 8-3] ����: ������ ���� �����ϱ�
	public E deleteMax() throws PQException {
		// �� A[0...numItems-1]���� �ִ��� �����ϸ鼭 �����Ѵ�
		if (!isEmpty()) {
			E max = A[0];
			A[0] = A[numItems - 1];
			numItems--;
			percolateDown(0);
			return max;
		} else throw new PQException("HeapErr: DeleteMax()-Underflow");
	}
	
	// ���系���� percolateDown()
	private void percolateDown(int i) {
		// A[0...numItems-1]���� A[i]�� ��Ʈ�� ���系����
		int child = 2 * i + 1;        // ���� �ڽ�
		int rightChild = 2 * i + 2;  // ������ �ڽ�
		if (child <= numItems - 1) {
			if (rightChild <= numItems - 1 && A[child].compareTo(A[rightChild]) < 0)
				child = rightChild; // �� ū �ڽ��� �ε���
			if (A[i].compareTo(A[child]) < 0) {
				E tmp = A[i];
				A[i] = A[child];
				A[child] = tmp;
				percolateDown(child);
			}
		}
	}
	
	// [�˰��� 8-4] ����: �� �����
	public void buildHeap() {
		if (numItems >= 2)
			for (int i = (numItems - 2) / 2; i >= 0; i--)
				percolateDown(i);
	}
	
	// [�˰��� 8-5] ����: ���� �ִ� ���ϱ�
	public E max() throws PQException {
		if (!isEmpty()) {
			return A[0];
		} else throw new PQException("HeapErr: Max()-Empty!");

	}

	// [�˰��� 8-6] ����: ���� ������� Ȯ���ϱ�
	public boolean isEmpty() { // ���� ����ִ��� �˷��ش�
		return numItems == 0;
	}

	// [�˰��� 8-7] ����: �� ����
	public void clear() {
      	    A = (E[]) new Object[A.length]; 
      	    numItems = 0; 
      }

	//////////////////////////////////////////////////
	public void heapPrint() {
		System.out.println("heapPrint()");
		for(int i=0; i<=numItems-1; i++) {
			System.out.println(A[i]);
 		}
	}
} // �ڵ� 8-2
