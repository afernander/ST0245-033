public class Punto_1 {

    public static int arr(int[] nums) {
        return sum(nums, nums.length);
    }

    public static int sum(int nums[], int n) {

        if (n == 0) {
            return 0;
        } else {
            return nums[n - 1] + sum(nums, n - 1);
        }


    }
    public static int[] crearArray2(){

        int n = (int) (Math.random()*4000)+2500;

        int[] numeros = new int [n];

        for (int i=0; i<numeros.length; i++){

            numeros[i] = (int) (Math.random()*4000);
        }

        return numeros;
    }



    public static void main(String[] args) {

        System.out.println("Tiempo Ejercicio 1\n");
        for (int i = 1; i < 20; i++) {

            long startTime = System.currentTimeMillis();
            arr(crearArray2());
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println(crearArray2().length+ " " +tiempo);
        }

    }
}
