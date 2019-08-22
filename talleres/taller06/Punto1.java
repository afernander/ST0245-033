import java.util.ArrayList;
/**
 * Write a description of class Punto1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Punto1
{
    // instance variables - replace the example below with your own
    private static int tamanopordefecto=10;
    private static int size;
    private static char[] elementos;

    public Punto1()
    {
        size=0;
        elementos= new  char[tamanopordefecto];
    }


    public  int size(){
        return this.size;
    }

    public static void addF(char e){
        if (size == elementos.length) { 
            char[] nuevo = new char[elementos.length*2]; 
            for (int i = 0; i < elementos.length; i++) {
                nuevo[i] = elementos[i];  
            }
            elementos = nuevo;

        }
        elementos[size]=e;
        size++;
    }

    public static void add(char e,int index){
        if (size == elementos.length) { 
            char[] nuevo = new char[elementos.length*2]; 
            for (int i = 0; i < elementos.length; i++) {
                nuevo[i] = elementos[i];  
            }
            elementos = nuevo;

        }
        char[] nuevo1 = new char[elementos.length];
        nuevo1=elementos;
        for (int i = index+1; i < elementos.length; i++) {
            nuevo1[i] = elementos[i-1];  
        }
        elementos = nuevo1;
        elementos[index]=e;
        size++;
    }

    public static void del(int index){
        char[] nuevo1 = new char[elementos.length];
        nuevo1=elementos;
        for (int i = index; i < elementos.length-1; i++) {
            nuevo1[i] = elementos[i+1];  
        }
        elementos = nuevo1;
        size--;
    }

    public static char get(int i){
        if (i < size && i >= 0)   

            return elementos[i];   
        else
            throw new ArrayIndexOutOfBoundsException(); 
    }

    public static void main (String[] args){
        Punto1 prueba= new Punto1();
        prueba.addF('a');
        prueba.addF('1');
        System.out.println(prueba.size());
        prueba.add('e',1);
        prueba.add('2',1);
        System.out.println(prueba.size());
        prueba.del(0);
        System.out.println(prueba.size());
    }
}
