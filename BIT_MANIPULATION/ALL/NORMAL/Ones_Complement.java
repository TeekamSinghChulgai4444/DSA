package NORMAL;

public class Ones_Complement {
    public static void main(String[] args) {
        // ones complement

        byte x=5;

        System.out.println(~x);

        /*
         1 0 1 0 0 1 1 0 1 1 0
         0 1 0 1 1 0 0 1 0 0 1

          5 === 0 0 0 0 0 1 0 1
          ~x=== 1 1 1 1 1 0 1 0



         */

        // two's complement

        System.out.println(~x+1);
        System.out.println(-x);



    }
}
