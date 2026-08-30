package Leetcode;

import java.util.Arrays;

public class NumberOfProvinces {  // leet code 547 -- Connected edge

    // province means to , how many way there to collect or search  all the nodes

    public int findCircleNum(int [][] isConnected){
        int l= isConnected.length;
       boolean check[]=new boolean[l];
        Arrays.fill(check,false);

        int ans=0;

        for(int i=0;i<l;i++){
            if(!check[i]) {
                ans = ans + 1;
                for (int j = i; j < l; j++) {

                    if(isConnected[i][j]==1){
                        check[j]=true;
                    }

                }
            }
        }


        return ans;
    }
    public static void main(String[] args) {

        int graph[][]={{1,0,0},
                       {1,1,0},
                       {0,0,1}};

        NumberOfProvinces obj = new NumberOfProvinces();
        System.out.println("Answer :: "+ obj.findCircleNum(graph));

    }
}
