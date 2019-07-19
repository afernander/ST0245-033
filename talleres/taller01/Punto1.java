/** Esta clase tiene como objetivo la creacion de puntos con coordenadas dadas, para así proceder a obtener el radio y el angulo desde el origen.
Adicionalmente se hallara la distancia que hay entre los dos puntos creados anteriormente.
 **/
public class Punto1 {

    /** Inicialización de variables globales **/
    private double x,y;

 /** Con este metodo se logra darle valor a las variables globales **/
    public Punto1(double x,double y){
        this.x = x;
        this.y =y;
        System.out.println(x);
        System.out.println(y);

    }
 /** En este metodo se utilizan formulas matematicas para hallar el radio con coordenas polares**/

    public static double Cpolar(double x , double y){
        double cord = Math.sqrt(x*x+y*y);
        System.out.println("Radio: "+cord);
        return cord ;
    }
    /** En este metodo se utilizan formulas matematicas para hallar el angulo con coordenas polares**/

    public static double Angulo(double x , double y){
        double angulop = Math.atan2(y,x);
        System.out.println("Angulo: "+angulop);
        return angulop ;
    }
    /** Se realizan la creacion de los gets para modificar los valores de la variable **/
    public double getX(){
        return this.x;
    }

    public double getY(){
        return this.y;
    }
/** Con este metodo, se logra medir la distancia euclidea entre los dos puntos creados anteriormete **/
    public static double distancia(double x, double y, double x1, double y1){
        double distancia = Math.sqrt(Math.pow(x1-x,2)+Math.pow(y1-y,2));
        System.out.println("Distancia :"+distancia);
        return distancia;
    }
/** A partir del main se logra la ejecucion de todos los metodos a partir del llamado de los mismos**/
    public static void main(String args[]){

        Punto1 puntouno = new Punto1(12,23);
        Punto1 puntodos = new Punto1(8,11);
        Cpolar(puntouno.getX(),puntouno.getY());
        Angulo(puntouno.getX(),puntouno.getY());
        distancia(puntouno.getX(),puntouno.getY(),puntodos.getX(),puntodos.getY());

    }


}
