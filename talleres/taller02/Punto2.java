/*2)Implementen un algoritmo recursivo que, dados los
*pesos de un grupo de elementos, determine si existe o no 
 *Esta clase es la solucion al punto 2 del taller 2
* Hecho por (Alejandro Fernandez y Tatiana velez)
*/
public class Punto2 {
    //arreglo con los pesos de los elementos
    public static int[] grupo1 = new int[4];

    public static void main(String[] args) {
        grupo1[0] = 2;
        grupo1[1] = 4;
        grupo1[2] = 6;
        grupo1[3] = 10;
        System.out.println(PesoMaximo(0, grupo1, 12));

    }

    //metodo que evalua si puede aver una combinacion de elementos que esten dentro del peso maximo
    public static boolean PesoMaximo(int contador, int[] grupo1, int pesoM) {
        if (contador >= grupo1.length) {
            return pesoM == 0;
        }
        if (PesoMaximo(contador + 1, grupo1, pesoM - grupo1[contador])) {
            return true;
        }
        if (PesoMaximo(contador + 1, grupo1, pesoM)) return true;
        return false;
    }




        }
