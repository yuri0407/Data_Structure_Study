package week09;

public class LinkedTree{
	private TreeNode root;
	
	public TreeNode makeBT(TreeNode bt1, char data, TreeNode bt2) {
		TreeNode root = new TreeNode();
		root.left = bt1;
		root.data = data;
		root.right = bt2;		
		return root;
	}
	
	public void preorder(TreeNode root) {
		if(root != null) {
			System.out.printf("%c", root.data);
			preorder(root.left);
			preorder(root.right);
		}
	}
	
	public void inorder(TreeNode root) {
		if(root != null) {
			inorder(root.left);
			System.out.printf("%c", root.data);
			inorder(root.right);
		}
	}
	
	public void postorder(TreeNode root) {
		if(root != null) {
			postorder(root.left);
			postorder(root.right);
			System.out.printf("%c", root.data);
		}
	}
}
