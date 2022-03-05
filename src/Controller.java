
public class Controller {
//-------------------------------------GUS-------------------------------------
	Vista vista = new Vista();
	String infix; 
	String postfix = "";
	StackVector<Token> vector = new StackVector<Token>();
	StackNodes<Token> miNode = new StackNodes<Token>();
	
	public void run() {
		switch(vista.mainMenu()) {
		case 1:
			toPostFixNodes(vista.infixInput());
			System.out.println(postfix);
			break;
		case 2:
			break;
		case 3:
			break;
		case 4:
			toPostFixVector(vista.infixInput());
			System.out.println(postfix);
			break;
		case 5:
			System.exit(0);
			break;
		default:
			break;
		}
		//TODO agregar metodos del controlador
	}
	
	
	public void toPostFixVector(String infix) {
		for(int i = 0; i< infix.length(); i++) {
			char ch = infix.charAt(i);
			
			try {
				Token token = new Token(ch);
				
				//Si la lista esta vacia deja pasar cualquier token sin importar su precedencia
				if(vector.isEmpty()) {
					vector.push(token);
					postfix += ' ';
				
				}else {
					if(token.compareTo(vector.peek()) <= 0 ){
						//TODO la precedencia del que esta antes es menor
						if((token.getToken() != ')')&&(token.getToken() != '(') ){
							postfix += token.getToken();
						}
					}else {
						//Si el que esta antes en el stack es de mayor precedencia
						greaterPrecedence(vector, token);
					}
				}
				
			}catch(NotATokenException e) {
				postfix += ch;
					
			}						 
		}
		emptyStack(vector);
	}
	
	
	public void greaterPrecedence(StackVector<Token> vector, Token token) {
		//vector.pull();
		while((vector.peek().getToken() != '(') || (token.compareTo(vector.peek()) >= 0)) {
			if (vector.peek().getToken() != '(') {
				postfix += vector.pull().getToken();
			}else {
				vector.pull();
			}
		}
	}
	
	
	public void emptyStack(StackVector<Token> vector) {
		if(vector.isEmpty() == false) {
			postfix += vector.pull().getToken();
		}
	}
	
//-------------------------------------DIEGUIN-------------------------------------
//Single List
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
//-------------------------------------MANUELIN-------------------------------------

public void toPostFixNodes(String infix) {
	for(int i = 0; i< infix.length(); i++) {
		char ch = infix.charAt(i);
		
		try {
			Token token = new Token(ch);
			
			//Si la lista esta vacia deja pasar cualquier token sin importar su precedencia
			if(miNode.isEmpty()) {
				miNode.push(token);
				postfix += ' ';
			
			}else {
				if(token.compareTo(miNode.peek()) <= 0 ){
					//TODO la precedencia del que esta antes es menor
					if((token.getToken() != ')')&&(token.getToken() != '(') ){
						postfix += token.getToken();
					}
				}else {
					//Si el que esta antes en el stack es de mayor precedencia
					greaterPrecedenceNode(miNode, token);
				}
			}
			
		}catch(NotATokenException e) {
			postfix += ch;
				
		}						 
	}
	emptyStack(vector);
}


public void greaterPrecedenceNode(StackNodes<Token> miNode, Token token) {
	//vector.pull();
	while((miNode.peek().getToken() != '(') || (token.compareTo(miNode.peek()) >= 0)) {
		if (miNode.peek().getToken() != '(') {
			postfix += miNode.pull().getToken();
		}else {
			miNode.pull();
		}
	}
}


public void emptyStackNode(StackNodes<Token> miNode) {
	if(miNode.isEmpty() == false) {
		postfix += miNode.pull().getToken();
	}
}








}
