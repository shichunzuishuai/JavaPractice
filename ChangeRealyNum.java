/**
 * 用类的方法交换两个数的值
 */
public class ChangeRealyNum {
    public static void main(String[] args) {
        Change change1 = new Change();
        change1.setNum1(10);
        Change change2 = new Change();
        change2.setNum1(20);
        System.out.println( change1.getNum1() + " " + change2.getNum1());
        swap(change1,change2);
        System.out.println(change1.getNum1() + " " + change2.getNum1());
    }
    public static void swap(Change change1, Change change2){
        int tmp = change1.getNum1();
        change1.setNum1(change2.getNum1());
        change2.setNum1(tmp);

    }
}
class Change{
    private int num1;
    public int getNum1() {
        return num1;
    }
    public void setNum1(int num1) {
        this.num1 = num1;
    }
}