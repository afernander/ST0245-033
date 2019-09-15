import java.io.*;
import java.util.Scanner;

public class Dato{

    private String nombre;
    private String codigo;
    private String codmateria;
    private String semestre;
    private String grupo;
    private String descripcionE;
    private String porcentaje;
    private String descripcion;
    private String nombreM;
    private String nota;
    private String notadef;

    public  Dato( String nombre, String codigo, String codmateria,String semestre,String grupo,String descripcionE,String porcentaje,String descripcion,String nombreM ,String nota,String notadef){
        this.nombre=nombre;
        this.codigo=codigo;
        this.codmateria=codmateria;
        this.semestre=semestre;
        this.grupo=grupo;
        this.descripcionE=descripcionE;
        this.porcentaje=porcentaje;
        this.descripcion=descripcion;
        this.nombreM=nombreM;
        this.nota=nota;
        this.notadef=notadef;
    }

    public String getnombre(){
        return nombre;
    }

    public String getcodigo(){
        return codigo;
    }

    public String getcodmateria(){
        return codmateria;
    }

    public String getsemestre(){
        return semestre;
    }

    public String getgrupo(){
        return grupo;
    }

    public String getdescripcionE(){
        return descripcionE;
    }

    public String getporcentaje(){
        return porcentaje;
    }

    public String getdescripcion(){
        return descripcion;
    }

    public String getnombreM(){
        return nombreM;
    }
    
    public String getnota(){
        return nota;
    }

    public String getnotadef(){
        return notadef;
    }
}