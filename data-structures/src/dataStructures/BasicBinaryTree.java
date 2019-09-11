package dataStructures;

public class BasicBinaryTree<X extends Comparable<X>> {

	private Node root;
	private int size;
	
	
	public BasicBinaryTree() {
		this.root = null;
	}
	
	public int size() {
		return size;
	}
	
	public boolean contains(X item) {
		Node currentNode = getNode(item);
		if(currentNode == null) {
			//didnt find it
			return false;
		} else {
			return true;
		}
	}
	
	//This can be done recursively - like insert() - but this method will not be recursive
	private Node getNode(X item) {
		Node currentNode = this.root;
		
		while(currentNode != null) {
			int val = item.compareTo(currentNode.getItem());
			//see if the node is a match
			if(val == 0) {
				return currentNode;
			} else if( val < 0) {
				// if the value is lessn than 0, we go to the left side 
				currentNode = currentNode.getLeft();
			} else {
				currentNode = currentNode.getRight();
			}
		}
		return null;
	}
	
	public void add(X item) {
		Node node =  new Node(item);
		
		//if this is the first item in the tree, set it as root
		if(root == null) {
			this.root = node;
			System.out.println("Set root: " + node.getItem());
			this.size++;
		} else {
			insert(this.root, node);
		}
		
	}
	
	//Helper method to recurse when we use the ADD method
	private void insert(Node parent, Node child) {
		//if the child is less than parent, it goes on the left
		if(child.getItem().compareTo(parent.getItem()) < 0) {
			//if the left node is null, we've found our spot
			if(parent.getLeft() == null) {
				parent.setLeft(child);
				child.setParent(parent);
				this.size++;
			} else {
				//otherwise we need to call insert again and test for left or right (recursioooon)
				insert(parent.getLeft(), child);
			}
		} else if(child.getItem().compareTo(parent.getItem()) > 0) {
			//if the right node is null, we've found our spot
			if(parent.getRight() == null) {
				parent.setRight(child);
				child.setParent(parent);
				this.size++;
			} else {
				//again, we need to recurse test for the left or right
				insert(parent.getRight(), child);
			}
		}
		
		//if the parent and the child heppen to be equal, we won't do anything
		// data in a binary tree is assumed to be unique and the value alreadys exists in the tree
		// if you want to allow duplicates we would have some more code here
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
