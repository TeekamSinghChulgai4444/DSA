package NORMAL;

import java.util.*;
public class BitWiseOperator {
    public static void main(String[] args) {
        // bitwise operator

        // And & bitwise operator

        System.out.println(51&42);

        // or | bitwise operator

        System.out.println(51|24);

        // bitwise XOR operator (^)

        /*

        1 ^ 1  = 0           1 ^ x = compliment of x
        1 ^ 0  = 1;
        0 ^ 1  = 1           0 ^ x = x;
        0 ^ 0  = 0;

        a ^ a = 0;

        */

        // Single Number  in array

        System.out.println(2^0);


        int arr[]={1,1,2,3,3,4,4,5,5,6,6,7,7,7};
        int l=arr.length;
        int a=arr[0];
        for(int i=1;i<l;i++){
            a=a^arr[i];
        }

        System.out.println(a);

        // swap two number

        int A=20;
        int B=30;

        A=A^B;
        B=A^B;
        A=A^B;


        System.out.println("A : "+ A + " B : "+B);








    }
}
