
import java.lang.IndexOutOfBoundsException;
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Lista
{
    // Usar esto cuando se salga el índice
    // Una lista simplemente enlazada

    private Node first;
    private int size;
    public Lista()
    {
        size = 0;
        first = null;   
    }

    /**
     * Returns the node at the specified position in this list.
     * @param index - index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    private Node getNode(int index) throws IndexOutOfBoundsException {
        if (index >= 0 && index < size) {
            Node temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            throw new IndexOutOfBoundsException();
        }
    }

    /**
     * Returns the element at the specified position in this list.
     * @param index - index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException
     */
    public char get(int index) throws IndexOutOfBoundsException {
        Node temp = getNode(index);
        return temp.data;
    }

    // Retorna el tamaño actual de la lista
    public int size()
    {

        return size;
    }

    // Inserta un dato en la posición index
    public void insert(char data, int index)
    {
        if(index==0){     
            Node insert = new Node(data);
            insert.next = first;
            first = insert;
        } else if(index>=0 && index<=size){
            Node temp = first;
            for(int i=0; i<index-1; i++){
                temp = temp.next; 
            }
            Node insert = new Node(data);
            insert.next = temp.next;
            temp.next = insert;
        }
        size++;
    }
    // Borra el dato en la posición index
    public void remove(int index)
    {
        Node borrar = new Node('a');
        borrar= this.getNode(index);
        if(index==0){
            first=first.next;
        }else{
            Node anterior=this.getNode(index-1);
            anterior.next=borrar.next;
            borrar.next=null;

        }
        size--;
    }

    // Verifica si está un dato en la lista
    public boolean contains(char data)
    {
        for(int i=0;i<size;i++){
            if(get(i)==data){
                return true;
            }
        }
        return false;
    }
    
    public  boolean search(char caract){
        for(int i=0;i<size;i++){
            if(get(i)==caract){
                return true;
            }
        }
        return false;
    }

    public static void main(String[]args){
        Lista lista1= new Lista();
        lista1.insert('a',0);
        lista1.insert('b',1);
        lista1.insert('c',0);
        lista1.insert('t',2);
        System.out.println(lista1.get(0));
        System.out.println(lista1.get(1));
        System.out.println(lista1.get(2));
        System.out.println(lista1.get(3));
        System.out.println(lista1.contains('c'));
        lista1.remove(2);
        System.out.println(lista1.search('a'));
        System.out.println(lista1.search('t'));
    }
}

