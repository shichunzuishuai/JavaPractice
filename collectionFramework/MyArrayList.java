package collectionFramework;

import java.util.Objects;

class Student{
    public String name;
    public String sex;
}

public class MyArrayList<E> {
    //下面这种new E[100]是不行的
    //private E[] array = new E[100];
    private E[] array =(E[]) new Object[100];
    private int size;
    void add(E o){
        array[size] = o;
        size++;
    }
    E get(int index){
        return array[index];
    }

    public static void main(String[] args) {
//        MyArrayList myArrayList = new MyArrayList();
//        myArrayList.add("我");
//        myArrayList.add("爱");
//        myArrayList.add("java");
//        String str = (String)myArrayList.get(0);
//        System.out.println(str);
//        MyArrayList myArrayList2 = new MyArrayList();
//        myArrayList2.add(new Student());
//        myArrayList2.add(new Student());
//        myArrayList2.add(new Student());
//        String str2 = (String)myArrayList2.get(0);
        MyArrayList<String> myArrayList = new MyArrayList();
        myArrayList.add("hehe");
        String s = myArrayList.get(0);
        MyArrayList<Student> myArrayList2 = new MyArrayList<>();
        myArrayList2.add(new Student());
        Student student = myArrayList2.get(0);
    }
}
