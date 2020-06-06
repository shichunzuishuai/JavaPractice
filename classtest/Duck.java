package classtest;

public class Duck extends Animal implements IRunning,ISwimming,IFly{
    public Duck(String name) {
        super(name);
    }

    @Override
    public void running() {
        System.out.println(this.name + "正在跑");
    }

    @Override
    public void fly() {
        System.out.println(this.name + " 正在飞");
    }

    @Override
    public void swimming() {
        System.out.println(this.name + "正在游泳");
    }
}
