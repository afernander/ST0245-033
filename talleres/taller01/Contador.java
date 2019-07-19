import java.util.Scanner;

/** Esta clase se logra la cfeacion de un contador e incrementar el mismo y a su vez, lograr un ordenamiento e impresion de los caracteres del contador **/
public class Contador {
    /** Se inicializan las variables globales que serán utilizadas durante la creacion de codigo **/
    private static String id;
    private int cont=0;

    /**Este metodo asigna un valor a la variable global id **/

    public Contador(String id) {
        this.id=id;
    }
/** Aqui se increementa el contador una unidad**/
    public void incrementar() {
        cont++;
    }
//En este lo que se hace es utilizar una cantidad establecida para el incremento del contador **/

    public void incrementar(int cant) {
        cont+= cant;
    }
/** En este metodo se retornan el numero de incrementos que se han realizado surante el codigo **/

    public int incrementos(){
        return cont;
    }
/** En este espacio del codigo se busca ordenar la cadena e imprimir los caracteres del contador **/

    public String toString() {
        String cadena=id + ": " + cont;
        return cadena;
    }

//Se llaman los diferentes metodos y se imprimen para una buena ejecucion y visualizacion **/

    public static void main(String [] args){
        Contador c = new Contador("contador");
        c.incrementar();
         c.incrementar(2);

        System.out.println(c.incrementos());
        System.out.println(c.toString());

    }

}
