public class Punto2 {



        //metodo que evalua si puede aver una combinacion de elementos que esten dentro del peso maximo
        public static boolean PesoMaximo(int contador, int[] grupo1, int pesoM) {
            if (contador >= grupo1.length) {
                return pesoM == 0;
            }
            if (PesoMaximo(contador + 1, grupo1, pesoM - grupo1[contador])) {
                return true;
            }
            if (PesoMaximo(contador + 1, grupo1, pesoM)) return true;
            return false;
        }

        public static int[] creararreglo(int n){
            int [] arreglo= new int [n];

            for(int a=0;a<arreglo.length;a++){
                arreglo[a]=n/(a+1);
            }
            return arreglo;
        }


        public static void main(String []args) {
            for(int b=15;b<=35;b++){
                long startTime = System.currentTimeMillis();
                PesoMaximo(0,creararreglo(b),b);
                long tiempo = System.currentTimeMillis() - startTime;
                System.out.println(tiempo);
            }
        }
    }


