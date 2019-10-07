
import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;

public  class LecturaDeDatos{
    private  ArrayList <Dato> lista;
    public static  double[][] guardar(String archivo) throws FileNotFoundException{
        ArrayList <Dato> lista= new ArrayList();
        Scanner leer= new Scanner(new File(archivo));
        int size =0;

        double [][]datos= new double[7][300];
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
                if(planta[6]=="yes"){
                    datos[6][cont]=1;
                }else{
                    datos[6][cont]=0;
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

    public static float impureza(int variable,double valor, double[][] datos){
        double d=0;
        double impureza=0;

        int contd=0;
        int conti=0;
        for(int x=0;x<datos[variable].length;x++){
            d=datos[variable][x];
            for(int i=0;i<datos[variable].length;i++){
                if(d>datos[variable][i]){
                    contd++;
                }else{
                    conti++;
                }
            }
            double [][] izquierda= new double[7][conti];
            double [][] derecha=new double [7][contd];
            int temp1=0;
            int temp2=0;
            for(int i=0;i<datos[variable].length;i++){
                if(d>datos[variable][i]){
                    derecha[variable][temp1]=datos[variable][i];
                    temp1++;
                }else{
                    izquierda[variable][temp2]=datos[variable][i];
                    temp2++;
                }
            }
        }
        return 0;
    }

    public static Node crearArbol(int[] valores ){
        Node arbol;

        return null ;
    }

    public static void main(String[]args)throws FileNotFoundException{
        /*
        for (int i = 1; i < 100; i++) {
            long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long startTime = System.currentTimeMillis();
            LecturaDeDatos datos = new LecturaDeDatos();
            datos.guardar("data_set_test.csv");
            int impurezaph=0;
            long tiempo = System.currentTimeMillis() - startTime;
            long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
            long actualMemUsed=afterUsedMem-beforeUsedMem;
            //System.out.println(tiempo);
            System.out.println(actualMemUsed);

        }
        */
       
        LecturaDeDatos datos = new LecturaDeDatos();
            datos.guardar("data_set_test.csv");
            int impurezaph=0;
    }
}