public class DoubleLinkedList<T> implements IList<T> 

	private DoubleNode<T> startt;
	private DoubleNode<T> endt;
	private int count;
	
	public DoubleLinkedList() {
		startt = null;
		endt = null;
		countt = 0;
	}
	
	@Override
	public void InsertAtStart(T valuet) {
		DoubleNode<T> newNode = new DoubleNode<T>(valuet);
		
		if (IsEmptyT()) {
		
			startt = newNode;
			endt = newNode;
			startt.setNext(startt);
			startt.setPrevious(startt);
		} else {
			
			newNode.setNext(startt);
			startt.setPrevious(newNode);
			newNode.setPrevious(endt);
			endt.setNext(newNode);
			startt = newNode;
		}
		
		count++;
	}

	@Override
	public void InsertAtendt(T valuet) {
		
	DoubleNode<T> newNode = new DoubleNode<T>(valuet);
		
		if (IsEmptyT()) {
		
			startt = newNode;
			endt = newNode;
			startt.setNext(startt);
			startt.setPrevious(startt);
		} else {
			
			newNode.setPrevious(endt);
			newNode.setNext(startt);
			startt.setPrevious(newNode);
			endt.setNext(newNode);
			endt = newNode;
		}
		
		count++;
		
	}

	@Override
	public void Insert(T valuet, int index) {
		
		if (IsEmptyT()) //if the list is empty then insert at start
        {
            InsertAtstartt(valuet);
        }
        else 
        {
            if (index >= Count()) //if the index is equal or greater than count then insert at end
            {
                InsertAtendt(valuet);
            } 
            else if (index == 0) //If the index to insert is 0 and the list is not empty
            {
                InsertAtstartt(valuet);
            }
            else if ((index > 0) && (index < Count())) //Index between 1 (second element) and Count() - 1 previous the last one
            {
                DoubleNode<T> newNode = new DoubleNode<T>(valuet);
                DoubleNode<T> tempt = startt;
                int i = 0;

                //Search the position where the node will be inserted
                while ((tempt != null) && (i < index)) {
                    tempt = tempt.getNext();
                    i++;
                }

                //doing the insertion
                newNode.setNext(tempt);
                newNode.setPrevious(tempt.getPrevious());
                tempt.setPrevious(newNode);
                newNode.getPrevious().setNext(newNode);
                count++;
            }
        }
		
	}

	@Override
	public T Delete(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T DeleteAtstartt() {
		if (!IsEmptyT()) {
			
			if (Count() == 1) {
				DoubleNode<T> tempt = startt;
				startt = null;
				endt = null;
				count--;
				return tempt.getValuet();
			} else {
				DoubleNode<T> tempt = startt;
				endt.setNext(tempt.getNext());
				tempt.getNext().setPrevious(endt);
				startt = tempt.getNext();
				count--;
				return tempt.getValuet();
			}
			
		} else {
			return null;
		}
		
		
	}

	@Override
	public T DeleteAtendt() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T Get(int index) {
	    if (!IsEmptyT())
        {
            if (index == 0)
            {
                return startt.getValuet();
            }
            else if (index == (Count() - 1))
            {
                return endt.getValuet();
            }
            else if ((index > 0) && (index < (Count() - 1)))
            {
                DoubleNode<T> tempt = startt;
                int i = 0;
                while ((tempt != null) && (i != index))
                {
                    tempt = tempt.getNext();
                    i++;
                }

                if (tempt != null)
                {
                    return tempt.getValuet();
                }
                else
                {
                    return null;
                }
            }
            else
            {
                return null;
            }
        }

        return null;

	}

	@Override
	public boolean IsEmptyT() {
		return count == 0;
	}

	@Override
	public int Count() {
		return count;
	}

	
}
