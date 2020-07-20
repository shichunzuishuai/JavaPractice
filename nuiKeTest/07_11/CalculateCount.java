/**
 *
 */

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class CalculateCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            Map<Character,Integer> map = new HashMap<>();
            String str = scanner.nextLine();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                Integer count = map.get(c);
                if(c >= 'A' && c <= 'Z' && count == null){
                    map.put(c,1);
                }else if(c >= 'A' && c <= 'Z' && count != null){
                    map.put(c,count + 1);
                }
            }
            for (int i = 65; i <= 90; i++) {
                Integer res = map.get((char)i);
                if(res == null){
                    System.out.println((char)i + ":" + "0");
                }else {
                    System.out.println((char) i + ":" + res);
                }

            }
        }
    }
}
