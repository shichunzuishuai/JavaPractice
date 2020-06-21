import java.util.Scanner;

public class LongestNumString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            String str = scanner.nextLine();
            longestNumString(str);
        }
    }
    public static void longestNumString(String str){
        int count = 0;
        int end = 0;
        int max = 0;
        for(int i  = 0; i < str.length(); i++){
            char res = str.charAt(i);
            if(res >= '0' && res <= '9'){
                count++;
                if(count > max){
                    max = count;
                    end = i;
                }
            }
            else {
                count = 0;
            }
        }
        System.out.println(str.substring(end - max +1, end + 1));
    }
}

