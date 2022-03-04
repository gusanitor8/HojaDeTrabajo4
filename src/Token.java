public class Token implements Comparable<Token>{
    char token;
    int priority;
    char[] pri3 = new char[]{'^'};
    char[] pri2 = new char[]{'*','/'};
    char[] pri1 = new char[]{'+','-'};

    /**
     * Metodo constructor 
     * @param ch caracter operador
     * @throws Exception en caso de que se le pase un caracter que no sea un operador este tira una excepcion
     */
    public Token(char ch) throws Exception{
        if(isToken(ch)){
            token = ch;
            setPriority(token);
        }else{
            throw new Exception();            
        }

    }

    /**
     * Metodo que verifica si el caracter existe en el array de caracteres
     * @param array array de caracteres
     * @param object caracter a verificas si esta dentro de array
     * @return devuelve verdadero o falso dependiendo si el elemento esta o no en el array
     */
    private boolean contains(char[] array, char object){
        boolean found = false;

        for(char x : array){
            if(x == object){
                found = true;
                break;
            }
        }

        return found;
    }

    /**
     * Se asigna la prioridad del token segun su tipo
     * @param token caracter que define el token
     */
    private void setPriority(char token){
        
        if(contains(pri1,token)){
            priority = 1;
        }else if(contains(pri2,token)){
            priority = 2;
        }else if(contains(pri3,token)){
            priority = 3;
        }
    }

    /**
     * Getter del atributo priority
     * @return devuelve el atributo priority
     */
    private int getPriority(){
        return priority;
    }

    /**
     * Getter del atributo token
     * @return devuelve el atributo token de tipo caracter
     */
    public char getToken(){
        return token;
    }

    /**
     * Veriifica si el parametro es un operador o no
     * @param c caracter a verificar si es operador
     * @return devuelve verdadero si el parametro es un operador
     */
    public boolean isToken(char c){
        boolean isToken = false;        
        char[] posibleTokens = new char[] {'+','-','*','/','^'};
        

        for (char d : posibleTokens) {
            if(d == c){
                isToken = true;
            }
        }

        return isToken;
    }

    @Override
    public int compareTo(Token o){
        int number = 0;
        if(o.getPriority() > this.getPriority()){
            number = -1;
        }else if (o.getPriority() == this.getPriority()) {
            number = 0;
        }else if(o.getPriority() < this.getPriority()){
            number = 1;
        }
        return number;
    }
}