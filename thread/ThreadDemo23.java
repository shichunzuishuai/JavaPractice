package thread;
//单例模式:懒汉模式 Singleton 类被加载的时候, 不会立刻实例化.
//  等到第一次使用这个实例的时候再实例化.
//实现3步:   1.使用synchronized加锁
//          2.为保证效率,使用双重if
//          3.为保证避免内存可见性,使用volatile
public class ThreadDemo23 {
    static class Singleton{
        private Singleton(){

        }
        private  volatile static Singleton instance = null;
        private Singleton getInstance(){
            if (instance == null) {
                synchronized (Singleton.class) {
                    if(instance == null){
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }

    public static void main(String[] args) {

    }
}
