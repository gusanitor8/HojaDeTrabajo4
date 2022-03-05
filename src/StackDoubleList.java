public void StackArrayList<T> implements IStack<T> {

	private ArrayList<T> coreList;
	
	public StackArrayList() {
		coreList = new ArrayList<T>();
	}
	
	@Override
	public void push(T value) {		
		coreList.start(0, value);
	}

	@Override
	public T pull() {
		return coreList.end(0);
	}

	@Override
	public T peek() {
		return coreList.temp (0);
	}

	@Override
	public int Count() {
		return coreList.value();
	}

	@Override
	public boolean isEmpty() {		
		return coreList.isEmpty();
	}

}	
