public class InsertionSort{


    public static int[] crearArray(int n) {

        int[] arreglo = new int[n];

        for (int a = 0; a < arreglo.length; a++) {
            arreglo[a] = (int) (Math.random() * arreglo.length);
        }
        return arreglo;
    }
    public static int[] insertionsort(int [] arreglo){  //O(n^2)
        int n = arreglo.length;
        for(int i=1;i<n;i++){  //n
            int b=arreglo[i];  //C1*n
            int c=i-1;          //c2*n
            while(c>=0&&arreglo[c]>b){  //n*n
                arreglo[c+1]=arreglo[c]; // c3+c4 *(n^2)
                c=c-1;                     //C5*(n^2)
            }
            arreglo[c+1]=b;              //c6*n
        }


        return arreglo;
    }

    public static void printArray(int arreglo[])
    {
        int n = arreglo.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arreglo[i] + " ");

        System.out.println();
    }

    public static void main(String[] args) {


        for (int b = 5000; b <= 100000; b += 5000) {
            long startTime = System.currentTimeMillis();
            insertionsort(crearArray(b));
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(crearArray(b).length+ " " +tiempo);
        }



    }
}


