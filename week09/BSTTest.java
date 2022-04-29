package week09;

public class BSTTest {
	public static void main(String[] args) {
		BinarySearchTree bst = new BinarySearchTree();
		
		bst.insertBST('G');		bst.insertBST('I');
		bst.insertBST('H');		bst.insertBST('D');
		bst.insertBST('B');		bst.insertBST('M');
		bst.insertBST('N');		bst.insertBST('A');
		bst.insertBST('J');		bst.insertBST('E');
		bst.insertBST('Q');
		System.out.printf("Binary Search Tree >>> ");
		bst.printBST();
		
		System.out.println();
		System.out.println("Is there \"A\"? >>> ");
		TreeNode p1 = bst.searchBST('A');
		if(p1 != null)
			System.out.printf("Searching success!!! Searched key : %c\n", p1.data);
		else
			System.out.printf("Searching fail!!! There is no : %c\n", p1.data);
		
		
		System.out.println();
		System.out.println("Is there \"Z\"? >>> ");
		TreeNode p2 = bst.searchBST('Z');
		if(p2 != null)
			System.out.printf("Searching success!!! Searched key : %c\n", p2.data);
		else
			System.out.printf("Searching fail!!!");
		
		
	}
}
