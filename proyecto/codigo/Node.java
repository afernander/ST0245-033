


/**
 * Esta clase contiene la creacion del arbol y la estructura de los nodos
 */
public class Node {
    public Node left;
    public Node right;
    public double data;
    public double total;
    public double roya;
    
    int variable;
    double valor;
    double[][] datos;
    
    

    /**
     * contructor de Node
     */
    public Node(double d,double roya,double total){
        
       data = d;
       this.total=total;
       this.roya = roya;
    }

    public Node getLeft(){
        return this.left;
    }
    public Node getRigth(){
        return this.right;
    }
    public double getData(){
        return this.data;
    }
   }