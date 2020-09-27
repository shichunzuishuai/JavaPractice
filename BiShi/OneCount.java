package BiShi;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class OneCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] ret = count(a);
        System.out.println(Arrays.toString(ret));
    }
    public static int[] count(int num){
        List<Integer> list = new ArrayList<>();
        int flag = 1;
        for (int i = 0; i <= num; i++) {
            int count = 0;
            for (int j = 0; j < 32; j++) {
                if((i & flag) == flag){
                    count++;
                }
                flag = flag << 1;
                if(j == 31){
                    flag = 1;
                }
            }
            list.add(count);
        }
        int a = 0;
        int[] arr = new int[list.size()];
        for (Integer e:list) {
            arr[a++] = e;
        }
      return arr;
    }
}
