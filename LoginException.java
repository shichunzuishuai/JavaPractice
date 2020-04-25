package exceptionPractice;
import java.util.Scanner;
public class LoginException {
    public static String name = "龙世春";
    public static String answer = "long123456";
    public static void main(String[] args) {
        loginException();
    }
    public static void logName (String name){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入姓名");
        String name1 = scanner.nextLine();
        if(name1.equals(name)){
        }else if(logAnswer(answer)){
            throw new ArithmeticException("密码错误");
        }
    }
    public static Boolean logAnswer(String answer){
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入密码");
        String answer1 = scanner.nextLine();
        if(answer1.equals(answer)){
            return true;
        }else {
            throw new ArithmeticException("密码错误");
        }
    }
    public static void loginException(){
        logName(name);
        Boolean l2 = logAnswer(answer);
        if(l2 == true){
            System.out.println("登录成功");
        }
    }
}
