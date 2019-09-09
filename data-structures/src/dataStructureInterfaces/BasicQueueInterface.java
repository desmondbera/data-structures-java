package dataStructureInterfaces;

public interface BasicQueueInterface<X> {

	X access(int position);

	boolean contains(X item);

	X deQueue();

	void enQueue(X item);

	int size();

}
