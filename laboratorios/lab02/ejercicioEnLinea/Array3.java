public class Array3 {

    public int maxSpan(int[] nums) {

        int m = 0;
        int s = 0;

        for(int i = 0; i<nums.length; i++){
            for(int j = nums.length-1; j>=0; j--){


                if(nums[i]==nums[j])

                    s = j-i+1;

                if (s>m) m =s;

            }

        }

        return m;
    }


    public boolean linearIn(int[] outer, int[] inner) {

        int a = 0;

        for(int i =0; i<inner.length; i++){
            for(int j =0; j<outer.length; j++){

                if(i<inner.length){
                    if(inner[i]==outer[j]){

                        a++;
                        i++;
                    }
                }
            }
        }
        return a==inner.length;
    }

    public int[] seriesUp(int n) {

        int [] a = new int [n*(n + 1)/2];

        int b = 0;

        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=i; j++){

                a[b++]=j;
            }
        }


        return a;
    }

    public int[] squareUp(int n) {

        int [] a = new int [n*n];

        int b = 0;

        for(int i =1; i<=n; i++){
            for(int j = n; j>=1; j--){

                a[b++]=j;

                if(i<j)
                    a[b-1] = 0;

            }
        }

        return a;

    }

    public int countClumps(int[] nums) {
        int a = 0;
        int b = -1;
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] == nums[i + 1] && nums[i] != b) {
                b = nums[i];
                a++;
            }

            for(int j = 0; j < nums.length - 1; j++) {
                if(nums[i] !=b) {
                    b = -1;
                }
            }
        }

        return a;
    }

}
