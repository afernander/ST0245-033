/*3)Implementen un algoritmo recursivo que, dado un grupo de elementos, le
muestre, en pantalla, todos los posibles subgrupos que se pueden formar
con esos elementos.
* Esta clase es la solucion al punto 3 del taller 2
* Hecho por (Alejandro Fernandez y Tatiana velez)
*/
public class Punto3 {

    //metodo que envia al metodo comboinaciones2 la cadena a combinar y un 
    //string vacio para ser de temporal
    public static void combinaciones(String s){
        combinaciones2("", s);
    }
//metodo para imprimir todas las combinaciones de los caracteres del string 
    private static void combinaciones2(String prefix,String s){
        if(s.length()==0) {
            System.out.println(prefix);
        }
        else{
            combinaciones2(prefix+s.charAt(0),s.substring(1));
            combinaciones2(prefix,s.substring(1));

        }}

        public static void main(String[]args){
        combinaciones("abc");
        }
}



