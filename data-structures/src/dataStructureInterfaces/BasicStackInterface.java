package dataStructureInterfaces;

public interface BasicStackInterface<X> {
	void push(X newItem);
	X pop();
	boolean contains(X item);
	X access(X item);
}
