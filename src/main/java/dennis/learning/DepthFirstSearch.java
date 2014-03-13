package dennis.learning;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Depth First Search for unordered binary trees.
 * @author Dennis
 *
 */
public class DepthFirstSearch {
	/**
	 * Iterative Depth First Search. Will iterate through the leftmost nodes first
	 * Will return subtrees that contain completely equal-valued nodes
	 * @param root
	 */
	public Node dfs(Node root) {
		Stack<Node> nodeStack = new Stack<Node>();
		Queue<Node> sameNodes = new LinkedList<Node>();
		int parentData = 0;
		nodeStack.push(root);
		Node sameNode = null;
		while (!nodeStack.empty()) {
			Node node = nodeStack.pop();
			if (node == null) {
				break;
			}
			System.out.println(node);
			if (parentData != node.data) {
				parentData = node.data;
				sameNodes.clear();
			}
			sameNodes.add(node);
			Node leftNode = node.leftNode;
			Node rightNode = node.rightNode;
			if (rightNode != null) {
				nodeStack.push(rightNode);
			}
			if (leftNode != null) {
				nodeStack.push(leftNode);
			}
		}
		if (sameNodes.size() > 1) {
			sameNode = sameNodes.peek();
			System.out.println("Same Nodes #" + sameNodes.size() + " Value " + sameNode);
		}
		return sameNode;
	}
	/**
	 * Recursive version of Depth First Search. Will iterate through the left most nodes first.
	 * Will return subtrees that contain completely equal-valued nodes
	 * @param root
	 * @param sameData
	 * @return
	 */
	public Node dfsRecursive(Node root, Node sameData) { // TODO multiple subtrees with same data
		if (root == null) {
			return null;
		}
		System.out.println(root);
		Node leftNode = root.leftNode;
		Node rightNode = root.rightNode;
		if (leftNode != null) {
			if (leftNode.data == root.data) {
				sameData = root;
			} else {
				sameData = null;
			}
			sameData = dfsRecursive(leftNode, sameData);
		}
		if (rightNode != null) {
			if (rightNode.data == root.data) {
				sameData = root;
			} else {
				sameData = null;
			}
			sameData = dfsRecursive(rightNode, sameData);
		}
		return sameData;
	}
	
	public Node findLowestCommonAncestor(Node root, Node firstAncestorNode, Node secondAncestorNode) {
		Stack<Node> nodeStack = new Stack<Node>();
		List<Node> traversalList = new LinkedList<Node>();
		nodeStack.push(root);
		while (!nodeStack.empty()) {
			Node node = nodeStack.pop();
			if (node == null) {
				break;
			}
			traversalList.add(node);
			Node leftNode = node.getLeftNode();
			Node rightNode = node.getRightNode();
			if (leftNode != null) {
				nodeStack.push(leftNode);
			}
			if (rightNode != null) {
				nodeStack.push(rightNode);
			}
		}
		List<Node> nextIterationList = null;
		List<Node> subListFirst = traversalList.subList(0, traversalList.indexOf(firstAncestorNode)+1);
		List<Node> subListSecond = traversalList.subList(0, traversalList.indexOf(secondAncestorNode)+1);
		if (subListFirst.size() <= subListSecond.size()) {
			nextIterationList = new LinkedList<Node>(subListFirst);
		} else {
			nextIterationList = new LinkedList<Node>(subListSecond);
		}
		Node ancestorNode = null;
		nodeStack.clear();
		for (Node iterationNode : nextIterationList) {
			boolean matchFirst = false;
			boolean matchSecond = false;
			nodeStack.push(iterationNode);
			while (!nodeStack.empty()) {
				Node node = nodeStack.pop();
				if (node == null) {
					break;
				}
				if (node.data == firstAncestorNode.data) {
					matchFirst = true;
				}
				if (node.data == secondAncestorNode.data) {
					matchSecond = true;
				}
				Node leftNode = node.getLeftNode();
				Node rightNode = node.getRightNode();
				if (leftNode != null) {
					nodeStack.push(leftNode);
				}
				if (rightNode != null) {
					nodeStack.push(rightNode);
				}
			}
			if (matchFirst && matchSecond) {
				ancestorNode = iterationNode;
			}
		}
		return ancestorNode;
	}
}
