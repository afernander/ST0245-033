
/*Esta clase tiene la finalidad de desencriptar un archivo dado a través de una permutación*/

public class Punto2 {

/*Este metodo cumple la funcion de ser un metodo auxiliar para la realización del proceso, el cual contiene la cadena con la que se va a trabajar*/
    public static void combinacion(String cadena) {

        combinationsAux("", cadena);
    }

    /*Este metodo es el encargado de conseguir las posibles permutaciones que se podrán conseguir basandose en la cadena dada*/
    public static void combinationsAux(String prefix, String cadena) {
        if (cadena.length()!=0) {
            System.out.println(prefix+cadena.charAt(0));
            combinationsAux(prefix+ cadena.charAt(0), cadena.substring(1));
            combinationsAux( prefix , cadena.substring(1));
        }
    }

    /*Contiene la cadena a permutar, funcionando este metodo como un  auxiliar*/
    public static void permutacion(String str) {
        permutacionAux("", str);
    }

    /*Con este metodo se busca conseguir las posibles permutaciones de la cadena, actua como metodo principal, ya que es el encargado del proceso*/
    private static void permutacionAux(String prefix, String str) {
        int n = str.length();
        if (n==0) {
            System.out.println(prefix);
            System.out.println(AdvancedEncryptionStandard.desencriptarArchivo(prefix));
        }
        else {
            for (int i = 0; i< n; i++)
                permutacionAux( prefix+str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
        }
    }

/*En este metodo lo que se logra es hacer el llamado al metodo otorgandole la cadena establecida en el metodo combinaciones*/
    public static void main(String[]args){
        String cadena="abcd" ;
        permutacion(cadena);
    }
}
