
public class Controller {
//-------------------------------------GUS-------------------------------------
	Vista vista = new Vista();
	String infix; 
	String postfix = "";
	StackVector<Token> vector = new StackVector<Token>();
	
	public void run() {
		switch(vista.mainMenu()) {
		case 1:
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
	
	
//-------------------------------------MANUELIN-------------------------------------

}
