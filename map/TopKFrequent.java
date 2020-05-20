package map;

import java.util.*;

/**
 * 692. 前K个高频单词
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 * 示例 1：
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 */
public class TopKFrequent {
    public List<String> topKFrequent(String[] words, int k) {
        //1.统计每个单词出现的次数
        Map<String,Integer> map = new HashMap<>();
        for (String x: words) {
            map.put(x,map.getOrDefault(x,0) + 1);
        }
        //2.把map中所有的key导入一个ArrayList中,相当于去重
        List<String> result = new ArrayList<>(map.keySet());
        //3.根据单词出现的次数对result进行排序
        Collections.sort(result, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //在这个匿名内部类中可访问到上面的map变量
                int count1 = map.get(o1);
                int count2 = map.get(o2);
                if(count1 == count2){
                    return o1.compareTo(o2);
                }
                return count2 -  count1;
            }
        });
        return result.subList(0,k);
    }
}
