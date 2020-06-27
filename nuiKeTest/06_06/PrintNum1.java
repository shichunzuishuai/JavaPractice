import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PrintNum1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String input = scanner.nextLine();
            String[] res = input.split(" ");
            int[] num = new int[res.length];
            for(int i = 0; i < res.length; i++){
                num[i] = Integer.parseInt(res[i]);
            }
            int ret = print(num);
            System.out.println(ret);
        }
    }
    public static int print(int[] arr){
        Map<Integer,Integer> map = new HashMap();
        for (int x:arr) {
            Integer count = map.get(x);
            if(count == null){
                map.put(x,1);
            }else {
                map.put(x,count+1);
            }
        }
        //遍历Map,找到符合条件的数字
        for (Map.Entry<Integer,Integer> entry: map.entrySet()) {
            if(entry.getValue() >= (arr.length) / 2){
                return entry.getKey();
            }
        }
        return 0;
    }
}
