public class Printer {
    public int[] clockwisePrint(int[][] mat, int n, int m) {
        // write code here
        int startX  = 0;
        int endX = m - 1;
        int startY = 0;
        int endY = n - 1;
        int[] arr = new int[n * m];
        int a = 0;
        while (startX <= endX && startY <= endY){
            //先从左往右打印
            if(startX <= endX){
                for(int i = startX; i <= endX; i++){
                    arr[a++] = mat[startY][i];
                }
            }
            //从上往下打印
            if(startY <= endY){
                for(int i = startY + 1; i <= endY; i++){
                    arr[a++] = mat[i][endX];
                }
            }
            //从右往左打印
            if(endX > startX && endY > startY ){
                for(int i = endX - 1; i >= startX; i--){
                    arr[a++] = mat[endY][i];
                }
            }
            //从下往上打印
            if(endY > startY && endX > startX){
                for(int i = endY - 1; i>=startY + 1; i--){
                    arr[a++] = mat[i][startX];
                }
            }
            startX++;
            endX--;
            startY++;
            endY--;
        }
        return arr;
    }
}
