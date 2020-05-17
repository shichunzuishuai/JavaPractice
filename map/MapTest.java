package map;

import java.util.HashMap;
import java.util.Map;

class Student{
    public String name;
    public int age;
    public String grade;
    public String school;

    public Student(String name, int age, String grade, String school) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", grade='" + grade + '\'' +
                ", school='" + school + '\'' +
                '}';
    }
}

public class MapTest {
    public static void main(String[] args) {
        Student st1 = new Student("张三",18,"大三","西宫院");
        Student st2 = new Student("李四",20,"大四","西宫院");
        Student st3 = new Student("王五",13,"大一","西宫院");
        Student st4 = new Student("马六",22,"大二","西宫院");
        Map<String,Student> studentMap = new HashMap<>();
        studentMap.put(st1.name,st1);
        studentMap.put(st2.name,st2);
        studentMap.put(st3.name,st3);
        studentMap.put(st4.name,st4);
        String name = "张三";
        Student student = studentMap.get(name);
        System.out.println(student);
        Map<Integer,Student> studentMap2 = new HashMap<>();
        studentMap2.put(st1.age,st1);
        studentMap2.put(st2.age,st2);
        studentMap2.put(st3.age,st3);
        studentMap2.put(st4.age,st4);
        Integer age = 20;
        Student student2 = studentMap2.get(age);
        System.out.println(student2);
        //遍历一个Map
        //Entry条目,也就是一个键值对
        for(Map.Entry<String , Student> entry : studentMap.entrySet()){
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }


    }
}

