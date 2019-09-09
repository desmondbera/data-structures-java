package dataStructures;

import dataStructureInterfaces.BasicQueueInterface;

public class BasicQueue<X> implements BasicQueueInterface<X> {
	private X[] data;
	private int front;
	private int end;
	
	public BasicQueue() {
		this(1000);
	}
	
	public BasicQueue(int size) {
		this.front = -1;
		this.end = -1;
		data = (X[]) new Object[size];
	}
	
	@Override
	public int size() {
		if(front == -1 && end == -1) {
			return 0;
		} else {
			return end - front + 1;
		}
	}
	
	@Override
	public void enQueue(X item) {
		//first check if the queue is full
		if((end + 1) % data.length == front) {
			throw new IllegalStateException("The queue is full!");
		} else if(size() == 0) {
			//Otherwise check to see if any items have been added to the queue yet
			front++;
			end++;
			data[end] = item;
		} else {
			end++;
			data[end] = item;
		}
	}
	
	@Override
	public X deQueue() {
		X item = null;
		// if queue is empty we can't dequeue anything
		if(size() == 0) {
			throw new IllegalStateException("Can't dequeue bc the queue is empty");
		} else if(front == end) {
			item = data[front];
			data[front] = null;
			front = -1;
			end = -1;
		} else {
			item = data[front];
			data[front] = null;
			front++;
		}
		return item;
	}
	
	@Override
	public boolean contains(X item) {
		boolean found = false;
		
		if(size() == 0) {
			return found;
		}
		
		for(int x = front; x < end; x++) {
			if(data[x].equals(item)) {
				found = true;
				break;
			}
		}
		
		return found;
	}
	
	@Override
	public X access(int position) {
		if(size() == 0 || position > size()) {
			throw new IllegalArgumentException("No items in queue or position is greater than size.");
		}
		int trueIndex = 0;
		for(int x = front; x < end; x++) {
			if(trueIndex == x) {
				return data[x];
			}
			trueIndex++;
		}
		throw new IllegalArgumentException("Could not access queue item at position: " + position);
	}
}
