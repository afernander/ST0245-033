import java.util.Scanner;
import java.util.LinkedList;
import java.util.ArrayList;
import java.io.*;
/**
 * Esta clase contiene los metodos paraa sacar la impureza y recorrer el arbol, tambien da los resultados finales del algoritmo
 */
public  class Operaciones{
    private  ArrayList <Dato> lista;
    
    /** Este metodo encuentra la menor impureza de una matriz con datos
     * @param impureza es el valor final de la impureza del valor actual 
     * @param valores es una matriz que contiene los datos finales de la impureza de cada valor 
     * 
     */
    public static double[][] impureza( double[][] datos){

        double [][] valores= new double[6][3];
        for(int variable=0;variable<6;variable++){
            double d=0;
            double impureza=100000000;
            double datoimpureza=0.0;
            for(int x=0;x<datos[variable].length;x++){
                double total=0;
                int contd=0;
                int conti=0;
                d=datos[variable][x];
                for(int i=0;i<datos[variable].length;i++){
                    if(d>=datos[variable][i]){
                        contd++;
                    }else{
                        conti++;
                    }
                    total++;
                }
                double [][] izquierda= new double[7][conti];
                double [][] derecha=new double [7][contd];
                int temp1=0;
                int temp2=0;
                for(int i=0;i<datos[variable].length;i++){
                    if(d>=datos[variable][i]){
                        derecha[variable][temp1]=datos[variable][i];
                        derecha[6][temp1]=datos[6][i];
                        temp1++;
                    }else{
                        izquierda[variable][temp2]=datos[variable][i];
                        izquierda[6][temp2]=datos[6][i];
                        temp2++;
                    }
                }
                /*
                for(int a=0;a<izquierda[0].length;a++){
                for(int b=0;b<izquierda.length;b++){
                System.out.print(" "+izquierda[b][a]);
                }
                System.out.println();
                }
                 */
                double cont1=0;
                double cont1t=0;
                for(int i=0;i<derecha[variable].length;i++){
                    if(derecha[6][i]==1.0){
                        cont1++;
                    }
                    cont1t++;
                }

                double cont2=0;
                double cont2t=0;
                for(int i=0;i<izquierda[variable].length;i++){
                    if(izquierda[6][i]==1.0){
                        cont2++;
                    }
                    cont2t++;
                }
                //System.out.println(conti+contd);
                //System.out.println(total);
                double giniizquierda =1-((cont1/cont1t)*(cont1/cont1t))+(((cont1t-cont1)/cont1t)*(cont1t-cont1)/cont1t);
                double giniderecha =1-((cont2/cont2t)*(cont2/cont2t))+(((cont2t-cont2)/cont2t)*(cont2t-cont2)/cont2t);
                double gini =((giniderecha*cont1t)+(giniizquierda*cont2t))/(cont1t+cont2t);
                //System.out.println(gini);
                if(gini<=impureza){
                    impureza =gini;
                    datoimpureza=d;
                }
            }
            valores[variable][0]=variable;
            valores[variable][1]=datoimpureza;
            valores[variable][2]=impureza;
        }

        for(int x=0;x<valores.length-1;x++){
            for(int y=0;y<valores.length-1;y++){
                if(valores[y][2]>valores[y+1][2]){

                    double tempv=valores[y][1];
                    double tempi=valores[y][2];
                    double tempb=valores[y][0];

                    valores[y][0]=valores[y+1][0];
                    valores[y][1]=valores[y+1][1];
                    valores[y][2]=valores[y+1][2];
                    valores[y+1][0]=tempb;
                    valores[y+1][1]=tempv;
                    valores[y+1][2]=tempi;
                }
            }
        }
        /*
        for(int x=0;x<valores[1].length;x++){
        for(int y=0;y<valores.length;y++){
        System.out.print(" "+valores[y][x]);
        }
        System.out.println();
        }
         */
        return valores;
    }

    public static void crearArbol(Node nodo, double valor,int nivel){

        if (nodo!= null&&nivel==1){
            nodo.left= new Node(valor,0,0);
            nodo.right= new Node(valor,0,0);
        }else{
            crearArbol(nodo.left,valor,nivel-1);
            crearArbol(nodo.right,valor,nivel-1);
        }

    }

    /**
     * este metodo agrega las hojas del arbol dependiendo donde terminen las ramas
     */
    public static void agregarHojas(double [][] datostrain, double[][] valoresarbol , Node raiz){
        for (int i=0; i< datostrain[0].length;i++){
            Node nodo = raiz;
            double contr=0;
            double contl=0;
            double contt=0;
            for(int x=0;x<valoresarbol.length;x++){
                while(nodo!=null){
                    if(nodo.left ==null && nodo.right==null){
                        nodo.total++;
                        if(datostrain[6][i]==1){
                            nodo.roya++;
                        }
                        //System.out.println(nodo.roya +" / "+ nodo.total);
                    }

                    if(datostrain[(int)valoresarbol[x][0]][i]<nodo.data){
                        nodo= nodo.left;

                    }else{
                        nodo= nodo.right;

                    }

                }
            }

        }

    }
    /**
     * impresion del arbol
     */
    private void recursivePrintAUX(Node node)
    {
        if (node != null)
        {
            recursivePrintAUX(node.left);
            recursivePrintAUX(node.right);
            //if(node.left==null&&node.right==null)System.out.println(node.roya+" / "+node.total);
            System.out.println(node.data);
        }

    }

    /**
     * Metodo auxiliar de recursivePrintAUX
     *
     */
    public void recursivePrint(Node raiz)
    {
        recursivePrintAUX(raiz);
    }

    /**
     * evaluacion de los datos finales con el arbol ya creado
     */
    public static boolean[][] evaluacion(double [][] datostest, double[][] valoresarbol , Node raiz){
        boolean[][] resultados=new boolean[1][datostest.length];
        for (int i=0; i< datostest[0].length;i++){
            Node nodo = raiz;
            double contr=0;
            double contl=0;
            double contt=0;
            for(int x=0;x<valoresarbol.length;x++){
                while(nodo.left!=null&& nodo.right!=null){

                    if(datostest[(int)valoresarbol[x][0]][i]<nodo.data){
                        nodo= nodo.left;
                        contl++;
                    }else{
                        nodo= nodo.right;
                        contr++;
                    }
                    contt++;
                }
            }
            double porcentaje =0;
            if(nodo.total!=0){
                porcentaje = nodo.roya / nodo.total;
                datostest[7][i]=porcentaje*100;
            }else{
                datostest[7][i]=0;
            }
            if(porcentaje !=0){
                datostest[8][i]=1;
            }
        }

        for(int x=0;x<datostest[1].length;x++){
            for(int y=0;y<datostest.length;y++){
                System.out.print(" "+datostest[y][x]);
            }
            System.out.println();
        }

        return resultados;
    }

    public static void main(String[]args)throws FileNotFoundException{
        /*
        // tiempo de ejecusion y espacio de memoria en lectura de datos.
        long beforeUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        long startTime = System.currentTimeMillis();
        long tiempo = System.currentTimeMillis() - startTime;
        //long afterUsedMem=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
        // long actualMemUsed=afterUsedMem-beforeUsedMem;
        System.out.println(tiempo);
         */


        Operaciones datos = new Operaciones();
        LecturaDeDatos lectura = new LecturaDeDatos();
        //datos.guardar("data_set_test.csv");
        double [][]matrizdatos=lectura.lectura("data_set_train.csv",372);
        //double [][]matrizdatos=datos.guardar("data_set_test.csv",300);
        double[][] valoresarbol= new double[6][3];


        valoresarbol=datos.impureza(matrizdatos);

        Node raiz = new Node(valoresarbol[0][1],0,0);
        for(int y=1;y<valoresarbol.length;y++){
            datos.crearArbol(raiz,valoresarbol[y][1],y);
        }
        datos.recursivePrint(raiz); //impresin del arbol
        datos.agregarHojas(matrizdatos , valoresarbol , raiz);
        //datos.recursivePrint(raiz);

        //System.out.println(actualMemUsed);
        /*
        for(int x=0;x<valoresarbol.length;x++){
        System.out.println("El valor del dato "+valoresarbol[x][0]+" es "+valoresarbol[x][1]);
        }
         */
        double [][]matriztest=lectura.lectura("data_set_test.csv",300);
        //double [][]matriztest=datos.guardar("data_set_train.csv",372);
        double [][]matrizevaluar = new double[9][matriztest[1].length];
        for(int x=0;x<matriztest[1].length;x++){
            for(int y=0;y<matriztest.length;y++){
                matrizevaluar[y][x]=matriztest[y][x];
            }
        }

        boolean[][] resultados=datos.evaluacion(matrizevaluar, valoresarbol , raiz);

        
    }

}