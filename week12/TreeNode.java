package week12;

public class TreeNode {
	public Comparable key;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(Comparable newKey) {
		key = newKey;
		left = right = null;
	}
	public TreeNode(Comparable newKey, TreeNode leftChild, TreeNode rightChild) {
		key = newKey;
		left = leftChild; right = rightChild;
	}
} // �ڵ� 10-2