import java.util.InputMismatchException;
import java.util.Scanner;


public class Vista {
	Scanner input = new Scanner(System.in);
	/**
	 * Metodo de print
	 * @param text texto que se despliega en la consola
	 */
	private void prnt(String text) {
		System.out.println(text);
	}
	
	/**
	 * Devuelve un mensaje de error
	 * @return cadena de texto que es el mensaje de error
	 */
	private String mismatchMessage() {
		return "La opcion que ingreso es invalida. Intente de nuevo.";
	}
	
	/**
	 * Metodo de menu principal
	 * @return regresa entero con la opcion que eligio el usuario
	 */
	public int mainMenu() {
		int opcion = 0;
		
		try {
			prnt("Bienvenido, ingrese la implementacion del conversor que desea: ");
			prnt("1. Stack (Nodos)");
			prnt("2. Lista Encadenada");
			prnt("3. Lista Doblemente Encadenada");
			prnt("4. Vector");
			prnt("5. Salir");
			
			opcion = input.nextInt();
			input.nextLine();
			
			if((opcion > 5) && (opcion < 1)) {
				throw new Exception();
			}
			
		}catch(InputMismatchException e) {
			System.out.println(mismatchMessage());
			input.nextLine();
			opcion = mainMenu();
			
		}catch(Exception e) {
			System.out.println(mismatchMessage());
			opcion = mainMenu();
		}
		
		
		return opcion;
	}
	
	/**
	 * Devuelve la expresion en infix ingresada por el usuario
	 * @return
	 */
	public String infixInput() {
		prnt("Ingrese la expresion en Infix: ");
		String infix = input.nextLine();
		return infix;
	}
	
}
