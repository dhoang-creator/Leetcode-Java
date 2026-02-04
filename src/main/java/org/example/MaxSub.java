// the below option is the nativist option
// class Solution {

//     public int maxSubArray(int[] nums) {
//         int minSum = Integer.MIN_VALUE;

//         for (num : nums) {

//             if
//         }
//     }
// }
class Solution {

    public int maxSubArray(int[] nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
