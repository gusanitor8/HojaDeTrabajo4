

//DoubleList
public class StackSingleList<T> implements IStack<T> {

	private SingleList<T> single = new SingleList<T>();
	
	@Override
	public void push(T valuet) {		
		single.InsertAtStart(valuet);
	}

	@Override
	public T pull() {
		return single.DeleteAtStart();
	}

	@Override
	public T peek() {
		return single.Get(0);
	}

	@Override
	public int count() {
		return single.Count();
	}

	@Override
	public boolean isEmpty() {		
		return single.IsEmpty();
	}

}