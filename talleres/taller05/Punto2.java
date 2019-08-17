public class Punto2 {
    public static void main (String []args){
        for(int b=5000000; b<=100000000;b+=5000000) {
            long startTime = System.currentTimeMillis();
            suma(creararreglo(b));
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(tiempo);
        }
    }

    public static int suma(int [] arreglo){  //O(n)
        int suma=0;
        for(int i=0;i<arreglo.length;i++){  // n
            suma+=arreglo[i];               //C1+C2*(n)

        }
        return suma;

    }

    public static int[] creararreglo(int n) {
        int arreglo[]=new int[n];
        for(int a=0; a<arreglo.length;a++) {
            arreglo[a]=a*n;
        }
        return arreglo;
    }
}
