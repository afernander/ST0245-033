import java.util.Scanner;

/* Esta clase tiene como finalidad, ejemplificar el funcionamiento de las torres de Hanoi a traves de un algoritmo recursivo */

public class Punto1 {

    /*Este metodo tiene como funcionalidad recibir como parametros las variable necesarias para realizar los diferentes movimientos, contando
    con un contador que será el encargado de llevar la precisión de los pasos; ademas se lleva a cabo la impresion de los diferentes pasos que se
    deben realizar para completar el funcionamiento correcto de la torre de Hanoi
     */
    public static void Hanoi1(int c,int n, int origen, int auxiliar,int destino){
        if(n==1){
            System.out.println("Mover disco de "+origen+ " a "+destino);

        }
        else{
            Hanoi1(c++, n-1,origen,destino,auxiliar);
            System.out.println("Mover disco de "+origen+ " a "+destino);
            Hanoi1(c+2, n-1,origen,destino,auxiliar);
        }

    }

    /*En este metodo hacemos el llamado al metodo pricipal mandando como parametro las instrucciones para la realización del algoritmo; ademas de
    pedir al usuario los discos con los que desea realizar el algoritmo
     */
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        int n;
        int c=0;
        System.out.println("Numero de discos: ");
        n=sc.nextInt();
        Hanoi1(c,n, 1,2,3);
        sc.close();

    }
}
