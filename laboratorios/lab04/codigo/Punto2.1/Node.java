public class Node {
    public Node left;
    public Node right;
    public double data;
    public Node(double d){
        
       data = d;
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
