package week13;

public class Sorting {
	int A[];
	public Sorting(int B[]) {
		A = B;
	}
	
	// [�˰��� 9-1] ����: ���� ����
	public void selectionSort() {
		int k; int tmp;
		for(int last = A.length-1; last >= 1; last--) {
			k = theLargest(last);	    // A[0...last] �� ���� ū �� A[k] ã��
			tmp = A[k]; A[k] = A[last]; A[last] = tmp;
		}
	}
		
	private int theLargest(int last) {
		// A[0...last]���� ���� ū ���� �ε����� �����Ѵ�.
		int largest = 0;
		for(int i = 0; i <= last; i++)
			if (A[i] > A[largest]) largest = i;
		return largest;
	}
	
	// [�˰��� 9-3] ����: ���� ����
	public void bubbleSort() {
		int tmp = 0;
		boolean swapped;
		for (int last = A.length-1; last >= 2; last--) {
			swapped = false;
			for (int i = 0; i <= last-1; i++)
				if (A[i] > A[i+1]) {
					tmp = A[i]; A[i] = A[i+1]; A[i+1] = tmp;
					swapped = true;
				}
				if (swapped == false)
					break;
		}
		tmp = tmp;
	}
	
	// [�˰��� 9-4] ����: ���� ����
	public void insertionSort() {
		for(int i = 1; i <= A.length-1; i++) { 
			int loc = i-1;
			int newItem = A[i];
			while (loc >= 0 && newItem < A[loc]) { 
				A[loc+1] = A[loc];
				loc--;
			} 
			A[loc+1] = newItem;
		}
	}
	
	// [�˰��� 9-6] ����: ���� ����
	public void mergeSort() { 
		int[] B = new int[A.length];
		mSort(0, A.length-1, B);	
	}
	
	private void mSort(int p, int r, int[] B) { 
		if (p < r) {
			int q = (p+r)/2; 
			mSort(p, q, B);	
			mSort(q+1, r, B);
			merge(p, q, r, B);
		} 
	}
	
	private void merge(int p, int q, int r, int[] B) {
		int i = p; int j = q+1; int t = 0;
		while (i <= q && j <= r) {
			if(A[i] <= A[j]) B[t++] = A[i++];
			else B[t++] = A[j++];
		}
		while (i <= q)		// ���� �κ� �迭�� ���� ���
			B[t++] = A[i++];
		while (j <= r)		// ������ �κ� �迭�� ���� ���
			B[t++] = A[j++];
		i = p; t = 0;
		while (i <= r)		// ����� A[p...r]�� ����
		     A[i++] = B[t++];
	}
	
	// [�˰��� 9-8] ����: �� ����
	public void quickSort() {
			qSort(0, A.length-1);
	}
	
	private void qSort(int p, int r) {
		if (p < r) {
			int q = partition(p, r);
			qSort(p, q-1);
			qSort(q+1, r);
		}
	}
	
	private int	partition(int p, int r) {
		int x = A[r];
		int i = p-1; 
		int tmp;
		for (int j = p; j <= r-1; j++) {
			if (A[j] <= x) {
				i++;
				tmp = A[i]; A[i] = A[j]; A[j] = tmp;
			}
		}
		tmp = A[i+1]; A[i+1] = A[r]; A[r] = tmp;
		return i+1;	
	}
	
	
	// [�˰��� 9-10] ����: �� ����
	public void heapSort() {
		buildHeap();
		int tmp;
		for (int i = A.length-1; i >= 1; i--) {
			tmp= A[0];
			A[0] = A[i];
			A[i] = tmp;
			percolateDown(0, i-1); 
		}
	}
		
		public void buildHeap() {
		if (A.length >= 2)
			for (int i = (A.length-2)/2; i>=0; i--)
				percolateDown(i, A.length-1);
		}
	    
	private void percolateDown(int i, int n) {
		int child = 2*i + 1 ;          // left child
		int rightChild = 2*i + 2;     // right child
		if (child <= n) {
			if ((rightChild <= n) && (A[child] < A[rightChild])) {
				child = rightChild;   // �� ū �ڽ��� �ε���
			}
			if (A[i] < A[child]) {
				int tmp = A[i]; 
				A[i] = A[child]; 
				A[child] = tmp;
				percolateDown(child, n);
			}
		}
	}
	
	// [�˰��� 9-11] ����: �� ����
	public void shellSort() {
		for(int h = A.length/7; h > 5; h = h/5 - 1) 
			for(int k = 0; k <= h-1; k++)
				stepInsertionSort(k, h);
		stepInsertionSort(0, 1);
	}
	
	void stepInsertionSort(int k, int h) {
		int j, insItem;
		for(int i = k+h; i <= A.length-1; i += h) {
			insItem = A[i];
			for(j=i-h; j >= 0 && A[j] > insItem; j -= h)
				A[j+h] = A[j];
			A[j+h] = insItem;
		}
	}

	// [�˰��� 9-12] ����: ��� ����
	public int[] countingSort(int K) {  // A[0...n-1] belong to integers 0~k-1
		int[] cnt = new int[K]; 
		for(int i = 0; i < K; i++) 
			cnt[i] = 0;
		for(int i = 0; i < A.length; i++) 
			cnt[A[i]]++;
		cnt[0]--; // A[0]���� �����ϹǷ� ����
		for(int i = 1; i < K; i++) 
			cnt[i] += cnt[i-1];
		int[] B = new int[A.length];
		for(int j = A.length-1; j >= 0; j--) { // stable sorting�� ����� ���� ��������
			B[cnt[A[j]]] = A[j];
		    cnt[A[j]]--;
		}
		return B;
	}
	
	// [�˰��� 9-13] ����: ��� ����
	public void radixSort() {  // A[0...n-1]�� �ִ� numDigits �ڸ����� ���� ����
		int[] cnt = new int[10], start = new int[10];
		int[] B = new int[A.length];
		int max = -1;
		for(int i = 0; i < A.length; i++) {
			if(A[i] > max) max = A[i];
		}
		int numDigits = (int)Math.log10(max) + 1;  // �ִ� �ڸ��� ���
		for(int digit = 1; digit <= numDigits; digit++) {
			for(int d = 0; d <= 9; d++) 
				cnt[d] = 0;
			for(int i = 0; i < A.length; i++) 
				cnt[(int)(A[i]/Math.pow(10, digit-1)) % 10]++;
			start[0] = 0;         
			for(int d = 1; d <= 9; d++) 
				start[d] = start[d-1] + cnt[d-1];
			for(int i = 0; i < A.length; i++)
				B[start[(int)(A[i]/Math.pow(10, digit-1)) % 10]++] = A[i];
			for(int i = 0; i < A.length; i++) 
				A[i] = B[i];
		}
	}
	
	// [�˰��� 9-14] ����: ��Ŷ ����
	public void bucketSort() { 
		// A[0...]: ���� �ƴ� ���� �������� �յ� ���� �迭 
		intLinkedList B[];
		int numLists = A.length;
		B = new intLinkedList[numLists];
		for(int i = 0; i < numLists; i++) 
			B[i] = new intLinkedList();
		int max;
		if(A[0] < A[1]) max = 1;
		else max = 0;
		for(int i = 2; i < A.length; i++) 
			if(A[max] < A[i]) max = i;	
		int band = A[max] + 1;
		int bucketId;
		for(int i = 0; i < A.length; i++) {
			bucketId = (int)((float)(A[i]/band)*numLists);
			B[bucketId].add(0, A[i]);
		}
		int finger = 0, p, r = -1;
		for(int i = 0; i < numLists; i++) {
			for(int j = 0; j < B[i].len(); j++) 
				A[finger++] = B[i].getNode(j).item;
			p = r + 1; r = finger - 1;
			rangeInsertionSort(p, r);
		}
	}

	private void rangeInsertionSort(int p, int r) {
		for(int i = p+1; i <= r; i++) { 
			int loc = i-1;
			int x = A[i];
			while (loc >= p && x < A[loc]) { 
		            	A[loc+1] = A[loc];
		            	loc--;
			} 
			A[loc+1] = x;
		}
	}
} // �ڵ� 9-1
