/**
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。
 * 同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，
 * 这家伙原来把句子单词的顺序翻转了，正确的句子应该是“I am a student.”。
 * Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 *
 * OJ链接：https://www.nowcoder.com/practice/3194a4f4cf814f63919d0790578d51f3?
 * tpId=13&tqId=11197&rp=1&ru=/ta/coding-interviews&qru=/ta/coding-interviews/question-ranking
 *
 * 解题思路：
 * 又是一个字符串逆置的问题，我们可以参考上面的思路。不过这里要考虑自己划分子串的问题
 */
public class ReverseSentence {
    public String reverseSentence(String str) {
        if(str.length() == 0 || str == null){
            return str;
        }
        int i = 0;
        int j = 0;
        int len = str.length();
        char[] arr = str.toCharArray();
        while(i < len){
            //让i一直向后走,知道遇到第一个空格
            while(i < len && !Character.isSpace(arr[i])){
                i++;
            }
            //逆置当前有效的子串,采取闭区间
            Reverse(arr,j,i - 1);
            //去除多有的空格
            while(i < len && Character.isSpace(arr[i])){
                i++;
            }
            //让j等于新的起点
            j = i;
        }
        //走到这一步,i==len,所以最后一个有效子串还没有进行逆置,要在进行一次逆置
        Reverse(arr,j,i - 1);
        //整体逆置
        Reverse(arr,0,i - 1);
        return new String(arr);
    }
    public void Reverse(char[] arr, int start,int end){
        while(start < end){
            char temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }
}
