package thread_review;
//单例模式
//1. 饿汉模式
public class Demo05 {
    static class Singleton{
        private Singleton(){

        }
        private static Singleton instance = new Singleton();

        public static Singleton getInstance(){
            return instance;
        }

    }
}
