import java.util.Scanner;
public class StudentScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            String s1 = scanner.nextLine();
            String s = scanner.nextLine();
            int sc = scanner.nextInt();
            String[] arr = s.split(" ");
            int[] num = new int[arr.length];
            for (int i = 0; i < arr.length; i++) {
                num[i] = Integer.parseInt(arr[i]);
            }
            int ret = score(n,num,sc);
            System.out.println(ret);
        }
    }
    public static int score(int n,int[] arr,int sc){
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == sc){
                count++;
            }
        }
        return count;
    }
}
