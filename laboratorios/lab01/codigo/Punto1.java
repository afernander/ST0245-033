public class Punto1 {
    public static int nRectangulos(int n) {
        if (n < 3) {
            return n;
        } else {
            return nRectangulos(n - 1) + nRectangulos(n - 2);
        }
    }


    public static void main(String[] args) {
        int pruebas[] = {4, 5, 7, 3, 2, 8, 9};
        for (int i = 0; i < pruebas.length; i++) {
            System.out.println(nRectangulos(i));
        }
    }
}