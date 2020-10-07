package demo02;

public class UserServiceProxy implements UserService{
    private UserService userService;


    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    public void add() {
        log("增加");
        System.out.println("增加了一个用户");
    }

    public void del() {
        log("删除");
        System.out.println("删除了一个用户");
    }

    public void update() {
        log("更新");
        System.out.println("修改了一个用户");
    }

    public void query() {
        log("查找");
        System.out.println("查找了一个用户");
    }
    public void log(String msg){
        System.out.println("[log]:" + msg);
    }
}
