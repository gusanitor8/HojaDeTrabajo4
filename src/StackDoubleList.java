public class StackDoubleList<T> implements IStack<T> {

	private DoubleLinkedList<T> doub = new DoubleLinkedList<T>();
	
	@Override
	public void push(T valuet) {		
		doub.InsertAtStart(valuet);
	}

	@Override
	public T pull() {
		return doub.DeleteAtStart();
	}

	@Override
	public T peek() {
		return doub.Get(0);
	}

	@Override
	public int count() {
		return doub.Count();
	}

	@Override
	public boolean isEmpty() {		
		return doub.IsEmpty();
	}

}	
