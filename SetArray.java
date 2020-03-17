import java.util.Arrays;
public class SetArray {
    public static void main(String[] args) {
        int[] arr = setArray();
        System.out.println(Arrays.toString(arr));
    }
    public static int[] setArray(){
        int[] arr = new int[100];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }
        return arr;
    }
}
