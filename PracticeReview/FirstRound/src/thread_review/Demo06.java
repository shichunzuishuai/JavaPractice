package thread_review;
// 单例模式
//2. 懒汉模式
//类加载的时候没有立刻实例化
public class Demo06 {
    static class Singleton{
        private Singleton (){

        }
        private static volatile Singleton instance = null;
        private static Singleton getInstance(){
            if (instance == null) {
                synchronized (Singleton.class) {
                        if(instance == null){
                        return new Singleton();
                    }
                }
            }
            return instance;
        }

    }
}
