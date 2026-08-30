package LEETCODE;

public class multile_q {
    static boolean checkKthBit(int n, int k) {
        return ((n<<k)%2==1);
    }

    static int setKthBit(int n ,int k){
        return ((1<<k)| n);
    }

    static int OffKthBit(int n ,int k){
        return (~(1<<k) & n);
    }
    public static void main(String[] args) {

        // check kth bit is set or not

               boolean ans= checkKthBit(123,5);
               System.out.println(ans);

       // set on kth bit


                /*
                         k
                 1 1 1 1 0 1 1 1 1 0 0 1
                 -----bitwise or(|)-----
                 0 0 0 0 1 0 0 0 0 0 0 0
                 */
                //concept of bit masking

                int ans2=setKthBit(45,3);

        // turn of kth bit


                /*
                         k
                 1 1 1 1 1 1 1 1 1 0 0 1
                 -----bitwise and (&)-----
                 1 1 1 1 0 1 1 1 1 1 1 1
              --------------------------------
                 1 1 1 1 0 1 1 1 1 0 0 1

                 */

                int ams3=OffKthBit(10,1);

       // toggle kth bit
               /*
                         k
                 1 1 1 1 0 1 1 1 1 0 0 1
                 -----bitwise xor (^)---------
                 0 0 0 0 1 0 0 0 0 0 0 0
             --------------------------------
                 1 1 1 1 1 1 1 1 1 1 1 1
                 */

        int t1=46;
        int k3=3;

        int ans4=(1<<k3)^t1;


    }
}
