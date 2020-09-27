package BiShi;

import java.util.*;

public class PublicState {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList a = new ArrayList();
        ArrayList b = new ArrayList();
    }
    public ArrayList<Integer> mergerArrays (ArrayList<Integer> arrayA, ArrayList<Integer> arrayB) {
        // write code here
        ArrayList<Integer> list = new ArrayList<>();
        if(arrayA.size() == 0 || arrayB.size() == 0){
            return list;
        }
     //   Set<Integer> set = new HashSet<>();
        Map<Integer,Integer> map = new HashMap<>();
        int lenA = arrayA.size();
        int lenB = arrayB.size();
        int len = lenA > lenB ? lenA : lenB;
        int[] arr = new int[len];
        int a = 0;
//        for (int i = 0; i < lenA; i++) {
//            set.add(arrayA.get(i));
//        }
//        for (int i = 0; i < lenB; i++) {
//            if(set.contains(arrayB.get(i)));
////            arr[a++] = arrayB.get(i);
//            list.add(arrayB.get(i));
//        }
//       // Arrays.sort(arr);
//        Collections.sort(list);
//        return list;
        for (int i = 0; i < lenA; i++) {
           if(map.get(arrayA.get(i)) != null){
               int count = map.get(arrayA.get(i));
               map.put(arrayA.get(i),count +1);
           }else {
               map.put(arrayA.get(i),0);
           }
        }
        for (int i = 0; i < lenB; i++) {
            if(map.containsKey(arrayB.get(i)));
            list.add(arrayB.get(i));
        }
        Collections.sort(list);
        return list;
    }
}
