import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static <Hello> void main(String[] args) {
        //获取spring 的上下文对象
        ApplicationContext context = new
                ClassPathXmlApplicationContext("beans.xml");
        //我们的对象 都在spring中的管理了,我们要使用,直接去里面取出就行了
        Hello hello = (Hello) context.getBean("hello");
        System.out.println(hello.toString());
    }

}
