package dennis.learning;

import org.junit.Before;
import org.junit.Test;

public class GraphTraversalTest {
	public static GraphTraversal gt;
	public static Node root;

	@Before
	public void setup() {
		gt = new GraphTraversal();
		root = new Node(1);
		root.rightNode = new Node(2);
		root.leftNode = new Node(3);
		root.leftNode.rightNode = new Node(4);
		root.leftNode.leftNode = root;
		root.rightNode.leftNode = root.leftNode;
		root.rightNode.rightNode = new Node(5);
//		root = new Node(6);
//		root.leftNode = new Node(2);
//		root.rightNode = new Node(10);
//		root.leftNode.leftNode = new Node(1);
//		root.leftNode.rightNode = new Node(3);
//		root.rightNode.leftNode = new Node(8);
//		root.rightNode.rightNode = new Node(12);
//		root.rightNode.rightNode.leftNode = root;
//		root.rightNode.rightNode.rightNode = root.rightNode;
	}
	
	@Test
	public void testPreorder() {
		gt.preorder(root);
	}
}
