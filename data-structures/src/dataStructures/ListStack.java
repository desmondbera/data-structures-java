package dataStructures;

import java.util.ArrayList;

import dataStructureInterfaces.BasicStackInterface;

public class ListStack<X> implements BasicStackInterface<X> {

	private ArrayList<X> data = new ArrayList<X>();
	private int stackPointer;
	
	public ListStack() {
		this.stackPointer = 0;
	}
	
	@Override
	public void push(X newItem) {
		data.add(newItem);
		stackPointer++;
	}

	@Override
	public X pop() {
		if(stackPointer == 0) {
			throw new IllegalStateException("No more items on the stack.");
		}
//		X tempItem = data.get(stackPointer);
//		System.out.println("Our stack pointer before removing is: " + stackPointer);
		stackPointer--;
		return data.remove(stackPointer);
//		
//		return data.get(stackPointer);
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;
		for(int x = 0; x < stackPointer; x++) {
			if(data.get(x).equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	@Override
	public X access(X item) {
		while(stackPointer > 0) {
			X tempItem = pop();
			if(item.equals(tempItem)) {
				return tempItem;
			}
		}
		throw new IllegalArgumentException("Could not find item on the stack: " + item);
	}

	public int size() {
		return stackPointer;
	}
	
}
