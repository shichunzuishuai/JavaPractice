import java.util.*;

/**
 * 链接：https://www.nowcoder.com/questionTerminal/e8480ed7501640709354db1cc4ffd42a
 * 来源：牛客网*
 * [编程题]DNA序列
 * 热度指数：26970时间限制：C/C++ 1秒，其他语言2秒空间限制：C/C++ 32M，其他语言64M
 * 算法知识视频讲解
 * 一个DNA序列由A/C/G/T四个字母的排列组合组成。G和C的比例（定义为GC-Ratio）是序列中G和C两个字母的
 * 总的出现次数除以总的字母数目（也就是序列长度）。在基因工程中，这个比例非常重要。因为高的GC-Ratio
 * 可能是基因的起始点。
 * 给定一个很长的DNA序列，以及要求的最小子序列长度，研究人员经常会需要在其中找出GC-Ratio最高的子序列。
 * 输入描述:
 * 输入一个string型基因序列，和int型子串的长度
 * 输出描述:
 * 找出GC比例最高的子串,如果有多个输出第一个的子串
 * 示例1
 * 输入
 *
 * AACTGTGCACGACCTGA
 * 5
 * 输出
 *
 * GCACG
 */
public class FindGC {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            int n = scanner.nextInt();
            String res = find(str,n);
            System.out.println(res);
        }
    }
    public static String find(String str, int n){
        str.toUpperCase();
        if(str.length() == n){
            return str;
        }
        String res = "";
        int GCCount = 0;
        for(int i = 0; i <str.length() - n;i++){
            int max = 0;
            String temp = str.substring(i,i +n);
            for (int j = 0; j < temp.length(); j++) {
                if(temp.charAt(j) == 'G' || temp.charAt(j) == 'C'){
                    max++;
                }
            }
            if(max > GCCount){
                GCCount = max;
                res = temp;
            }
        }
        return res;
    }
}
