package demo02;

public class UserServiceImpl implements UserService {
    public void add() {
        System.out.println("增加了一个用户");
    }

    public void del() {
        System.out.println("删除了一个用户");
    }

    public void update() {
        System.out.println("修改了一个用户");

    }

    public void query() {
        System.out.println("查找了一个用户");

    }
}
