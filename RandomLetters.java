package Practice8;

import java.util.Scanner;

public class RandomLetters {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String palabra;
        System.out.print("Ingresa palabra: ");
        palabra = scn.nextLine();
        char []caracteres=palabra.toCharArray();
        int count = palabra.length();
       
        for (int i = 0; i < count; i++) {
            caracteres[i]=palabra.charAt(i);
            palabra = palabra.substring(1) + palabra.charAt(i);
            System.out.println(palabra);
        }


    }
}