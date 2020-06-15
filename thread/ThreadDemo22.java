package thread;

public class ThreadDemo22 {
    // 先创建一个表示单例的类
    // 我们就要求 Singleton 这个类只能有一个实例.
    // 单身狗. single dog
    // 饿汉模式的单例实现, "饿" 指的是, 只要类被加载, 实例就会立刻创建. (实例创建时机比较早)
    static class Singleton{
        //把构造方法设置为私有,该类外部就不能new类的实例了
        private Singleton(){

        }
        private static Singleton instance = new Singleton();
        static Singleton getInstance(){
            return instance;
        }
    }

    public static void main(String[] args) {
        Singleton t1 = Singleton.getInstance();
        Singleton t2 = Singleton.getInstance();
        System.out.println(t1 == t2);
    }
}
