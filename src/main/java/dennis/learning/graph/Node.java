package dennis.learning.graph;

public class Node {
	Node leftNode;
	Node rightNode;
	Node sibling;
	int data;
	
	public Node(int data) {
		super();
		this.data = data;
	}
	
	public Node() {
	}
	
	public Node getLeftNode() {
		return leftNode;
	}
	public void setLeftNode(Node leftNode) {
		this.leftNode = leftNode;
	}
	public Node getRightNode() {
		return rightNode;
	}
	public void setRightNode(Node rightNode) {
		this.rightNode = rightNode;
	}
	public Node getSibling() {
		return sibling;
	}
	public void setSibling(Node sibling) {
		this.sibling = sibling;
	}
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	@Override
	public String toString() {
		return String.valueOf(data);
	}
}