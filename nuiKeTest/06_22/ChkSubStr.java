import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ChkSubStr {
    public static void main(String[] args) {
        String[] p = {"a","b","c","d"};
        int n = 4;
        String str = "abc";
        boolean[] rt = chkSubStr(p,n,str);
        System.out.println(Arrays.toString(rt));
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

//    public static boolean[] chkSubStr(String[] p, int n, String s) {
//        // write code here
//        Set<Character> set = new HashSet<>();
//        String str = "";
//        for (int i = 0; i < n; i++) {
//            str += p[i];
//        }
//        char[] cs = str.toCharArray();
//        for (int i = 0; i < s.length(); i++) {
//            set.add(cs[i]);
//        }
//        boolean[] res = new boolean[n];
//        for (int i = 0; i < n; i++) {
//            char c = cs[i];
//            res[i] = set.contains(c);
//        }
//
//        return res;
//    }
    public static boolean[] chkSubStr(String[] p, int n, String s){
        boolean[] res = new boolean[n];
        for (int i = 0; i < n; i++) {
            res[i] = s.contains(p[i]);
        }
        return res;
    }
}
