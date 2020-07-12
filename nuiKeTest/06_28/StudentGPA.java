/**
 * 链接：https://www.nowcoder.com/questionTerminal/a0c09a7e0da04e728810a8aca7226b7b
 * 来源：牛客网
 *
 * 北京大学对本科生的成绩施行平均学分绩点制（GPA）。既将学生的实际考分根据不同的学科的不同学分按一定的公式进行计算。 公式如下： 实际成绩 绩点 90——100 4.0 85——89 3.7 82——84 3.3 78——81 3.0 75——77 2.7 72——74 2.3 68——71 2.0 64——67 1.5 60——63 1.0 60以下 0 1．一门课程的学分绩点=该课绩点*该课学分 2．总评绩点=所有学科绩点之和/所有课程学分之和 现要求你编写程序求出某人A的总评绩点（GPA）。
 *
 * 输入描述:
 *
 * 第一行 总的课程数n（n<10）；
 * 第二行 相应课程的学分（两个学分间用空格隔开）；
 * 第三行 对应课程的实际得分；
 * 此处输入的所有数字均为整数。
 *
 *
 * 输出描述:
 *
 * 输出有一行，总评绩点，精确到小数点后2位小数。（printf("%.2f",GPA);）
 * 示例1
 * 输入
 *
 * 5
 * 4 3 4 2 3
 * 91 88 72 69 56
 * 输出
 *
 * 2.52
 */

import java.util.Scanner;

public class StudentGPA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int[] arr1 = new int[n];
            for (int i = 0; i < n; i++) {
                arr1[i] = scanner.nextInt();
            }
            int[] arr2 = new int[n];
            for (int i = 0; i < n; i++) {
                arr2[i] = scanner.nextInt();
            }
            double res = calculate(arr1,arr2);
            System.out.println(res);
        }
    }
    public static double calculate(int[] arr2,int[] arr1){
        //arr1表示该课的实际分数
        //arr2表示该课的学分
        //arr3表示该课的实际成绩绩点
//        System.out.println(Arrays.toString(arr1));
//        System.out.println(Arrays.toString(arr2));
        double[] arr3 = new double[arr1.length];
        for (int i = 0; i < arr1.length; i++) {
            if(arr1[i] >= 90 && arr1[i] <= 100){
                arr3[i] = 4.0;
            }else if(arr1[i] >= 85 && arr1[i] <= 89){
                arr3[i] = 3.7;
            }else if(arr1[i] >= 82 && arr1[i] <= 84){
                arr3[i] = 3.3;
            }else if(arr1[i] >= 78 && arr1[i] <= 81){
                arr3[i] = 3.0;
            }else if(arr1[i] >= 75 && arr1[i] <= 77){
                arr3[i] = 2.7;
            }else if(arr1[i] >= 72 && arr1[i] <= 74){
                arr3[i] = 2.3;
            }else if(arr1[i] >= 68 && arr1[i] <= 71){
                arr3[i] = 2.0;
            }else if(arr1[i] >= 64 && arr1[i] <= 67){
                arr3[i] = 1.5;
            }else if(arr1[i] >= 60 && arr1[i] <= 63){
                arr3[i] = 1.0;
            }else {
                arr3[i] = 0;
            }
        }
//        System.out.println(Arrays.toString(arr3));
        double score = 0;
        for (int i = 0; i < arr1.length; i++) {
            score += (arr2[i] * arr3[i]);
        }
//        System.out.println(score);
        double courseScore = 0;
        for (int i = 0; i < arr2.length; i++) {
            courseScore += arr2[i];
        }
//        System.out.println(courseScore);
        double result1 = score / courseScore;
        double result2 = Double.valueOf(String.format("%.2f",result1));
        return result2;

    }
}
