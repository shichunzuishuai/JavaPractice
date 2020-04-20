package yanghui_triangular;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class YangHuiTriangular {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        List<List<Integer>> ret = generate(s);
        System.out.println(ret);

    }
    public  static List<List<Integer>> generate(int numRows){
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0){
            return result;
        }
        //处理第一行
        ArrayList<Integer> firstLine = new ArrayList<>();
        firstLine.add(1);
        result.add(firstLine);
        if(numRows == 1){
            return result;
        }
        ArrayList<Integer> secondLine = new ArrayList<>();
        secondLine.add(1);
        secondLine.add(1);
        result.add(secondLine);
        if(numRows == 2){
            return result;
        }
        //第i行的相关规律
        //1.第一列和最后一列都是一
        //2.有多少航就有多少列
        //3.(i,j) = (i - 1,j - 1)+(i - 1,j);
        for(int row = 3; row <= numRows; row++){
            List<Integer> preLine = result.get(row - 1 - 1);
            List<Integer> curLine = new ArrayList<>();
            //当前的第一行是一
            curLine.add(1);
            for(int col = 2;col < row;col++){
                //要计算col列的值,需要知道上一行的col -1列和col列
                // 因为col是从1开始算的,所以去下标还要-1;
                int tmp1 = preLine.get(col -1 -1);
                int tmp2 = preLine.get(col - 1);
                curLine.add(tmp1 + tmp2);
            }
            //最后一行也是1
            curLine.add(1);
            result.add(curLine);
        }
        return result;
    }

}
