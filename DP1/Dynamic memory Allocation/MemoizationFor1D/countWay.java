package MemoizationFor1D;
import java.util.*;

public class countWay {
    public int count(int n ,int dp [], int end){
        if(n>end){
            return 0;
        }
        if(n==end){
            return 1;
        }
        if(dp[n] != -1){
            return dp[n];
        }

        return dp[n]=(count(n+1,dp,end)+count(n+2,dp, end));

    }
    public static void main(String[] args) {

        System.out.print("Enter an input number: ");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int [] dp=new int[n+1];

        countWay obj= new countWay();
        Arrays.fill(dp, -1);

        System.out.println("Answer : "+ obj.count(1,dp,n));



    }
}
