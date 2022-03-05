//DoubleList
public void StackArrayListT<T> implements IStack<T> {

	private ArrayListT<T> coreListT;
	
	public StackArrayListT() {
		coreListT = new ArrayListT<T>();
	}
	
	@Override
	public void push(T valuet) {		
		coreListT.startt(0, valuet);
	}

	@Override
	public T pull() {
		return coreListT.endt(0);
	}

	@Override
	public T peek() {
		return coreListT.tempt (0);
	}

	@Override
	public int Count() {
		return coreListT.valuet();
	}

	@Override
	public boolean isEmpty() {		
		return coreListT.isEmptyT();
	}

}