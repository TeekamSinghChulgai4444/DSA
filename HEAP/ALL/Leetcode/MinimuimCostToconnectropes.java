package Leetcode;
import java.util.*;;

public class MinimuimCostToconnectropes {
    public static int check(int[]arr ){
        PriorityQueue<Integer>pq = new PriorityQueue<>();

        for(var j : arr){
            pq.add(j);
        }
        int sum=0;
        while(pq.size()>1){
            int first=pq.poll();
            int second=pq.poll();
            sum+=first+second;

            pq.add(first+second);
        }
        return sum;
    }

    public static void main(String[] args) {

        int[] arr={2,6,7,4,9};
        int ans=check(arr);

        System.out.println("answer : "+ans);

    }
}
