import java.util.Arrays;
import java.util.Scanner;
public class CopyArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] array = new int[6];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        System.out.println("拷贝前:" + Arrays.toString(array));
        int[] ret = copyArray(array);
        System.out.println("拷贝后:" + Arrays.toString(ret));
    }
    public static int[] copyArray(int[] array){
        int[] array2 = new int[array.length];
        for(int i = 0; i < array.length;i++){
            array2[i] = array[i];
        }
        return array2;
    }
}
