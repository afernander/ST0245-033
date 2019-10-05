/**
 * La clase BinaryTree intenta dar un conocimiento a los
 * estudiantes acerca del manejo de un arbol binario de enteros.  
 * Aquí se espera crear una estrcutura concreta del árbol binario,
 * cabe aclarar que esta estrucutra ya esta implementada.
 * 
 * @author Mauricio Toro, Andres Paez
 *
 */

public class BinaryTree {

    // Sirve como raíz del árbol
    public Node root;

    /**
     * @param n el dato del nodo que se busca buscar
     * Metodo auxiliar de insetarAux.
     *
     */
    public void insertar(int n) {
        insertarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca insertar
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * La complegidad para insertar es de O(log(n))
     */
    private void insertarAux(Node node, int n) {
        
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
    

    /**
     * @param n el dato del nodo que se busca.
     * Metodo auxiliar de buscarAux.
     * @return true si el metodo buscarAux es true
     */
    public boolean buscar(int n) {
        return buscarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca
     * nota: metodo recursivo.
     * Inserta un dato respetando claro las desigualdades en el árbol
     * @return true si se encuentra el elemento en el árbol, false de lo contrario
     */ 

    private boolean buscarAux(Node node, int n) {
        if(node==null)return false;
        if (node.data == n) {
            return true;
        }
        if (node == null) {
            return false;
        }
        if (n > node.data) {
            return buscarAux(node.right, n);
        }
        return buscarAux(node.left, n);
    }

    /**
     * @param n el dato del nodo que se busca borrar.
     * Metodo auxiliar de buscarAux.
     * 
     */
    public void borrar(int n) {
        borrarAux(root, n);
    }

    /**
     * @param node es la raíz del arbol
     * @param n el data del nodo que se busca borrar
     * nota: metodo recursivo.
     * borra un dato respetando claro las desigualdades en el árbol
     */ 
    private void borrarAux(Node node, int n) {
        //..

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

    public static void main(String[]args){
        BinaryTree arbol = new BinaryTree();
        /*arbol.root = new Node(3);
        arbol.root.left= new Node(4);
        arbol.root.right= new Node(5);
        arbol.root.left.left= new Node(6);
        arbol.root.left.right= new Node(7);
        arbol.root.right.left= new Node(8);
        arbol.root.right.right= new Node(9);
         */
        arbol.root=new Node(0);
        arbol.insertar(1);
        arbol.insertar(2);
        arbol.insertar(4);
        arbol.insertar(5);
        arbol.insertar(6);
        arbol.recursivePrint();
        System.out.println(arbol.buscar(3));
        System.out.println(arbol.buscar(2));

    }

}