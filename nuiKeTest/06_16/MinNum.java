import java.util.*;
public class MinNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            int[] num = new int[arr.length];
            for (int i = 0; i < 10; i++) {
                num[i] = Integer.parseInt(arr[i]);
            }
            minNum(num);
            //help(num);
        }
    }
    public static void minNum(int[] arr1){
        int[] arr = help(arr1);
        Arrays.sort(arr);
        int[] num = new int[arr.length];
        int flag = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] != 0){
                num[0] = arr[i];
                flag = i;
                break;
            }
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i< arr.length; i++){
            list.add(arr[i]);
        }
        int[] num2 = new int[arr.length - 1];
        list.remove(flag);
        int k = 0;
        for (int x: list) {
            num2[k] = x;
            k++;
        }
        //System.out.println(Arrays.toString(num2));
        //arr[arr.length - 2] = tmp;
        for(int i = 0; i < num2.length; i++){
            num[i + 1] = num2[i];
        }
        for (int i = 0; i < num.length; i++) {
            System.out.print(num[i]);
        }
    }
    public static int[] help(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int k = 0; k < arr[i]; k++) {
                list.add(i);
            }
        }
        int[] num2 = new int[list.size()];
        int k = 0;
        for (int tmp: list) {
            num2[k] = tmp;
            k++;
        }
        //System.out.print(Arrays.toString(num2));
        return num2;
    }
}
