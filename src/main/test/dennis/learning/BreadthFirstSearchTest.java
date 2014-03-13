package dennis.learning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BreadthFirstSearchTest {
	public static BreadthFirstSearch bfs;
	public static Node root;

	@Before
	public void setup() {
		bfs = new BreadthFirstSearch();
		root = new Node(1);
		root.leftNode = new Node(2);
		root.rightNode = new Node(3);
		root.leftNode.leftNode = new Node(4);
		root.leftNode.rightNode = new Node(5);
	}

	@Test
	public void testBFSFindSiblings() {
		bfs.bfs(root);
		Assert.assertEquals(root.leftNode.leftNode.sibling,
				root.leftNode.rightNode);
		Assert.assertEquals(root.leftNode.sibling, root.rightNode);
		Assert.assertNotEquals(root.rightNode.sibling, root.leftNode.leftNode);
	}

}