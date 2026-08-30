package NORMAL;

public class DataType {
    public static void main(String[] args) {
        byte a=127;

        /*

         1 byte = 8 bit;

         byte = _ _ _ _ _ _ _ _ ;

         1 bit = 0 or 1 ( we can store two elements);

          range of byte= 2 ^ 8 = 256;
          negative = 2^7;   // numbers
          0 included
          positive = 2 ^ 7 -1; // numbers

          range= -128 ..... 0.....127

          same with int:

        */
        System.out.println(a);
        a+=4;

        // 0       1  2     3    4   5      6    7

        // 127 ,-128,-127,-126,-125,-124 ,-123 ,-122
        System.out.println(a);


        /*
         nibble ::

         1 nibble = 4 bit;
         nibble = _ _ _ _ ;

         1 nibble =2^4 =16 elements;

          range= -8.,-7,-6,-5,-4,-3,-2,-1,0,1,2,3,4,5,6,7


           */




    }
}
