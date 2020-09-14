/**
 53. 最大子序和

 分享
 切换为英文
 关注
 反馈
 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

 示例:

 输入: [-2,1,-3,4,-1,2,1,-5,4]
 输出: 6
 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

 */
public class MaxSubArray {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int  sum= 0;
        for(int i = 0; i < nums.length - 1; i++){
            sum += nums[i];
            if(sum > maxSum){
                maxSum = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxSum;
    }

//    public int strStr(String haystack, String needle) {
//        int ret = haystack.indexOf(needle);
//        return ret;
//    }
}
