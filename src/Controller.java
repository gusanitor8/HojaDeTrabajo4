
public class Controller {
//-------------------------------------GUS-------------------------------------
	Vista vista = new Vista();
	String infix; 
	String postfix;
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
			
		}
	}
	
	
//-------------------------------------DIEGUIN-------------------------------------
	
	
//-------------------------------------MANUELIN-------------------------------------

}
