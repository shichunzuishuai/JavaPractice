import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class DelSameString {
    public static String delSame(String str1, String str2){
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < str2.length(); i++){
            set.add(str2.charAt(i));
        }
        String res ="";
        for(int j = 0; j < str1.length(); j++){
            if(!set.contains(str1.charAt(j))){
                res += str1.charAt(j);
            }
        }
        return res;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            String str1 = sc.nextLine();
            String str2 = sc.nextLine();
            String res = delSame(str1,str2);
            System.out.println(res);
        }
    }
}
