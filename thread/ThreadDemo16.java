package thread;
//测试synchronized给不同对象加锁的作用
public class ThreadDemo16 {
    static class Test{
       private Object o = new Object();
        public void method(){
            synchronized (o){//如果synchronized()中的是this,相当于给下面的实例化t加锁,如果是o,则是给O加锁
                System.out.println("hehe");
            }
        }
    }

    public static void main(String[] args) {
        Test t = new Test();
        t.method();

    }

}
