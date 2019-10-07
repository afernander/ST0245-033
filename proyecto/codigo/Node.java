
import java.util.ArrayList;
public class Node {
    public Node left;
    public Node right;
    public Dato valor;
     public Node(Dato d){
       valor= d;
    }

    public Node getLeft(){
        return this.left;
    }
    public Node getRigth(){
        return this.right;
    }
    public Dato getValor(){
        return this.valor;
    }
   }
