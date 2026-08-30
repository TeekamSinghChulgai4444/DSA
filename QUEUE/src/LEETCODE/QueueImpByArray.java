package LEETCODE;

import java.util.*;

public class QueueImpByArray {
    static int head=-1;
    static int tail=-1;

    public static void push_front(int val,int[] arr,int n){
        if(head==-1){
            head=0;
            tail=0;
            arr[tail]=val;
            return;
        }
        if(head==0 && tail==n-1 || tail+1==head){
            System.out.println("QUEUE is full ");
            return;
        }

          head=(head==0)?n-1:head-1;
          arr[head]=val;

    }
    public static void push_back(int val , int [] arr , int n){

        if(head==-1){
            head=0;
            tail=0;
            arr[tail]=val;
            return;
        }
        if(head==0 && tail==n-1 || tail+1==head){
            System.out.println("QUEUE is full ");
            return;
        }
        tail=(tail==n-1)?0:tail+1;
        arr[tail]=val;

    }
    public static void pop_front(int val){
        if(head==-1){
            System.out.println("queue is empty");
            return ;
        }
        if(head==tail){
            head=-1;
            tail=-1;
        }

    }public static void pop_back(int val){

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n;
        System.out.print("Enter the Array Size : ");
        n=sc.nextInt();

        int [] arr= new int[n];

    }
}
