package classtest;

public class Bird extends Animal {
    public Bird(String name){
        super(name);
    }
    public void fly(){
        //对于父类的protected字段,子类可以正常访问
        System.out.println(this.name + "正在飞");
    }
}
