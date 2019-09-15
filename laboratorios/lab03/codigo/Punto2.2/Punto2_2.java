import java.util.ArrayList;
import java.util.Stack;
import java.util.Scanner;
/** El problema es interpretar una serie de comandos que dan instrucciones a un brazo
robótico sobre como manipular bloques que están sobre una mesa plana. Inicialmente
hay n bloques en la mesa (enumerados de 0 a n-1) con el bloque bi adyacente al bloque
bi+1 para todo entero i con i < n-1.
-Hecho por Alejandro Fernandez - Nayibe Tatiana Velez - Adelaida Maldonado
 */
public class Punto2_2{
    /**vector de pilas */
    public static Stack<Integer>[] bloques;
    /** este metodo crea el vector de pilas (las cajas con sus posciciones y numeros)*/
    public static Stack<Integer>[] crearpila(int n){
        bloques = new Stack[n];
        for(int i=0;i<n;i++){
            bloques[i]=new Stack<Integer>();
            bloques[i].push(i);
        }
        return bloques;
    }

    /** este metodo imprime las cajas y sus respectivas posciciones*/
    public static void impresion(){
        for(int i=0;i<bloques.length;i++)
            System.out.println(i+": "+bloques[i]);
    }

    /** este metodo retorna la poscicion de la caja que se pida*/
    public static int buscar(int x){
        int a=-1;
        for(int i=0;i<bloques.length&&a==-1;i++){
            Stack<Integer> temp= new Stack<Integer>();
            temp=bloques[i];
            a=temp.search(x);
            if(a!=-1){
                return i;
            }
        }
        return a;
    }

    /**donde a y b son números de bloques, pone el bloque a encima
    del bloque b luego de devolver cualquier bloque que estén apilados sobre los bloques a
    y b a sus posiciones iniciales. */
    public static void moveOnto(int a, int b){
        int posa= buscar(a);
        int posb= buscar(b);
        if(posa==posb){
            System.out.println("Los dos elementos estan en la misma fila intente hacer el comando move over");
        }else{
            while(bloques[posa].peek()!=a){
                int t= bloques[posa].pop();
                bloques[t].push(t);
            }
            while(bloques[posb].peek()!=b){
                int t= bloques[posb].pop();
                bloques[t].push(t);
            }
        }

        bloques[posb].push(bloques[posa].pop());
        impresion();
    }

    /** donde a y b son números de bloques, pone el bloque a encima
    de la pila que contiene al bloque b, luego de retornar cualquier bloque que está apilado
    sobre el bloque a a su posición inicial.
     */
    public static void moveOver(int a, int b){
        int posa= buscar(a);
        int posb= buscar(b);
        while(bloques[posa].peek()!=a){
            int t= bloques[posa].pop();
            bloques[t].push(t);
        }
        bloques[posb].push(bloques[posa].pop());
        impresion();
    }

    /** donde a y b son números de bloques, mueve la pila de bloques que
    consiste en el bloque a y todos los bloques apilados sobre este, encima de b. Todos los bloques encima del bloque b son movidos a su posición inicial antes de que se
    dé el apilamiento. Los bloques apilados sobre el bloque a conservan su orden original
    luego de ser movidos. */
    public static void pileOnto(int a , int b){
        int posa= buscar(a);
        int posb= buscar(b);
        while(bloques[posb].peek()!=b){
            int t= bloques[posb].pop();
            bloques[t].push(t);
        }
        Stack<Integer> temp= new Stack<Integer>();
        while(bloques[posb].peek()!=a){
            temp.push(bloques[posa].pop());
        }
        temp.push(bloques[posa].pop());
        while(temp.isEmpty()){
            bloques[posb].push(temp.pop());
        }
        impresion();
    }

    /** donde a y b son números de bloques, pone la pila de bloques que
    consiste en el bloque a y todos los bloques que están apilados sobre este, encima
    de la pila que contiene al bloque b. Los bloques apilados sobre el bloque a
    conservan su orden original luego de ser movidos. */
    public static void pileOver(int a , int b){
        int posa= buscar(a);
        int posb= buscar(b);

        Stack<Integer> temp= new Stack<Integer>();
        while(bloques[posa].peek()!=a){
            temp.push(bloques[posa].pop());
        }
        temp.push(bloques[posa].pop());
        while(!temp.isEmpty()){
            bloques[posb].push(temp.pop());
        }
        impresion();
    }

    /** menu del programa donde el usuario ingresa los comados a ejecutar*/
    public static void comandos(){
        Scanner tecl= new Scanner(System.in);
        String comando;
        boolean estado=true;
        while(estado==true){
            System.out.println("Ingrese un comando");
            comando=tecl.nextLine();
            /** comado dividido para evaluar*/
            String[] texto= comando.split(" ");
            //menu de comandos
            if(texto[0].equals("move")){
                if(texto[2].equals("onto")){
                    moveOnto(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }
                if(texto[2].equals("over")){
                    moveOver(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }
            }
            if(texto[0].equals("pile")){
                if(texto[2].equals("ontto")){
                    pileOnto(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }
                if(texto[2].equals("over")){
                    pileOver(Integer.parseInt(texto[1]),Integer.parseInt(texto[3]));
                }

            }
            if(texto[0].equals("quit")){
                System.out.println("Fin de las Operaciones");
                System.out.println("Resultado final:");
                estado=false;
            }

        }
        impresion();
    }

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el nuemero de cubos que hay");
        /** numero de cubos que va a tener el programa*/
        int n= teclado.nextInt();
        crearpila(n);
        impresion();
        comandos();

    }

}