package demo01;

public class Proxy implements Rent {
    Host host = new Host();
    public void rent() {
        seeHose();
        host.rent();
        heTong();
        fare();
    }

    public Proxy() {
    }

    public Proxy(Host host) {
        this.host = host;
    }
    public void seeHose(){
        System.out.println("看房子");
    }
    public void heTong(){
        System.out.println("签租赁合同");
    }
    public void fare(){
        System.out.println("收中介费");
    }
}
