import chun.Duck2;
import chun.Duck3;
import chun.DuckShop;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new
                ClassPathXmlApplicationContext("applications.xml");

        //通过Bean的名称来获取对象,就是xml中的id
        String bit = (String) context.getBean("bit");
      //  String bit2 = (String) context.getBean("java.lang.String#0");
        System.out.println(bit);
     //   System.out.println(bit2);
        //通过类型获取bean对象,如果有多个就会报错
        //只支持一个该类型的对象
      //  context.getBean(String.class);

     //   Duck d1 = (Duck)context.getBean("d1");
     //   System.out.println(d1);
        Duck2 d2 = (Duck2)context.getBean("d2");
        System.out.println(d2);

        Duck3 dk3 = (Duck3)context.getBean("d31");
        System.out.println(dk3);

        DuckShop dks = (DuckShop)context.getBean("shop");
        System.out.println(dks);
    }
}