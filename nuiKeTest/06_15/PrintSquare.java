import java.util.Scanner;

/**
 *
 */
public class PrintSquare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            String[] arr = str.split(" ");
            int[] num = new int[arr.length];
            num[0] = Integer.parseInt(arr[0]);
            String ch = arr[1];
            print(num[0],ch);
        }
    }
    public static void print(int num,String ch){
        int res = num / 2;
        if(num % 2 != 0){
             res = (num) / 2 +1;
        }
        for(int i = 0; i <res; i++){
            for(int j = 0; j < num; j++){
                if(i == 0 || i == res - 1 ){
                    System.out.print(ch);
                }else if( j == 0 || j == num - 1 ){
                    System.out.print(ch);
                }else if(j !=0 || j != num - 1){
                    System.out.print(" ");
                }
            }
            System.out.println();

        }
    }
}
