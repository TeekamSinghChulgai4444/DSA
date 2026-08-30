package SpaceOptimizasation;

import java.util.Scanner;

public class fibo {
    public static int fibonacci(int n){

        if(n<=1){
            return n;
        }
        int grid[]=new int[3];

        grid[0]=0;
        grid[1]=1;

        for(int i=1;i<n;i++){
            grid[2]=grid[0]+grid[1];
            grid[0]=grid[1];
            grid[1]=grid[2];
        }

        return grid[2];

    }
    public static void main(String[] args) {

        Scanner sc= new Scanner(System.in);
        System.out.print("Enter  n : ");
        int n=sc.nextInt();

        fibo obj=new fibo();
        System.out.println("Answer: " + obj.fibonacci(n));

    }
}
