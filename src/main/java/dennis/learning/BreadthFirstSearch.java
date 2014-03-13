package dennis.learning;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BreadthFirstSearch {
	/**
	 * Traverse a tree using Breadth First Search.  Will assign and return sibling nodes.
	 * A sibling node is a node to the right of another node in the same level of a tree.
	 * @param root
	 */
	public void bfs(Node root) {
		Queue<Node> nodeQueue = new LinkedList<Node>();
		Queue<Node> siblingQueue = new LinkedList<Node>();
		nodeQueue.add(root);
		while (!nodeQueue.isEmpty()) {
			Node node = nodeQueue.poll();
			if (node == null) {
				break;
			}
			System.out.println(node.data);
			Node leftNode = node.leftNode;
			Node rightNode = node.rightNode;
			if (leftNode != null) {
				nodeQueue.add(leftNode);
				siblingQueue.add(leftNode);
			}
			if (rightNode != null) {
				nodeQueue.add(rightNode);
				siblingQueue.add(rightNode);
			}
			Node previousSiblingNode = siblingQueue.poll();
			for (Node siblingNode : siblingQueue) {
				//System.out.print(previousSiblingNode);
				//System.out.print("->");
				previousSiblingNode.sibling = siblingNode;
				//System.out.println(siblingNode);
				previousSiblingNode = siblingNode;
			}
			siblingQueue.clear();
		}
	}


}