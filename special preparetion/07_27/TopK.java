import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class TopK {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k){
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || k <= 0 || k > input.length){
            return list;
        }
        //按照数值从小到大
        PriorityQueue<Integer> queue = new PriorityQueue(k, Collections.reverseOrder());
        for(int i = 0; i < input.length; i++){
            if(i < k){
                queue.offer(input[i]);
            }else {
                if(input[i] < queue.peek()){
                    queue.poll();
                    queue.offer(input[i]);
                }
            }
        }
        for(int i = 0; i < k; i ++){
            list.add(queue.poll());
        }
        return list;
    }
}
