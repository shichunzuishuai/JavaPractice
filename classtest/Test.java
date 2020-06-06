package classtest;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        //普通的继承关系创建对象
//        Cat cat = new Cat("小黑");
//        cat.eat("骨头");
//        Bird bird = new Bird("小红");
//        bird.eat("虫子");
//        bird.fly();

        //此时 bird 是一个父类 (Animal) 的引用, 指向一个子类 (Bird) 的实例
        //  这种写法称为 向上转型
//        Animal bird = new Bird("小红");
//        feed(bird);
//        Animal animal = findMyAnimal();
//        System.out.println(animal.name);
//        animal.eat("谷子");

        //多态的测试
//        Shape shape1 = new Cycle();
//        Shape shape2 = new Rect();
//        Shape shape3 = new Flower();
//        showShape(shape1);
//        showShape(shape2);
//        showShape(shape3);

        //向下转型
//        Animal animal = new Bird("小红");
//        animal.eat("虫子");
        //此时是Animal类型,不能调用fly方法,
        //如果要调用fly方法,就要向下转型
        //animal.fly();
//        Bird bird =(Bird) animal;
//        bird.fly();
        //此时可以调用fly方法,但是不太安全,有可能出问题,例如
//        Animal animal = new Cat("小黑");
//        Bird bird = (Bird)animal;
//        bird.fly();
        //此时上面转型运行就会出现异常,应该用instanceof来判断一下
//        Animal animal = new Cat("小黑");
//        if(animal instanceof Bird){
//            Bird bird = (Bird) animal;
//            bird.fly();
//        }

        //抽象类
        //1.抽象类不能直接实例化,比如Shape类是抽象的,下列操作是错误的
        //Shape shape  = new Shape();
        //2.抽象方法不能是private的
        //3.抽象类中不一定都是抽象方法,也可以是其他非抽象的方法,字段
        //和普通方法顾恩泽一样,可以被重写,可以被子类直接调用
//        Shape shape = new Rect();
//        shape.func();

        //接口
//        IShape shape = new Cycle();
//        shape.draw();
        //可以实现多个接口
//        Duck duck = new Duck("鸭子");
//        duck.running();
//        duck.fly();
//        duck.swimming();
        Student[] students = new Student[]{
                new Student("张三",30),
                new Student("李四",60),
                new Student("龙世春",100)
        };
        Arrays.sort(students);
        System.out.println(Arrays.toString(students));
    }

    //方法传参
    //public static void feed(Animal animal){
        //animal.eat("虫子");
    //}
    //方法返回
//    public static Animal findMyAnimal(){
//        Bird bird = new Bird("小红");
//        return bird;
//    }
    //打印单个图形
//   public static void showShape(Shape shape){
//        shape.draw();
//   }

 }





















