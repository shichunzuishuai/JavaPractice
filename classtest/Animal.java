package classtest;

public class Animal {
    //public String name;
    //对于类的调用者来说, protected 修饰的字段和方法是不能访问的
    //对于类的 子类 和 同一个包的其他类 来说, protected 修饰的字段和方法是可以访问
    //如果不在同一个包下,则不能访问
    //如果类被final修饰,表示这个类不能被继承下去
    protected String name;
    public Animal(String name){
        this.name = name;
    }
    public void eat(String food){
        System.out.println("我是一只动物");
        System.out.println(this.name + "正在吃" + food);
    }
}
