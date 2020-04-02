public class CalculatorDemo {
    public static void main(String[] args) {
        Calculator calculator = new Calculator(10,20);
        System.out.println(calculator.div());
    }
}
class Calculator{
    public int num1;
    public int num2;
    public Calculator(){

    }
    public Calculator(int num1, int num2){
        this.num1 = num1;
        this.num2 = num2;
    }
    public int add(){
        return num1 + num2;
    }
    public int res(){
        return num1 - num2;
    }
    public int mul(){
        return num1 * num2;
    }
    public double div(){
        return (double) num1 / num2;
    }

}
