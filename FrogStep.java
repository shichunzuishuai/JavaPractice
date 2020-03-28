public class FrogStep {
    public static void main(String[] args) {
        int res = JumpFloor(5);
        System.out.println(res);
    }
    public static int JumpFloor(int target) {
        //青蛙跳台阶，一次可以跳上1级台阶，也可以跳上2级台阶
        if (target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }
        //一个n级台阶，第一次跳有两种选择，
        //一是第一次跳1级，那么跳法数目等于后面剩下的n-1级台阶的跳法数目
        //二是第一次跳2级，那么跳法数目等于后面剩下的n-2级台阶的跳法数目
        //一个n级台阶总的跳法数目为f(n-1) + f(n-2),相当于斐波那契数列
        int first = 1;
        int last = 2;
        int sum = 0;
        for (int i = 3; i <= target; i++) {
            sum = first + last;
            //将上次的last作为下一次的first
            first = last;
            //将上次的结果作为last
            last = sum;
        }
        return sum;
    }
}