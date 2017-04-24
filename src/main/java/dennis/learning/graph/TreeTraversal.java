package dennis.learning.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Depth First Search for unordered binary trees.
 * @author Dennis
 *
 */
public class TreeTraversal {
	/**
	 * Iterative Depth First Search. Will iterate through the leftmost nodes first
	 * Will return subtrees that contain completely equal-valued nodes
	 * @param root
	 */
	public void preorder(Node root) {
		Stack<Node> nodeStack = new Stack<Node>();
		nodeStack.push(root);
		List<Node> visited = new ArrayList<Node>();
		while (!nodeStack.empty()) {
			Node node = nodeStack.pop();
			if (node == null) {
				continue;
			}
			System.out.println(node);
			visited.add(node);
			Node leftNode = node.leftNode;
			Node rightNode = node.rightNode;
			if (rightNode != null && !visited.contains(node)) {
				nodeStack.push(rightNode);
			}
			if (leftNode != null && !visited.contains(node)) {
				nodeStack.push(leftNode);
			}
		}
	}
	/**
	 * Recursive version of Depth First Search. Will iterate through the left most nodes first.
	 * Will return subtrees that contain completely equal-valued nodes
	 * @param root
	 * @param sameData
	 * @return
	 */
	public void preorderRecursive(Node root, Node sameData) { // TODO multiple subtrees with same data
		if (root == null) {
			return;
		}
		System.out.println(root);
		Node leftNode = root.leftNode;
		Node rightNode = root.rightNode;
		if (leftNode != null) {
			preorderRecursive(leftNode, sameData);
		}
		if (rightNode != null) {
			preorderRecursive(rightNode, sameData);
		}
	}
	
	public void inorder(Node root) {
		Stack<Node> nodeStack = new Stack<Node>();
		Node node = root;
		while (!nodeStack.isEmpty() || node != null) {
			if (node != null) {
				nodeStack.push(node);
				node = node.leftNode;
			} else {
				node = nodeStack.pop();
				System.out.println(node);
				node = node.rightNode;
			}
		}		
	}
	public void inorderRecursive(Node root) {
		if (root == null) {
			return;
		}
		Node leftNode = root.leftNode;
		Node rightNode = root.rightNode;
		if (leftNode != null) {
			inorderRecursive(leftNode);
		}
		System.out.println(root);
		if (rightNode != null) {
			inorderRecursive(rightNode);
		}
	}
	public void postorder(Node root) {
		Stack<Node> nodeStack = new Stack<Node>();
		Node node = root;
		while (!nodeStack.isEmpty() || node != null) {
			if (node != null) {
				nodeStack.push(node);
				node = node.leftNode;
			} else {
				node = nodeStack.pop();
				System.out.println(node);
				node = node.rightNode;
			}
		}		
	}
	public void postorderRecursive(Node root) {
		if (root == null) {
			return;
		}
		Node leftNode = root.leftNode;
		Node rightNode = root.rightNode;
		if (leftNode != null) {
			postorderRecursive(leftNode);
		}
		if (rightNode != null) {
			postorderRecursive(rightNode);
		}
		System.out.println(root);
	}
}
