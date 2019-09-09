package dataStructures;

public class BasicLinkedList<X> {
	
	private Node first;
	private Node last;
	
	public BasicLinkedList() {
		first = null;
		last = null;
	}
	
	//Our node class inside of our Linked List 
	private class Node {
		private Node nextNode;
		private X nodeItem;
		
		//Constructor for each node
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
