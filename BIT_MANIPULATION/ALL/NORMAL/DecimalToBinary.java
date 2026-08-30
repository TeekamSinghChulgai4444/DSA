package NORMAL;

import java.util.*;

public class DecimalToBinary {
    public static String DecimalBinary(int num){
        String ans="";
        while(num>0){
            int rem=num%2;
            num/=2;
            String temp="";
            temp+=rem;
            temp+=ans;
            ans=temp;

        }
        return ans;
    }
    public static int BinaryToDecimal(String num){
        int sum=0;
        int p=1;

        int l=num.length();

        for(int i=l-1;i>=0;i--){
            char ch=num.charAt(i);
            int b=(ch=='1')?1:0;
            sum+=p*b;
            p*=2;
        }
        return sum;
    }
    public static void main(String[] args) {

        System.out.println(DecimalBinary(8));
        System.out.println(BinaryToDecimal("1101101101000"));

    }
}
