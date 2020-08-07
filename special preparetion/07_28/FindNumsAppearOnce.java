import java.util.HashMap;
import java.util.Map;

public class FindNumsAppearOnce {
    public static void main(String[] args) {
        int[] arr = {2,4,3,6,3,2,5,5};
        int[] num1 = new int[1];
        int[] num2 = new int[2];
        findNumsAppearOnce(arr,num1,num2);

    }
    public static void findNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            Integer count = map.get(array[i]);
            if(count == null){
                map.put(array[i],1);
            }else {
                map.put(array[i],count + 1);
            }
        }
        int flag = 0;
        for (Map.Entry<Integer,Integer> entry:map.entrySet()) {
            if(entry.getValue() == 1 && flag == 0){
                num1[0] = entry.getKey();
                flag++;
            }else if(entry.getValue() == 1 && flag == 1){
                num2[0] = entry.getKey();
            }
        }
        System.out.println(num1[0] + "," + num2[0]);
    }
}
