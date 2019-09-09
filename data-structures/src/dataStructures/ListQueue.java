package dataStructures;

import java.util.ArrayList;

import dataStructureInterfaces.BasicQueueInterface;

public class ListQueue<X> implements BasicQueueInterface<X> {

	private ArrayList<X> data = new ArrayList<X>();
	private int front = -1;
	private int end = -1;

	public ListQueue() {}

	@Override
	public X access(int position) {
		
		if(size() == 0 || position > size() || position < 0) {
			throw new IllegalArgumentException("No items in queue or position.");
		}
		
		int trueIndex = 0;
		for(int x = front; x < end; x++) {
			if(trueIndex == position) {	
				return data.get(x);
			}
			trueIndex++;
		}
		throw new IllegalArgumentException("Could not access queue item at position: " + position);
	}

	@Override
	public boolean contains(X item) {
		boolean found = false;
		
		if(size() == 0) {
			return found;
		} 
		
		for(int x = front; x < end; x++) {
			if(data.get(x).equals(item)) {
				found = true;
				break;
			}
		}
		return found;
	}

	@Override
	public X deQueue() {
		X item = null;
		if(size() == 0) {
			throw new IllegalStateException("Can't dequeue bc the queue is empty");
		} else if (front == end) {
			item = data.get(front);
			
			data.set(front, null);
			front = -1;
			end = -1;
		} else {
			item = data.get(front);
			data.set(front, null);
			front++;
		}
		return item;
	}

	@Override
	public void enQueue(X item) {
		if(size() == 0) {
			front++;
			end++;
			data.add(item);
		} else {
			end++;
			data.add(item); 
		}

	}

	@Override
	public int size() {
		if(front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}
}
