package classtest;

public class Cat extends Animal implements IRunning{
    public Cat(String name){
        super(name);
    }
    //方法重写
    @Override
    public void eat(String food){
        System.out.println("猫吃鱼");
    }

    @Override
    public void running() {
        System.out.println(this.name + "正在跑");
    }
}
