package MagicSquare;

import java.util.Scanner;
public class MagicSquare {
     public static void main(String[] args){
    	 
    	 
    	 Scanner sc = new Scanner(System.in);
    	      System.out.print ("Ingrese un numero impar:");
    	      int n = sc.nextInt (); 
    	 if(  n%2 == 0 ){
    		      System.out.println ("El numero digitado es par");
    		 return;
    	 }
         int i,j;
    	 
    	 
    	      int array [] [] = new int [n] [n]; 
    	      int a = n-1; 
    	      int b = n / 2; 
    	 
    	 
    	 

    	 for ( i = 1 ; i <= n*n ; i++ ){
    		      array [a ++] [b ++] = i; 
    		      if (i% n == 0) {
    			      a = a-2; 
    		     b = b-1;
    		      } else {
    			 a = a%n;
    			 b = b%n;
    		 }
    	 }
    	   	
    	 
    	 
    	      System.out.println (n + "El cuadro magico es:");
    	      for (i = 0; i <n; i ++) {
    		 for ( j = 0 ; j < n ; j++){
    			 System.out.print(" "+array[i][j]);
    		 }
    		 System.out.println();
    	 }
    	 
    	 
     
     }
   
}
