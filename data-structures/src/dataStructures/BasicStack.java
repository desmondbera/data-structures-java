package dataStructures;

import dataStructureInterfaces.BasicStackInterface;

public class BasicStack<X> implements BasicStackInterface<X> {

	// Using a primitive data type of array w/ Generic type
	private X[] data;
	// An internal pointer on our data structure - not available thru getters /
	// setters
	private int stackPointer;

	// Constructor
	public BasicStack() {
		this.data = (X[]) new Object[1000];
		stackPointer = 0;
	}

	// Create insert / delete methods (push / pop)
	// Time complexity: O(1)
	@Override
	public void push(X newItem) {
		// add to underlying array
		// also uses post-increment
		data[stackPointer++] = newItem;
	}

	// Create contains / access methods (search)
	// Time complexity: O(n)
	@Override
	public X pop() {

		// Handle exception when stack is empty
		if (stackPointer == 0) {
			throw new IllegalStateException("No more items on the stack.");
		}

		// uses pre-increment
		return data[--stackPointer];
	}

	// Search data structure for x-item
	// Time complexity: O(n)
	@Override
	public boolean contains(X item) {
		boolean found = false;

		for (int x = 0; x < stackPointer; x++) {
			if (data[x].equals(item)) {
				found = true;
				break;
			}
		}

		return found;
	}

	// Retrieve x-item
	// Time complexity: O(n)
	@Override
	public X access(X item) {
		while (stackPointer > 0) {
			X tempItem = pop();
			if (item.equals(tempItem)) {
				return tempItem;
			}
		}
		throw new IllegalArgumentException("Could not find item on the stack: " + item);
	}

	// Size of our data structure
	public int size() {
		return stackPointer;
	}


}
