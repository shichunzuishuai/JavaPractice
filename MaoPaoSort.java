import java.util.Arrays;
import java.util.Scanner;
public class MaoPaoSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[5];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        maoPaoSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void maoPaoSort(int[] arr){
        boolean flag = false;
        for (int j = 0; j < arr.length - 1; j++) {
            flag = false;
            for (int i = 0; i < arr.length -1 - j; i++){
                if(arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    flag = true;
                }
            }
            if(flag == false){
                return;
            }
        }

    }
}
