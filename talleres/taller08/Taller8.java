import java.util.*;



public class Taller8 {

    /**
     * @param queue es una cola ya implementada que se crea en el test
     * Este método se encarga de atender a personas.
     * Nota: Se debe imprimir en consola a quién atiende y sacarlo de la cola
     * existe una función "pull" que hace el trabajo más fácil
     * 
     */
    public static void cola (Queue<String> queue){

        while(queue.peek()!=null){
            System.out.println("Se está atendiendo a " + queue.poll());
        }
    }

    
    

}