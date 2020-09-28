package BiShi;

public class TimeGame {
    public int[] getTriggerTime (int[][] increase, int[][] requirements) {
        // write code here
        int lenA = increase.length;//行
        int lenC = requirements.length;//行
        int[] ret = new int[lenC];
        int C = 0;
        int R = 0;
        int H = 0;
        for (int i = 0; i < lenA; i++) {
            C += increase[i][0];
            R += increase[i][1];
            H += increase[i][2];
            for (int j = 0; j < lenC; j++) {
                if( C >= requirements[j][0] && R >= requirements[i][1]
                && H >= requirements[i][2]){
                    ret[j] = i + 1;
                }
            }
        }
        for(int i = 0; i < ret.length; i++){
            if(ret[i] == 0){
                ret[i] = -1;
            }
        }
        return ret;
    }
}
