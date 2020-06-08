package thread;

public class ThreadDemo3 {
    //Runnable 本质上就是描述了一段要执行的任务代码是啥
    static class MyRunnable implements Runnable{
        @Override
        public void run() {
            System.out.println("我是一个新线程");
        }
    }
    public static void main(String[] args) {
        //1.显示继承Thread类
        //2.通过创建匿名内部类的方式继承Thread.
//        Thread t = new Thread(){
//            @Override
//            public void run() {
//
//            }
//        };
//        t.start();
        //3/显示创建一个类,实现Runnable接口,然后把这个Runnable的实例关联到Thread实例上
//        Thread t = new Thread(new MyRunnable());
//        t.start();
         //4.通过匿名内部类实现Runnable接口
//        Runnable r = new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("我是一个新线程");
//            }
//        };
//        Thread t = new Thread(r);
//        t.start();
        //5.通过lambda表达式来指定线程执行的内容
       Thread t = new Thread(() -> {
           System.out.println("我是一个新线程");
       });
       t.start();
    }

}
