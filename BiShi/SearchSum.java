package BiShi;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class SearchSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int n = scanner.nextInt();
        String[] arr = str.split("");
        int[] ret = new int[arr.length];
        for(int i = 0; i < ret.length; i++){
            ret[i] = Integer.parseInt(arr[i]);
        }
        search(ret,n);
    }
    public static void search(int[] arr,int toFind){
        int[] ret = new int[2 * arr.length];
        int c = 0;
        int d = 0;
        for (int i = 0; i < arr.length; i++) {
            int a = arr[i];
            for (int j = 0; j < arr.length; j++) {
                int b = arr[j];
                if((a + b) == toFind){
                    ret[c++] = a;
                    ret[c++] = b;
                     d = j;
                }
            }
            if(arr[i] == arr[d]){
                continue;
            }
        }
//        for (int i = 0; i < arr.length; i+=2){
//            System.out.println(ret[i] + "," + ret[i + 1]);
//        }
        System.out.println(Arrays.toString(ret));
    }
}
