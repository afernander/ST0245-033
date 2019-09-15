import java.util.LinkedList;
import java.util.Scanner;
import java.io.*;
/**esta clase tiene como finalidad, encontrar unos caracteres y utilizra una secuencia lógica para su organización
   @Alejandro Fernandez, Tatiana Vélez, Adelaida Maldonado*/

public class Punto2_1
{

    public static void entrada(){
        LinkedList<Character> lista = new LinkedList<Character>();
        Scanner entrada=new Scanner(System.in);

        String s;
        System.out.println("Ingrese texto");
        s=entrada.nextLine();
        int contini=0;
       
        int len= s.length();
        for (int i = 0; i < s.length(); i++){
           
            if (s.charAt(i) == '['){
                int j=i;
                contini=0;
                while(s.charAt(j)!=']' && j<s.length()-1){
                    //System.out.println(contini);
                    lista.add(contini, s.charAt(j));
                    j++;
                    if(s.charAt(j)=='['){
                        contini=0;
                    }else{
                        contini++;
                    }
                   
                }
               
                 
               
                 i=j;
               
            }
            else if (s.charAt(i) == ']'){
                int j=i;
                while(s.charAt(j)!='[' && j<s.length()-1  ){
                    lista.addLast(s.charAt(j));
                    j++;
                   
                }
                lista.addLast(s.charAt(j));
                i=j;
               
            }
            else{
                lista.add(s.charAt(i));
            }

        }
       
        for(int i=lista.size()-1; i>=0; i--){
            if(lista.get(i)=='[' || lista.get(i)==']'){
                lista.remove(i);
            }
        }
        System.out.println(lista);
       
    }

   
}