package dennis.learning;

import org.junit.Before;
import org.junit.Test;

public class TreeTraversalTest {
	public static TreeTraversal tt;
	public static Node root;
	public static Node sameData = null;

	@Before
	public void setup() {
		tt = new TreeTraversal();
		root = new Node(6);
		root.leftNode = new Node(2);
		root.rightNode = new Node(10);
		root.leftNode.leftNode = new Node(1);
		root.leftNode.rightNode = new Node(3);
		root.rightNode.leftNode = new Node(8);
		root.rightNode.rightNode = new Node(12);
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testPreorder() {
		tt.preorder(root);
	}
	@Test
	public void testPreorderRecursive() {
		tt.preorder(root);
	}
	@Test
	public void testInorder() {
		tt.inorder(root);
	}
	
	@Test
	public void testInorderRecursive() {
		tt.inorderRecursive(root);
	}
	
	@Test
	public void testPostorderRecursive() {
		tt.postorderRecursive(root);
	}

}
