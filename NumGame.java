import java.util.Scanner;
public class NumGame {
    public static void main(String[] args) {
        String word = "123456";
        passWord(word);
    }
    public static String passWord(String word) {
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        System.out.println("请输入密码");
        while (true) {
            String sc = scanner.next();
            if (sc.equals(word)) {
                System.out.println("登录成功.");
                break;
            } else {
                count++;
                if(count < 3){
                    System.out.println("密码错误,请重新输入");
                }
            }
            if (count == 3) {
                System.out.println("输入错误3次,请稍后再试.");
                break;
            }
        }
        return word;
    }
}
