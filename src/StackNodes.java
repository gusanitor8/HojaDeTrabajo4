
public class StackNodes<T> implements IStack<T>  {

	private Node<T> head;
	private int count;
	public T tempo;
	
	public StackNodes() {
		head = null;
	}
	
	/***
	 * Hace un push de un valor dentro de un node
	 */
	public void push(T value) {
		Node<T> newNode = new Node<T>(value);
		
		if (isEmpty()) {
			head = newNode;
		} else {
			newNode.setNext(head);
			head = newNode;
		}
		count++;
	}

	/***
	 * Hace un pull quitando un valor de la pila 
	 * @return el valor que fue retirado
	 */
	public T pull() {
		
		if (count() == 0) {
			return null;
		} else if(count() == 1) {
			Node<T> temp = head;
			head = null;
			count--;
			return temp.getValue();
		} else {
			Node<T> temp = head;
			head = temp.getNext();
			count--;
			return temp.getValue();
		}
		
	}

	/***
	 * Muestra un valor de la pila 
	 * @return valor escogido
	 */
	public T peek() {
		if (isEmpty()) {
			return null;
		} else {
			return head.getValue();
		}
	}

	/***
	 * muestra cuantos valores hay en la pila
	 * @return cantidad de valores
	 */
	public int count() {
		return count;
	}

	/***
	 * muestra si la pila se encuntra vacia 
	 * @return boolean del estado de la pila
	 */
	public boolean isEmpty() {
		return (head == null);
	}

}
