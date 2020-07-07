import java.util.*;

public class EatShell {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNext()){
            int x=scanner.nextInt();
            Map<Long, Integer> map=new HashMap<Long, Integer>();

            Queue<Long> queue=new LinkedList<Long>();
            queue.offer((long)x);
            map.put((long)x, 1);

            while(!queue.isEmpty()){
                long n=queue.poll();
                int a = 1000000007;
                if(n==0) {System.out.println(map.get(n)-1); return;}
                if(map.get(n)>=100001) continue;

                if(!map.containsKey((4*n+3)%a)){
                    map.put((4*n+3)%a, map.get(n)+1);
                    queue.offer((4*n+3)%a);
                }
                if(!map.containsKey((8*n+7)%a)){
                    map.put((8*n+7)%a, map.get(n)+1);
                    queue.offer((8*n+7)%a);
                }
            }
            System.out.println(-1);
        }
    }

}
