public class Tiempo {

    public static int nRectangulos(int n) {
        if (n < 3) {
            return n;
        } else {
            return nRectangulos(n - 1) + nRectangulos(n - 2);
        }
    }


    public static void main(String[] args) {
        for (int b = 31; b < 51; b++) {
            long startTime = System.currentTimeMillis();
            nRectangulos(b);
            long tiempo = System.currentTimeMillis() - startTime;
            System.out.println( b + " "+tiempo);
        }
    }
}

