public class Hannuota {
    public static void main(String[] args) {
        hannuo(1,'A','B','C');
        System.out.println();
        hannuo(2,'A','B','C');
        System.out.println();
        hannuo(3,'A','B','C');
        System.out.println();
        hannuo(10,'A','B','C');
    }
    public static void move( char pos1,char pos3){
        System.out.print(pos1 + "-->" + pos3 + " ");
    }
    public static void hannuo(int n,char pos1,char pos2,char pos3){
        if(n == 1){
            move(pos1,pos3);
            return;
        }
        hannuo(n - 1,pos1,pos3,pos2);
        move(pos1,pos3);
        hannuo(n -1,pos2,pos1,pos3);
    }
}
