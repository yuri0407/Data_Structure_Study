package week12;

public class BinarySearchTree implements IndexInterface<TreeNode> {
	private TreeNode root;
	public BinarySearchTree() { // ������
		root = null;
	}
	
	// [�˰��� 10-1] ���� : �˻�
	public TreeNode search(Comparable searchKey) {
		return searchItem(root, searchKey);
	}
	
	private TreeNode searchItem(TreeNode tNode, Comparable searchKey) {
		if (tNode == null) 
			return null;  // �˻� ����
		else if (searchKey.compareTo(tNode.key) == 0)
			return tNode;
		else if (searchKey.compareTo(tNode.key) < 0)
			return searchItem(tNode.left, searchKey);
		else 
			return searchItem(tNode.right, searchKey);
	}
	
	// [�˰��� 10-3] ���� : ����
	public void insert(Comparable newKey) {
		root = insertItem(root, newKey);
	}
 
	private TreeNode insertItem(TreeNode tNode, Comparable newItem) {
		if (tNode == null)  // insert after a leaf  (or into an empty tree)
			tNode = new TreeNode(newItem, null, null);
		else  if (newItem.compareTo(tNode.key) < 0) 	// branch left
			tNode.left = insertItem(tNode.left, newItem);
		else  					// branch right
			tNode.right = insertItem(tNode.right, newItem);
		return tNode; 
	}
	
	// [�˰��� 10-3] ���� : ����
	public void delete(Comparable searchKey) {
		root = deleteItem(root, searchKey);
	}
	
	private TreeNode deleteItem(TreeNode tNode, Comparable searchKey) {
		if (tNode == null) return null;	// key not found!
		else {
			if (searchKey == tNode.key) 	// key found at tNode
				tNode = deleteNode(tNode);
			else if (searchKey.compareTo(tNode.key) < 0) 
				tNode.left = deleteItem(tNode.left, searchKey);
			else 
				tNode.right = deleteItem(tNode.right, searchKey);
			return tNode;
		}
	}
 
	private TreeNode deleteNode(TreeNode tNode) {
	// 3���� case
		//    1. tNode�� ���� ���
		//    2. tNode�� �ڽ��� �ϳ��� ����
		//    3. tNode�� �ڽ��� �� ����
		if ((tNode.left == null) && (tNode.right == null))  // case 1(�ڽ��� ����)
			return null;  
		else if (tNode.left == null) 	// case 2(�����ڽĻ�)
			return tNode.right;
      	else if (tNode.right == null)   	// case 2(���ڽĻ�)
       		return tNode.left;	
       else {	 	 	 	 		// case 3(�� �ڽ��� �� ����)
        		returnPair rPair = deleteMinItem(tNode.right);
        		tNode.key = rPair.key; tNode.right = rPair.node;
        		return tNode; 
        	}
	}
	
	private returnPair deleteMinItem(TreeNode tNode) {
		if (tNode.left == null) 
			return new returnPair(tNode.key,tNode.right);
		else {
			returnPair rPair = deleteMinItem(tNode.left); 
			tNode.left = rPair.node;
			rPair.node = tNode;
			return rPair;
		}
	}
	
	private class returnPair {
		private Comparable key;
		private TreeNode node;
		private returnPair(Comparable it, TreeNode nd) {
			key = it;
			node = nd;
		}
	}
	
	// ��Ÿ
	public boolean isEmpty() {
		return root == null;
	}
	
	public void clear() {
		root = null;
	}

	/////////////////////////////////////////////////
	public void printPreOrder() {
		prPreOrder(root);
	}
	public void prPreOrder(TreeNode tNode) {
		if (tNode != null) {
			System.out.println(tNode.key);
			prPreOrder(tNode.left);
			prPreOrder(tNode.right);
		}
	}
} // �ڵ� 10-3
