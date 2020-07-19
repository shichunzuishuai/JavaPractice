/**
 * 链接：https://www.nowcoder.com/questionTerminal/4b733a850c364c32b368555c8c2ec96b
 * 来源：牛客网
 * 输入球的中心点和球上某一点的坐标，计算球的半径和体积
 * 输入描述:
 * 球的中心点和球上某一点的坐标，以如下形式输入：x0 y0 z0 x1 y1 z1
 * 输出描述:
 * 输入可能有多组，对于每组输入，输出球的半径和体积，并且结果保留三位小数
 * 为避免精度问题，PI值请使用arccos(-1)。
 * 示例1
 * 输入
 * 0 0 0 1 1 1
 * 输出
 * 1.732 21.766
 */

import java.util.Scanner;
public class Ball {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            double x0 = scanner.nextDouble();
            double y0 = scanner.nextDouble();
            double z0 = scanner.nextDouble();
            double x1 = scanner.nextDouble();
            double y1 = scanner.nextDouble();
            double z1 = scanner.nextDouble();
            Double res = getRadius(x0,y0,z0,x1,y1,z1);
            System.out.printf("%.3f ",res);
            getVolume(x0,y0,z0,x1,y1,z1);
        }
    }
    public static double getRadius(double x0,double y0,double z0,double x1,double y1,double z1){
        double radius = 0;
        double radiusSquare = 0;
        radiusSquare = (x1-x0)*(x1-x0)+(y1-y0)*(y1-y0)+(z1-z0)*(z1-z0);
        radius = Math.sqrt(radiusSquare);
        return radius;
    }
    public static void getVolume(double x0,double y0,double z0,double x1,double y1,double z1){
        double volume=0;
        volume=4*Math.acos(-1)*Math.pow(getRadius(x0,y0,z0,x1,y1,z1), 3)/3;
        System.out.printf("%.3f\n",volume);
    }
}
