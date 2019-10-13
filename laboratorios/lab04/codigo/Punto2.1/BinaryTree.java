
import java.util.Scanner;
public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(double n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * La complegidad para insertar es de O(n)
     */
    private void insertarAux(Node node, double n) {

        if (node.data == n){
            return;
        }else if (n > node.data) {
            if (node.right == null) {
                node.right = new Node(n);
            }else {
                insertarAux(node.right, n);
            }
        }else {
            if (node.left == null) {
                node.left = new Node(n);
            }else {
                insertarAux(node.left, n);
            }
        }
    }


    /*
    Los metodos posteriores son para imprimir el arbol de manera
    que sirven para debuggeo
     */

    /**
     * @param node el nodo desde el cual se imprimirá
     * imprime el arbol desde el nodo node
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            System.out.println(node.data);
        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    public void recursivePrint()
    {
        recursivePrintAUX(root);
    }

    public static double [] Scanner(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingreso de valores para el arbol");
        String temp = teclado.nextLine();
        String  [] valorest= temp.split(" ") ;
        double [] valores= new double[valorest.length];
        for(int i =0;i<valorest.length;i++){
            valores[i]= Integer.parseInt(valorest[i]);
        }
        /*
        for(int a=0;a<valores.length;a++){
        System.out.println(valores[a]);
        }
         */
        return valores;
    }

    public static void main(String[]args){
        BinaryTree arbol = new BinaryTree();
        double [] datos= arbol.Scanner();
        for(int x =0;x<datos.length;x++){
            if(x==0){
                arbol.root=new Node(datos[x]);
            }else{
                arbol.insertar(datos[x]);

            }
        }
        arbol.recursivePrint();
        
    }

}