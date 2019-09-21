 

import java.util.*;

public class TestTaller8 {
	
 
    
    
    public static void ejercicio4(){
    	Queue<String> cola1;
    	String[] a = {"Juan","Maria","Pedro","Mariana"};
    	cola1=toQueue(a);
    	Taller8.cola(cola1);
    }
    
    public static Queue<String> toQueue(String[]array){
        Queue<String> a=new LinkedList<String>();
        for(int i=0;i<array.length;i++){
            a.add(array[i]);
        }
        return a;
    }
    
    
    
    public static void main(String[] args){
    	
        
        ejercicio4();
        
        
    }
}