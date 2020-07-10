import java.util.*;
public class Train {
    static List<String> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            list.clear();
            int n = scanner.nextInt();
            int[] id=new int[n];
            Stack<Integer> stack=new Stack<Integer>();
            for(int i=0;i<n;i++) {
                id[i]=scanner.nextInt();
            }
            trainOut(id,0,stack,"",0);
            Collections.sort(list);    //对结果集排序
            for(String str:list) {
                System.out.println(str);
            }
        }
        scanner.close();
        }

    public static void trainOut(int[] id,int i,Stack<Integer> s,String str,int n){

        if(n==id.length) {
            list.add(str);
        }
        if(!s.empty()) {
            int temp=s.pop();
            trainOut(id,i,s,str+temp+" ",n+1);
            s.push(temp);
        }
        if(i<id.length) {
            s.push(id[i]);
            trainOut(id,i+1,s,str,n);
            s.pop();
        }
    }
}
