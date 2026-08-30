package LEETCODE;

public class MULTIPLE2 {
    public static void main(String[] args) {
        // RIGHTMOST SET BIT
        int n=78;
        int ans=n|n+1;  // we can get  answer using this statement.

        // using loop

        for(int i=0;i<31;i++){
            if((n>>i)%2==0){
                ans=(1<<i)|n;
                break;
            }
        }


        // power of two

        boolean check=false;

        for(int i=0;i<31;i++){
            if((1<<i)==n){
                check=true;
                break;
            }
        }


        //subset 




    }
}
