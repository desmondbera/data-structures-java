package dataStructures;

public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	
	public BasicBinaryTree() {
		this.root = null;
	}
	
	private class Node {
		private Node left;
		private Node right;
		
		private Node parent;
		private X item;
		
		public Node(X item) {
			this.item = item;
			this.left = null;
			this.right = null;
			this.parent = null;
		}

		public Node getLeft() {
			return left;
		}

		public void setLeft(Node left) {
			this.left = left;
		}

		public Node getRight() {
			return right;
		}

		public void setRight(Node right) {
			this.right = right;
		}

		public Node getParent() {
			return parent;
		}

		public void setParent(Node parent) {
			this.parent = parent;
		}

		public X getItem() {
			return item;
		}

		public void setItem(X item) {
			this.item = item;
		}
		
		
	}
	
}
