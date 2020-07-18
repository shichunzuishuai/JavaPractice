/**
 * 链接：https://www.nowcoder.com/questionTerminal/79db907555c24b15a9c73f7f7d0e2471
 * 来源：牛客网
 * 大家应该都会玩“锤子剪刀布”的游戏：
 * 现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。
 * 输入描述:
 * 输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代
 * 表“布”，第1个字母代表甲方，第2个代表乙方，中间有1个空格。
 * 输出描述:
 * 输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯
 * 一，则输出按字母序最小的解。
 * 示例1
 * 输入
 * 10<br/>C J<br/>J B<br/>C B<br/>B B<br/>B C<br/>C C<br/>C B<br/>J B<br/>B C<br/>J J
 * 输出
 * 5 3 2<br/>2 3 5<br/>B B
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FingerGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String[] arr = new String[n];
            scanner.nextLine();
            for (int i = 0; i < n; i++) {
                arr[i] = scanner.nextLine();
            }
            game(arr);
        }
    }
    public static void game(String[] arr){
        Map<String,Integer> map = new HashMap<>();
        String as = "as";
        String af = "af";
        String p = "p";
        String bs = "bs";
        String bf = "bf";
        int ac = 0;
        int ab = 0;
        int aj = 0;
        int bc = 0;
        int bb = 0;
        int bj = 0;
        for (int i = 0; i < arr.length; i++) {
            String str = arr[i];
            if(str.charAt(0) == str.charAt(2)) {
                map.put(p, getCount(map, p));
            }
            else if(str.charAt(0) == 'C'){
                if(str.charAt(2) == 'J'){
                    map.put(as,getCount(map,as));
                    ac++;
                    map.put(bf, getCount(map,bf));
                }else {
                    map.put(bs,getCount(map,bs));
                    bb++;
                    map.put(af,getCount(map,af));
                }
            }else if(str.charAt(0) == 'J'){
                if(str.charAt(2) == 'C'){
                    map.put(bs,getCount(map,bs));
                    aj++;
                    map.put(af,getCount(map,af));

                }else {
                    map.put(as,getCount(map,as));
                    bc++;
                    map.put(bf,getCount(map,bf));
                }
            }else if(str.charAt(0) == 'B'){
                if(str.charAt(2) == 'C'){
                    map.put(as,getCount(map,as));
                    ab++;
                    map.put(bf,getCount(map,bf));
                }else {
                    map.put(bs,getCount(map,bs));
                    bj++;
                    map.put(af,getCount(map,af));
                }
            }
        }



        int[] arr3 = new int[6];

        if(map.get(as) != null){
            arr3[0] = map.get(as);
        }else {
            arr3[0] = 0;
        }
        if(map.get(p) != null){
            arr3[1] = map.get(p);
        }else {
            arr3[1] = 0;
        }
        if(map.get(af) != null){
            arr3[2] = map.get(af);
        }else {
            arr3[2] = 0;
        }
        if(map.get(bs) != null){
            arr3[3] = map.get(bs);
        }else {
            arr3[3] = 0;
        }
        if(map.get(p) != null){
            arr3[4] = map.get(p);
        }else {
            arr3[4] = 0;
        }if(map.get(bf) != null){
            arr3[5] = map.get(bf);
        }else {
            arr3[5] = 0;
        }

        for (int i = 0; i < 3; i++) {
            System.out.print(arr3[i] + " ");
        }
        System.out.println();
        for(int i = 3; i < 6; i++){
            System.out.print(arr3[i] + " ");
        }
        System.out.println();


        int maxA = ab >= ac ? ab : ac;
        int resA = maxA >= aj ? maxA : aj;
        int maxB = bb >= bc ? bb : bc;
        int resB = maxB >= bj ? maxB :bj;
        if(resA == ab){
            System.out.print("B" + " ");
        }else if(resA == ac){
            System.out.print("C" + " ");
        }else if(resA == aj){
            System.out.print("J"+ " ");
        }
        if(resB == bb){
            System.out.print("B"+ " ");
        }else if(resB == bc){
            System.out.print("C"+ " ");
        }else if(resB == bj){
            System.out.print("J"+ " ");
        }
        System.out.println();
    }
    public static int getCount(Map<String,Integer> map, String s){
        Integer count = map.get(s);
        if(count == null){
            map.put(s,1);
        }else {
            map.put(s,count + 1);
        }
        return map.get(s);
    }
}
