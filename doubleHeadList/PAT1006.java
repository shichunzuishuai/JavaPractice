package test;

import java.util.Arrays;
import java.util.Scanner;

public class PAT1006 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int ret = scanner.nextInt();
        int b = ret /10 /10;
        int s = ret / 10 % 10;
        int num = ret % 10;
        printB(b);
        printS(s);
        printNum(num);
    }
    public static void printB(int b){
        for(int i = 0; i < b; i++){
            System.out.print("B");
        }
    }
    public static void printS(int s){
        for(int i = 0; i < s; i++){
            System.out.print("S");
        }
    }
    public static void printNum(int n){
        for(int i = 1; i <= n; i++){
            System.out.print(i);
        }
    }
}
