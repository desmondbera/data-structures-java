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
	
	public X removeAt(int position) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empthy and there are no items to remove.");
		}
		
		Node currentNode = first;
		Node prevNode = first;
		
		for(int x = 1; x < position && currentNode != null; x++) {
			prevNode = currentNode;
			currentNode = currentNode.getNextNode();
		}
		
		X nodeItem = currentNode.getNodeItem();
		prevNode.setNextNode(currentNode.getNextNode());
		
		nodeCount--;
		return nodeItem;
	}
	
	public X get(int position) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no itmes to get.");
		}
		
		Node currentNode = first;
		for(int x = 1; x < size() && currentNode != null; x++) {
			if(x == position) {
				return currentNode.getNodeItem();
			}
			currentNode = currentNode.getNextNode();
		}
		
		return null;
	}
	
	public int find(X item) {
		if(first == null) {
			throw new IllegalStateException("The LinkedList is empty and there are no items to find.");
		}
		
		Node currentNode = first;
		for(int x = 1; x < size() && currentNode != null; x++) {
			if(currentNode.getNodeItem().equals(item)) {
				return x;
			}
			currentNode = currentNode.getNextNode();
		}
		return -1;
	}
	
	public void insert(X item, int position) {
		if(size() < position) {
			throw new IllegalStateException("The linked list is smaller than the position you are looking for.");
		}
		
		Node currentNode = first;
		
		for(int x = 1; x < position && currentNode != null; x++) {
			currentNode = currentNode.getNextNode();
		}
		
		Node newNode = new Node(item);
		Node nextNode = currentNode.getNextNode();
		currentNode.setNextNode(newNode);
		newNode.setNextNode(nextNode);
		nodeCount++;
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
	
	public String toString() {
		StringBuffer contents = new StringBuffer();
		Node currNode = first;
		while(currNode != null) {
			contents.append(currNode.getNodeItem());
			currNode = currNode.getNextNode();
			
			if(currNode != null) {
				contents.append(", ");
			}
		}
		return contents.toString();
	}

}
