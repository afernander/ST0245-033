public class Array2 {


    public int countEvens(int[] nums) {

        int cont = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] % 2 == 0)
                cont++;
        }

        return cont;
    }

    public int sum13(int[] nums) {

        int a = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 13 && i < nums.length - 1) {

                nums[i + 1] = 0;
            }

            if (nums[i] != 13) {

                a += nums[i];
            }
        }

        return a;
    }

    public int bigDiff(int[] nums) {

        int a = nums[0];
        int b = nums[0];

        for (int i = 0; i < nums.length; i++) {

            a = Math.max(a, nums[i]);
            b = Math.min(b, nums[i]);

        }
        return a - b;
    }

    public boolean sum28(int[] nums) {

        int x = 0;

        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 2) {
                x += 2;
            }
        }

        return x == 8;
    }

    public boolean has12(int[] nums) {

        boolean h1 = false;
        boolean h2 = false;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                h1 = true;
            }
            if (nums[i] == 2 && h1) {
                h2 = true;
            }
        }

        return h2;
    }


}
