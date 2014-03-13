package dennis.learning;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DepthFirstSearchTest {
	public static DepthFirstSearch dfs;
	public static Node root;
	public static Node sameData = null;

	@Before
	public void setup() {
		dfs = new DepthFirstSearch();
		root = new Node(1);
		root.leftNode = new Node(2);
		root.rightNode = new Node(5);
		root.leftNode.leftNode = new Node(3);
		root.leftNode.rightNode = new Node(4);
		root.rightNode.leftNode = new Node(5);
		root.rightNode.rightNode = new Node(5);
	}
	
	@Test
	public void testDfs() {
		Node sameData = dfs.dfs(root);
		Assert.assertEquals(5, sameData.data);
	}

	@Test
	public void testDfsWithNull() {
		root.rightNode.rightNode = null;
		Node sameData = dfs.dfs(root);
		Assert.assertEquals(5, sameData.data);
	}
	
	@Test
	public void testDfsWithNotSameData() {
		root.rightNode.rightNode = new Node(6);
		Node sameData = dfs.dfs(root);
		Assert.assertNull(sameData);
	}
	@Test
	public void testDfsWithNotSameDataInChildren() {
		root.rightNode.rightNode.leftNode = new Node(6);
		Node sameData = dfs.dfs(root);
		Assert.assertNull(sameData);
	}
	@Test
	public void testDfsWithTwoSameTrees() {
		root.leftNode.leftNode = new Node(2);
		root.leftNode.rightNode = new Node(2);
		Node sameData = dfs.dfs(root);
		Assert.assertEquals(5, sameData.data);
	}
	
	@Test
	public void testDfsRecursive() {
		sameData = dfs.dfsRecursive(root, sameData);
		Assert.assertEquals(5, sameData.data);
	}
	
	@Test
	public void testDfsRecursiveWithNull() {
		root.rightNode.rightNode = null;
		sameData = dfs.dfsRecursive(root, sameData);
		Assert.assertEquals(5, sameData.data);
	}
	@Test
	public void testDfsRecursiveWithNotSameData() {
		root.rightNode.rightNode = new Node(6);
		sameData = dfs.dfsRecursive(root, sameData);
		Assert.assertNull(sameData);
	}
	@Test
	public void testDfsRecursiveWithNotSameDataInChildren() {
		root.rightNode.rightNode.leftNode = new Node(6);
		sameData = dfs.dfsRecursive(root, sameData);
		Assert.assertNull(sameData);
	}
	@Test
	public void testDfsRecursiveWithTwoSameTrees() {
		//TODO Multiple nodes
		root.leftNode.leftNode = new Node(2);
		root.leftNode.rightNode = new Node(2);
		sameData = dfs.dfsRecursive(root, sameData);
		Assert.assertEquals(5, sameData.data);
	}
	
	@Test
	public void testFindLowestCommonAncestor() {
		dfs = new DepthFirstSearch();
		root = new Node(1);
		root.leftNode = new Node(2);
		root.rightNode = new Node(3);
		root.leftNode.leftNode = new Node(4);
		root.leftNode.rightNode = new Node(5);
		root.rightNode.leftNode = new Node(6);
		root.rightNode.rightNode = new Node(7);
		root.leftNode.leftNode.leftNode = new Node(8);
		root.leftNode.leftNode.rightNode = new Node(9);
		root.leftNode.rightNode.leftNode = new Node(10);
		root.leftNode.rightNode.rightNode = new Node(11);
		root.rightNode.leftNode.leftNode = new Node(12);
		root.rightNode.leftNode.rightNode = new Node(13);
		root.rightNode.rightNode.leftNode = new Node(14);
		root.rightNode.rightNode.rightNode = new Node(15);
		//Test left side
		Node result = dfs.findLowestCommonAncestor(root, root.leftNode.leftNode, root.leftNode.rightNode.rightNode);
		Assert.assertEquals(2, result.data);
		//Test right side
		result = dfs.findLowestCommonAncestor(root, root.rightNode.rightNode.rightNode, root.rightNode.leftNode);
		Assert.assertEquals(3, result.data);
		//Test root
		result = dfs.findLowestCommonAncestor(root, root.rightNode.leftNode.leftNode, root.leftNode.rightNode);
		Assert.assertEquals(1, result.data);
		//Test one input node is lowest
		result = dfs.findLowestCommonAncestor(root, root.rightNode, root.rightNode.rightNode.rightNode);
		Assert.assertEquals(3, result.data);
		//Test both input nodes the same
		result = dfs.findLowestCommonAncestor(root, root.rightNode, root.rightNode);
		Assert.assertEquals(3, result.data);
		result = dfs.findLowestCommonAncestor(root, root.rightNode.rightNode.rightNode, root.rightNode.rightNode.rightNode);
		Assert.assertEquals(15, result.data);
	}
}
