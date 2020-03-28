import java.util.Arrays;
public class IsInclude {
    /**
     *
     * @param args
     */

    public static void main(String[] args ){
        String s = "anagram";
        String t = "nagaram";
        boolean ret = isInclude(s,t);
        System.out.println(ret);
    }
    public static boolean isInclude(String s,String t){
        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return String.valueOf(sChars).equals(String.valueOf(tChars));
    }
}
