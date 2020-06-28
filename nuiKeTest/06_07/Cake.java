import java.util.Scanner;

public class Cake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int res = count(n,m);
            System.out.println(res);
        }
    }
    public static int count(int n, int m){
        int preCol = (n / 4) * 2 + (n % 4 < 2 ? n % 4 : 2);
        int latCol = ((n - 2) / 4) * 2 + ((n - 2) % 4 < 2 ? (n - 2) % 4 : 2);
        int res = ( m / 4) * (preCol + latCol) * 2;
        if(m % 4 > 0 ){
            res += preCol;
        }
        if( m % 4 > 1){
            res += preCol;
        }
        if(m % 4 > 2) {
            res += latCol;
        }
        return res;
    }
}
