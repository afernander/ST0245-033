/** Esta clase tiene como funcionalidad la comparacion de fechas y su ordenamiento para su visualizacion **/
import java.util.Scanner;
import java.util.Date;

public class Fecha {

//* Se inicializan las variables globales **/
    private int dia,mes,aho;

    /** Se crea la cadena para organizar su impresion y lograr una mejor visualizacion **/

    public static String toString(int dia , int mes , int aho){
        String cadena = dia+"/"+mes+"/"+aho;
        return cadena;
    }
    /** En este metodo se pide el dia y se establece limitaciones de ingreso **/

    public static int Obtenerdia(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el dia ");
        int dia=teclado.nextInt();
        if (dia<32&&dia>0){
            return dia;

        }else{
            Obtenerdia();
        }
        return 0;
    }
    /** En este metodo se pide el mes y se establece limitaciones de ingreso **/
    public static int Obtenermes(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el mes ");
        int mes=teclado.nextInt();
        if (mes<13&&mes>0){
            return mes;

        }else{
            Obtenermes();
        }
        return 0;
    }
    /** En este metodo se pide el dia  **/
    public static int Obteneraho(){
        Scanner teclado = new Scanner(System.in);
        System.out.println("Ingrese el año ");
        int aho=teclado.nextInt();
        if (aho>0){
            return aho;

        }else{
            Obteneraho();
        }
        return 0;
    }

    /** A partir de la importacion de la libreria Date, se logra utilizar el metodo compare to, con lo que se logra obtener los valores indicados, los cuales son:
     * 1: si la fecha es menor que la otra retorna -1.
     *     * 2: si la fecha es igual que la otra retorna 0.
     *     * 3: si la fecha es mayor que la otra retorna 1.
    **/

    public static int comparar(Date fecha1, Date fecha2){
        return  fecha1.compareTo(fecha2);

}


/** En este metodo se llaman los diferentes metodos para su ejecucion y alli mismo se imprime el resultado ordenado y adecuado **/

    public static void main(String []args){
        System.out.println("Ingrese la primera fecha");
        Date fecha1 = new Date( Obtenerdia(),Obtenermes(),Obteneraho());
        System.out.println("Ingrese la segunda fecha");
        Date fecha2 = new Date( Obtenerdia(),Obtenermes(),Obteneraho());
System.out.println(comparar(fecha1,fecha2));
    }

}
