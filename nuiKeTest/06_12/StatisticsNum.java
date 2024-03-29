import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/a2063993dd424f9cba8246a3cf8ef445
 * 来源：牛客网
 * 给定一个k位整数N = dk-1*10k-1 + ... + d1*101 + d0 (0<=di<=9, i=0,...,k-1, dk-1>0)，请编写程序统计每种不同的个位数字出现的次数。例如：给定N = 100311，则有2个0，3个1，和1个3。
 *
 * 输入描述:
 *
 * 每个输入包含1个测试用例，即一个不超过1000位的正整数N。
 * 输出描述:
 * 对N中每一种不同的个位数字，以D:M的格式在一行中输出该位数字D及其在N中出现的次数M。要求按D的升序输出。
 * 示例1
 * 输入
 * 100311
 * 输出
 *
 * 0:2<br/>1:3<br/>3:1
 */
public class StatisticsNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            int[] num = new int[str.length()];
            for (int i = 0; i < str.length(); i++) {
                num[i] = Integer.parseInt(String.valueOf(str.charAt(i)));
            }
            countNum(num);
            //System.out.println(Arrays.toString(num));
        }
    }
    public static void countNum(int[] arr){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            Integer count = map.get(arr[i]);
            if(count == null){
                map.put(arr[i],1);
            }else {
                map.put(arr[i],count + 1);
            }
        }
        for (Map.Entry<Integer,Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }
}
