import java.util.Scanner;

/**
 *在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，
 * 判断数组中是否含有该整数。
 */
public class SearchNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr = {{1,2,3,4},{2,3,4,5},{3,4,5,6}};
        int a = scanner.nextInt();
        isExist(arr,a);
    }
    public static boolean isExist(int[][] array,int target){
        int i = 0;
        int j = array[0].length - 1;
        while (i < array.length && j >= 0){
            if(target < array[i][j]){
                j--;
            }else if(target >array[i][j]){
                i++;
            }else {
                return true;
            }
        }
        return false;
    }
}
