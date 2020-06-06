package classtest;

public class Fish extends Animal implements IRunning  {

    public Fish(String name) {
        super(name);
    }

    @Override
    public void running() {
        System.out.println(this.name + "正在游");
    }
}
