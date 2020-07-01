import java.util.Scanner;

/**
 * 找出n个数里最小的k个
 * 输入描述:
 * 每个测试输入包含空格分割的n+1个整数，最后一个整数为k值,n
 * 不超过100。
 * 输出描述:
 *
 * 输出n个整数里最小的k个数。升序输出
 * 示例1
 * 输入
 * 3 9 6 8 -10 7 -11 19 30 12 23 5
 * 输出
 * -11 -10 3 6 7
 */
public class SearchKMin {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()){
            String str = sc.nextLine();
            String[] arr = str.split(" ");
            int[] num = new int[arr.length - 1];

            for (int i = 0; i < arr.length - 1; i++) {
                num[i] = Integer.parseInt(arr[i]);
            }
            search(num,Integer.parseInt(arr[arr.length - 1]));
        }
    }
    public static void search(int[] arr, int k){
        quickSort(arr,0,arr.length - 1);

        int[] num = new int[k];
        for(int i = 0; i < k; i++){
            num[i] = arr[i];
        }
        for (int i = 0; i < k -1; i++) {
            System.out.print(num[i] + " ");
        }
        System.out.println(num[k - 1]);
    }
    public static void quickSort(int[] arr,int left, int right){
        if(left >= right){
            return;
        }
        int index = partition(arr,left,right);
        quickSort(arr,left,index  -1);
        quickSort(arr,index + 1,right);
    }
    private static int partition(int[] arr,int left,int right) {
        int baseVal = arr[right];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j && arr[i] <= baseVal){
                i++;
            }
            while (i < j && arr[j] >= baseVal){
                j--;
            }
            swap(arr,i,j);
        }
        swap(arr,i,right);
        return i;
    }
    public static void swap(int[] arr,int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
