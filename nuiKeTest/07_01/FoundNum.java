/**
 *  链接：https://www.nowcoder.com/questionTerminal/069e2130430c41229ab25e47fa0949a6
 * 来源：牛客网

 * 输入一个数n，然后输入n个数值各不相同，再输入一个值x，输出这个值在这个数组中的下标（从0开始，若不在数组中则输出-1）。
 *
 * 输入描述:
 *
 * 测试数据有多组，输入n(1<=n<=200)，接着输入n个数，然后输入x。
 * 输出描述:
 * 对于每组输入,请输出结果。
 * 示例1
 * 输入
 *
 * 2
 * 1 3
 * 0
 * 输出
 *
 * -1
 */
import java.util.Arrays;
        import java.util.HashMap;
        import java.util.Map;
        import java.util.Scanner;

public class FoundNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextInt();
            }
            int s = scanner.nextInt();
            find(arr,s);
        }
    }

//    private static void find(int[] arr, int s) {
//        boolean flag = false;
//        for (int i = 0; i < arr.length; i++) {
//            if(arr[i] == s){
//                System.out.println(i);
//                flag = true;
//                break;
//            }
//        }
//        if(flag == false){
//            System.out.println("-1");
//        }
//    }

    private static void find(int[] arr,int tofind) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i],i);
        }
        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        boolean flag = false;
        int res = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(tofind > arr[mid]){
                left = mid + 1;
            }else if(tofind < arr[mid]){
                right = mid - 1;
            }else if(tofind == arr[mid]){
                res = arr[mid];
                flag = true;
                break;
            }
        }
        if(flag == true){
            System.out.println(map.get(res));
        }else {
            System.out.println("-1");
        }


    }
}
