package BiShi;

public class Ribbte {
    public int couples (int month) {
        // write code here
        if(month == 1){
            return 1;
        }
        if(month == 2){
            return 1;
        }
        return couples(month - 2) + couples(month - 1);
    }
}
