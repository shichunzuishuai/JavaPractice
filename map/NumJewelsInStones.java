package map;

import java.util.HashSet;
import java.util.Set;

/**
 * 771. 宝石与石头
 *  给定字符串J 代表石头中宝石的类型，和字符串 S代表你拥有的石头。 S 中每个字符代表了一种你拥有的石头的类型，你想知道你拥有的石头中有多少是宝石。
 * J 中的字母不重复，J 和 S中的所有字符都是字母。字母区分大小写，因此"a"和"A"是不同类型的石头。
 * 示例 1:
 * 输入: J = "aA", S = "aAAbbbb"
 * 输出: 3
 */
public class NumJewelsInStones {
    public int numJewelsInStones(String J, String S) {
        //J是宝石,S是石头
        int count = 0;
        //这是一种方法,但是String.contains的时间复杂度为O(N)
        //整体的复杂度就位O(N^2),比较浪费时间
//        for(int i = 0; i < S.length(); i++){
//            char c = S.charAt(i);
//            if(J.contains(c + "")){
//                count++;
//            }
//        }
//        return count;
        //改进思路:不使用String.contains,使用set.contains
        //TreeSet.contains为O(logN);
        //HashSet.contains为O(1);
        Set<Character> set = new HashSet<>();
        //1.先把J中的元素放进set中
        for(int i = 0; i < J.length(); i++){
            set.add(J.charAt(i));
        }
        //2.遍历S,判定S中的字符是否出现在set中
        for(int i = 0; i < S.length(); i++){
            if(set.contains(S.charAt(i))){
                count++;
            }
        }
            return count;
    }
}
