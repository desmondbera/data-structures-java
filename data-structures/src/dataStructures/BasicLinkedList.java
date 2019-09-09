package dataStructures;

public class BasicLinkedList<X> {

	private Node first;
	private Node last;
	private int nodeCount;

	public BasicLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	public void add(X item) {
		// This is the condition when we are adding something for the first time
		// FIRST AND LAST node are the same. Essentially one node long list
		if (first == null) {
			first = new Node(item);
			last = first;
		} else {
			Node newLastNode = new Node(item);
			last.setNextNode(newLastNode);
			last = newLastNode;
		}
		nodeCount++;
	}

	// This will remove the first node on the list!
	public X remove() {
		if (first == null) {
			throw new IllegalArgumentException("There is no node to remove.");
		}
		X nodeItem = first.getNodeItem();
		first = first.getNextNode();
		
		nodeCount--;
		return nodeItem;
	}

	public int size() {
		return nodeCount;
	}

	// Our node class inside of our Linked List
	private class Node {
		private Node nextNode;
		private X nodeItem;

		// Constructor for each node
		public Node(X item) {
			this.nextNode = null;
			this.nodeItem = item;
		}

		public void setNextNode(Node nextNode) {
			this.nextNode = nextNode;
		}

		public Node getNextNode() {
			return nextNode;
		}

		public X getNodeItem() {
			return nodeItem;
		}

	}

}
