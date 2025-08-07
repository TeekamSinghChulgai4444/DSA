class Solution{
    public:

    string intToRoman(int n ){
          string s;
          string s1000="M";
          string s500="D";
          string s100="C";     
          string s50="L";
          string s10="X";
          string s5="V";
          string s1="I";
          int a;
    
        if(n>=1000 && n<=5000){
              a=n/1000;
              int i=0;
              while(i<a){
                  s=s+s1000;
                  i++;   
                }
              n=n%1000;
        }
    
    
        if(n>=500 && n< 1000){
            a=n/100;
            if(a!=9){
                s=s+s500;
                n=n-500;
            }else{
                s=s+s100+s1000;
                n=n%100;
            }
        }
    
    
        if(n>=100 && n<500){
            a=n/100;
                if(a!=4){
                int i=0;
                while(i<a){
                   s=s+s100;
                    i++;
                }
                n=n%100;
            }else{
               s=s+s100+s500;
                n=n-400;
            }
        }
    
    
        if(n>=50 && n<100){
            a=n/10;
            if(a != 9){
                s=s+s50;
                n=n%50;
            }else{
                s=s+s10+s100;
                n=n%90;
            }
        }
    
    
       if(n>=10 && n<50){
           a=n/10;
           int i=0;
           if(a!=4){
               while(i<a){
                   s=s+s10;
                   i++;
               }
               n=n%10;
           }else{
               s=s+s10+s50;
               n=n%10;
           }
       }
    
    
       if(n>=5 && n<10){
           a=n/1;
           if(a!=9){
               s=s+s5;
               n=a-5;
           }else{
               s=s+s1+s10;
               n=n%1;
           }
    
       }
       if(n>=1 && n<5){
           a=n/1;
           if(a!=4){
               int i=0;
               while(i<a){
                s=s+s1;
                i++;
               }
              n=n%1;
           }else{
               s=s+s1+s5;
               n=n%1;
           }
    
        }
    
        return s;
    
    }
};