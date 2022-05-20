package week12;

public class AVLTree implements IndexInterface<AVLNode> {
	private AVLNode root;
	static final AVLNode NIL = new AVLNode(null, null, null, 0);

	public AVLTree() {
		root = NIL;
	}

	// [�˰��� 10-1] ���� : �˻�
	public AVLNode search(Comparable x) {
		return searchItem(root, x);
	}

	private AVLNode searchItem(AVLNode tNode, Comparable x) {
		if (tNode == NIL)
			return NIL;
		else if (x.compareTo(tNode.item) == 0)
			return tNode;
		else if (x.compareTo(tNode.item) < 0)
			return searchItem(tNode.left, x);
		else
			return searchItem(tNode.right, x);
	}

	// [�˰��� 10-3] ���� : ����
	public void insert(Comparable x) {
		root = insertItem(root, x);
	}

	private AVLNode insertItem(AVLNode tNode, Comparable x) {
 		if (tNode == NIL) { // insert after a leaf  (or into an empty tree)
 			tNode = new AVLNode(x);
 		} else  if (x.compareTo(tNode.item) < 0) { // branch left
 			tNode.left = insertItem(tNode.left, x);
 			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
 			int type = needBalance(tNode);
 			if(type != NO_NEED) 
 				tNode = balanceAVL(tNode, type);
 		} else { // branch right
 			tNode.right = insertItem(tNode.right, x);
 			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
 			int type = needBalance(tNode);
 			if(type != NO_NEED)
 				tNode = balanceAVL(tNode, type);
 			}
 		return tNode;
	}

	// [�˰��� 10-3] ���� : ����
	public void delete(Comparable x) {
		root = deleteItem(root, x);
	}

	private AVLNode deleteItem(AVLNode tNode, Comparable x) {
		if (tNode == NIL)
			return NIL;
		else {
			if (x.compareTo(tNode.item) == 0) {
				tNode = deleteNode(tNode);
			} else if (x.compareTo(tNode.item) < 0) {
				tNode.left = deleteItem(tNode.left, x);
				tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
				int type = needBalance(tNode);
				if (type != NO_NEED)
					tNode = balanceAVL(tNode, type);
			} else {
				tNode.right = deleteItem(tNode.right, x);
				tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
				int type = needBalance(tNode);
				if (type != NO_NEED)
					tNode = balanceAVL(tNode, type);
			}
			return tNode;
		}
	}

	private AVLNode deleteNode(AVLNode tNode) {
		// 3���� case
		// 1. tNode�� ���� ���
		// 2. tNode�� �ڽ��� �ϳ��� ����
		// 3. tNode�� �ڽ��� �� ����
		if ((tNode.left == NIL) && (tNode.right == NIL)) // case 1(�ڽ��� ����)
			return NIL;
		else if (tNode.left == NIL) // case 2(�����ڽĻ�)
			return tNode.right;
		else if (tNode.right == NIL) // case 2(���ڽĻ�)
			return tNode.left;
		else { // case 3(�� �ڽ��� �� ����)
			returnPair rPair = deleteMinItem(tNode.right);
			tNode.item = rPair.item;
			tNode.right = rPair.node;
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			int type = needBalance(tNode);
			if (type != NO_NEED)
				tNode = balanceAVL(tNode, type);
			return tNode;
		}
	}

	private returnPair deleteMinItem(AVLNode tNode) {
		int type;
		if (tNode.left == NIL) {
			return new returnPair(tNode.item, tNode.right);
		} else {
			returnPair rPair = deleteMinItem(tNode.left);
			tNode.left = rPair.node;
			tNode.height = 1 + Math.max(tNode.right.height, tNode.left.height);
			type = needBalance(tNode);
			if (type != NO_NEED)
				tNode = balanceAVL(tNode, type);
			rPair.node = tNode;
			return rPair;
		}
	}

	private class returnPair {
		private Comparable item;
		private AVLNode node;

		private returnPair(Comparable it, AVLNode nd) {
			item = it;
			node = nd;
		}
	}

	// ���� ���
	private AVLNode balanceAVL(AVLNode tNode, int type) {
		AVLNode returnNode = NIL;
		switch (type) {
		case LL:
			returnNode = rightRotate(tNode);
			break;
		case LR:
			tNode.left = leftRotate(tNode.left);
			returnNode = rightRotate(tNode);
			break;
		case RR:
			returnNode = leftRotate(tNode);
			break;
		case RL:
			tNode.right = rightRotate(tNode.right);
			returnNode = leftRotate(tNode);
			break;
		default:
			System.out.println("Impossible type! Should be one of LL, LR, RR, RL");
			break;
		}
		return returnNode;
	}

	// [�˰��� 11-1] ���� : ��ȸ��
	private AVLNode leftRotate(AVLNode t) {
		AVLNode RChild = t.right;
		if (RChild == NIL)
			System.out.println(t.item + "'s RChild shouldn't be NIL!");
		AVLNode RLChild = RChild.left;
		RChild.left = t;
		t.right = RLChild;
		t.height = 1 + Math.max(t.left.height, t.right.height);
		RChild.height = 1 + Math.max(RChild.left.height, RChild.right.height);
		return RChild;
	}

	// [�˰��� 11-1] ���� : ��ȸ��
	private AVLNode rightRotate(AVLNode t) {
		AVLNode LChild = t.left;
		if (LChild == NIL)
			System.out.println(t.item + "'s LChild shouldn't be NIL!");
		AVLNode LRChild = LChild.right;
		LChild.right = t;
		t.left = LRChild;
		t.height = 1 + Math.max(t.left.height, t.right.height);
		LChild.height = 1 + Math.max(LChild.left.height, LChild.right.height);
		return LChild;
	}

	private final int LL = 1, LR = 2, RR = 3, RL = 4, NO_NEED = 0, ILLEGAL = -1;

	private int needBalance(AVLNode t) {
		int type = ILLEGAL;
		if (t.left.height + 2 <= t.right.height) { // R ����
			if ((t.right.left.height) <= t.right.right.height) // RR ����
				type = RR;
			else // RL ����
				type = RL;
		} else if ((t.left.height) >= t.right.height + 2) { // L ����
			if ((t.left.left.height) >= t.left.right.height) // LL ����
				type = LL;
			else // LR ����
				type = LR;
		} else
			type = NO_NEED;
		return type;
	}

	// ��Ÿ
	public boolean isEmpty() {
		return root == NIL;
	}

	public void clear() {
		root = NIL;
	}

	/////////////////////////////////////////////////////
	public void printPreOrder() {
		System.out.println("AVL Tree in preorder: (item, height)");
		prPreOrder(root);
	}

	public void prPreOrder(AVLNode tNode) {
		if (tNode != NIL) {
			System.out.println("(" + tNode.item + ", " + tNode.height + ")");
			prPreOrder(tNode.left);
			prPreOrder(tNode.right);
		}
	}
} // �ڵ� 11-2
