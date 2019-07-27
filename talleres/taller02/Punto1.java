/*1)Implementen el algoritmo de Euclides de forma recursiva.
 *Esta clase es la solucion al punto 2 del taller 2
* Hecho por (Alejandro Fernandez y Tatiana velez)
*/
public class Punto1{
    //variable sque contiene las dimensines de la habitacion 
    public static int mayor,menor;

    // metodo que evalua cual es el tamaño de las balsodas para encajar en la habitacion de manera exacta
    public static int baldosa(int mayor,int menor){
        if (menor == 0) {
            return mayor;
        }
        else if(menor>0) {
            return baldosa(menor, mayor%menor);
        }
        return 0;            }

        public static void main(String []args) {

        System.out.println(baldosa(345,150));
        }

        }

