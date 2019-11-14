import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Esta clase contiene los metodos que crean el archivo y le agregan informacion a este mismo.
 * 
 * @author Alejandro Fernandez Restrepo
 * @version mayo de 2019
 */
public class LecturaDeDatos
{
    /**
     * lectura de datos , lee los datos del archivo y los guarda en una matriz
     */
    public static  double[][] lectura(String archivo,int tamanoa) throws FileNotFoundException{
        ArrayList <Dato> lista= new ArrayList();
        Scanner leer= new Scanner(new File(archivo));
        int size =0;

        double [][]datos= new double[7][tamanoa];
        int cont=0;
        while(leer.hasNextLine()){

            String line=leer.nextLine();
            String[] planta= line.split(",");

            String[] info= new String[7];
            if(planta[0].equals("ph")){
            }else{
                datos[0][cont]=Double.parseDouble(planta[0]);
                datos[1][cont]=Double.parseDouble(planta[1]);
                datos[2][cont]=Double.parseDouble(planta[2]);
                datos[3][cont]=Double.parseDouble(planta[3]);
                datos[4][cont]=Double.parseDouble(planta[4]);
                datos[5][cont]=Double.parseDouble(planta[5]);
                if(planta[6].equals("no")){
                    datos[6][cont]=0;
                }else{
                    datos[6][cont]=1;
                }
                cont++;
            }
        }
        /*
        for(int x=0;x<datos[1].length;x++){
        for(int y=0;y<datos.length;y++){
        System.out.print(" "+datos[y][x]);
        }
        System.out.println();
        }
         */
        return datos;
    } 
}

