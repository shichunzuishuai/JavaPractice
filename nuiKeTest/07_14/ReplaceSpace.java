/**
 * 链接：https://www.nowcoder.com/questionTerminal/b0850698cb41449188344cdb647f3e99
 * 来源：牛客网
 *
 * 请编写一个方法，将字符串中的空格全部替换为“%20”。假定该字符串有足够的空间存放新增的字符，并且知道字符串的真实长度(小于等于1000)，同时保证字符串由大小写的英文字母组成。
 *
 * 给定一个string iniString 为原始的串，以及串的长度 int len, 返回替换后的string。
 *
 * 测试样例：
 * "Mr John Smith”,13
 * 返回："Mr%20John%20Smith"
 * ”Hello  World”,12
 * 返回：”Hello%20%20World”
 */
public class ReplaceSpace {
    public static void main(String[] args) {
        String str = "das ad dsa";
       String res = replaceSpace(str,10);
        System.out.println(res);
    }
    public static String  replaceSpace(String iniString, int length) {
        // write code here
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            char c = iniString.charAt(i);
            if(c != ' '){
                sb.append(c);
            }else {
                sb.append("%2");
            }
        }
        String res = "";
        for (int i = 0; i < sb.length(); i++) {
            res += sb.charAt(i);
        }
        return res;
    }
}
