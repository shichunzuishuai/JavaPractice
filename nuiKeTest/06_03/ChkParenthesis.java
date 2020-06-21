import java.util.Stack;

public class ChkParenthesis {
    public static boolean chkParenthesis(String A ,int n){
        Stack<Character> stack = new Stack<>();
        for(int i = 0 ; i < n; i++){
            char a = A.charAt(i);
            if(a == '('){
                stack.push(a);
            }else if(a == ')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else {
                    return false;
                }
            }else {
                return false;
            }
        }
        if(stack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "())())";
        System.out.println(chkParenthesis(str,6));
    }

    public static boolean chkParenthesis2(String A ,int n){
        int l = 0;
        for(int i = 0; i < n; i++){
            char a = A.charAt(i);
            if(a == '('){
                l++;
            }else if(a == ')'){
                if(l >0){
                    l--;
                }else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        return l == 0;
    }
}
