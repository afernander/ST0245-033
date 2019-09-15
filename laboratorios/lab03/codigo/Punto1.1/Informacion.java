import java.util.Scanner;
import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public  class Informacion{
    private static LinkedList <Dato> listaST0242;
    private static LinkedList <Dato> listaST0245;
    private static LinkedList <Dato> listaST0247;
    public static  LinkedList guardar(String archivo) throws FileNotFoundException{
        LinkedList <Dato> lista= new LinkedList();
        Scanner leer= new Scanner(new File(archivo));
        PrintStream out=new PrintStream(new File("nuevo.csv"));

        
        while(leer.hasNextLine()){
            String line=leer.nextLine();
            line=line.trim();
            if(line.length()>0){
                out.println(line);
            }

        }
        Scanner ox=new Scanner(new File("nuevo.csv"));
        String temp="o";
        while(ox.hasNextLine()){

            String line=ox.nextLine();
            String[] estudiante= line.split(",");
            for (int i = 0; i < estudiante.length; i++) {
                estudiante[i]=estudiante[i].replaceAll("\"", "");
            }
            String[] info= new String[11];
            if(estudiante[0].equals("nombre")){
            }else{
                info[0]=estudiante[0];
                info[1]=estudiante[1];
                info[2]=estudiante[2];
                info[3]=estudiante[3];
                info[4]=estudiante[4];
                info[5]=estudiante[7];
                info[6]=estudiante[8];
                info[7]=estudiante[9];
                info[8]=estudiante[10];
                info[9]=estudiante[12];
                info[10]=estudiante[13];

                //System.out.println(info[0]+" "+info[1]+" "+info[2]+" "+info[3]+" "+info[4]+" "+info[5]+" "+info[6]+" "+info[7]+" "+info[8]+" "+info[9]+" "+info[10]);

                Dato materia= new Dato(info[0],info[1],info[2],info[3],info[4],info[5],info[6],info[7],info[8],info[9],info[10]);
                lista.add(materia);

            }
        }
        return lista;
    }

    public static int menu(){
        System.out.println("Bienvenido a la base de datos de los estudiantes de la universidad");
        System.out.println("Ingrese el numero de la opcion que desea realizar");
        System.out.println("1. Buscar todos los estudiantes de un curso");
        System.out.println("2. Buscar las materias cursadas y su nota definitiva de un estudiante");
        Scanner tecl = new Scanner(System.in);
        int opc= tecl.nextInt();
        if(opc>2||opc<1){
            System.out.println("Ingreso una opcion invalida ,intente nuevamente");
            return menu();
        }
        return opc;
    }

    public static String nombreE(){
        System.out.println("Ingrese el nombre del estudiante");
        Scanner tecl = new Scanner(System.in);
        return tecl.nextLine();
    }

    public static String semestre(){
        System.out.println("Ingrese el semestre del cual desea saber la informacion");
        Scanner tecl = new Scanner(System.in);
        return tecl.nextLine();
    }

    public static String curso(){
        System.out.println("Ingrese el curso del cual desea saber la informacion");
        Scanner tecl = new Scanner(System.in);
        return tecl.nextLine();
    }

    public static void consulta1(String curso, String semestre,LinkedList <Dato> lista){
        String temp="o";
        
        for(int i=1;i<lista.size();i++){
            
            if(lista.get(i).getnombreM().equals(curso)&&lista.get(i).getsemestre().equals(semestre)){
                
                if(!(lista.get(i).getnombre().equals(temp)))
                    System.out.println(lista.get(i).getnombre()+"\t \t \t \t"+lista.get(i).getnotadef());
                    temp=lista.get(i).getnombre();
            }
        }
    }
    
    public static void consulta2(String nombreE, String semestre,LinkedList <Dato> lista){
        String temp="o";
        
        for(int i=1;i<lista.size();i++){
            
            if(lista.get(i).getnombre().equals(nombreE)&&lista.get(i).getsemestre().equals(semestre)){
                
                if(!(lista.get(i).getnombreM().equals(temp)))
                    System.out.print("   "+lista.get(i).getnombreM()+" = "+lista.get(i).getnotadef());
                    temp=lista.get(i).getnombreM();
            }
        }
    }


    public static void main(String[]args)throws FileNotFoundException{
        int opcion=menu();
        Informacion info= new Informacion();
        listaST0242=guardar("NOTAS ST0242.csv");

        listaST0245=guardar("NOTAS ST0245.csv");

        listaST0247=guardar("NOTAS ST0247.csv");
        if(opcion==1){
            String curso=curso();
            String semestre=semestre();
            System.out.println(curso+"    Nota Definitiva");
            consulta1(curso,semestre,listaST0242);
            consulta1(curso,semestre,listaST0245);
            consulta1(curso,semestre,listaST0247);
        }
        if(opcion==2){
            String nombreE=nombreE();
            String semestre=semestre();
            System.out.println(nombreE);
            consulta2(nombreE,semestre,listaST0242);
            consulta2(nombreE,semestre,listaST0245);
            consulta2(nombreE,semestre,listaST0247);
        }
    }

}