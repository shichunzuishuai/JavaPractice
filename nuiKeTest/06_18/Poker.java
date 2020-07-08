import java.util.*;
public class Poker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] ret = null;
                int a2 = scanner.nextInt();
                int k = scanner.nextInt();
                String s2 = scanner.nextLine();
                String s = scanner.nextLine();

                String[] str = s.split(" ");
                int[] num = new int[str.length];
                for (int j = 0; j < str.length; j++) {
                    num[j] = Integer.parseInt(str[j]);
                }
                 ret = res(num,k);
                list.add(ret);
        }
        for (int[] x: list) {
            for(int i = 0; i <x.length;i++){
                System.out.print(x[i] + " ");
            }
            System.out.println();
        }
    }
    public static int[] print(int[] num){
        int[] num1 = new int[num.length / 2];
        int[] num2 = new int[num.length / 2];
        int flag = 0;
        for (int i = 0; i < num.length; i++) {
            if(i < (num.length / 2)){
                num1[i] = num[i];
            }else {
                num2[flag] = num[i];
                flag++;
            }
        }
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        for (int i = 0; i < num1.length; i++) {
            stack1.add(num1[i]);
            stack2.add(num2[i]);
        }
        List<Integer> list = new ArrayList<>();
        while (!stack2.isEmpty()){
            list.add(stack2.pop());
            list.add(stack1.pop());
        }
        int[] num3 = new int[num.length];
        int k = 0;
        for (int i = 0; i < num.length; i++) {
            num3[num.length - 1 - i] = list.get(i);
        }
        //System.out.println(Arrays.toString(num3));
        return num3;
    }
    public static int[] res(int[] num,int k){
        if(k == 1){
            return print(num);
        }
        return res(print(num), k -1);
    }
}


