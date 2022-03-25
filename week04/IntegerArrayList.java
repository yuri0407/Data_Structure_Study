package week04;

public class IntegerArrayList implements IntegerListInterface {
	private Integer[] item;
	private int numItems;
	private static final int DEFAULT_CAPACITY = 64;

	public IntegerArrayList() {		// ������ 1
		item = new Integer[DEFAULT_CAPACITY];
		numItems = 0;
	}

	public IntegerArrayList(int n) {	// ������ 2
		item = new Integer[n];
		numItems = 0;
	} 
 
 	// [�˰��� 5-1] ����: �迭 ����Ʈ�� k��° �ڸ��� ���� x �����ϱ�
	public void add(int index, Integer x) {
		if (numItems >= item.length || index < 0 || index > numItems) {
			/* ���� ó�� */ 
		} else {
			for (int i = numItems - 1; i >= index; i--)
				item[i + 1] = item[i];	// �����Ʈ
			item[index] = x;
			numItems++;
		}
	}
  
	// [�˰��� 5-2] ����: �迭 ����Ʈ�� �� �ڿ� ���� �߰��ϱ�
	public void append(Integer x) {
		if (numItems >= item.length) {
			/* ���� ó�� */ 
		} else {
			item[numItems++] = x;
		}
	}

	// [�˰��� 5-3] ����: �迭 ����Ʈ�� k��° ���� �����ϱ�
	public Integer remove(int index) {
		if (isEmpty() || index < 0 || index > numItems - 1)
			return null;
		else {
			Integer tmp = item[index];
			for (int i = index; i <= numItems - 2; i++)
				item[i] = item[i + 1];	// �½���Ʈ
			numItems--;
			return tmp;
		}
	}
 
	// [�˰��� 5-4] ����: �迭 ����Ʈ���� ���� x �����ϱ�
	public boolean removeItem(Integer x) {
		int k = 0;
		while (k < numItems && item[k].compareTo(x) != 0)
			k++;
		if (k == numItems)
			return false;
		else {
			for (int i = k; i <= numItems - 2; i++)
				item[i] = item[i + 1];	// �½���Ʈ
			numItems--;
			return true;
		}
	}
  
	// [�˰��� 5-5] ����: �迭 ����Ʈ�� i��° ���� �˷��ֱ�
	public Integer get(int index) {	// ù ��° ���Ҹ� 0��° ���ҷ� ǥ��
		if (index >= 0 && index <= numItems - 1)
			return item[index];
		else
			return null;
	}
 
	// [�˰��� 5-6] ����: �迭 ����Ʈ�� i��° ���Ҹ� x�� ��ü�ϱ�
	public void set(int index, Integer x) {
		if (index >= 0 && index <= numItems - 1)
			item[index] = x;
		else { /* ���� ó�� */ }
	}
 
	// [�˰��� 5-7] ����: ���� x�� �迭 ����Ʈ�� �� ��° �������� �˷��ֱ�
	private final int NOT_FOUND = -12345;
	public int indexOf(E x) {
 		int i = 0;
 		for (i = 0; i < numItems; i++) {
			if (((Comparable)item[i]).compareTo(x) == 0)
				return i;
 		}
    	return NOT_FOUND; // not exist
  }
	
	// [�˰��� 5-8(1)] ����: �迭 ����Ʈ�� �� ���� �� �˷��ֱ�
	public int len() {
		return numItems;
	}
	
	// [�˰��� 5-8(2)] ����: �迭 ����Ʈ�� ������� �˷��ֱ�
	public boolean isEmpty() {
		return numItems == 0;
	}
 
	// [�˰��� 5-8(3)] ����: �迭 ����Ʈ ������ û���ϱ�
	public void clear() {
		item = new Integer[item.length];
		numItems = 0;
	}

	///////////////////////////////////////////////////////////////////////
	public void printAll() {
		System.out.print("Print list (#items=" + numItems + ") ");
		for(int i = 0; i < numItems; i++) 
			System.out.print(item[i] + " ");
		System.out.println();
	}
} // �ڵ� 5-2
