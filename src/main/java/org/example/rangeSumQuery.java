package org.example;

/**
 * Given an integer array nums, handle multiple queries of the following type:
 * 1. Calculate the sum of the elements of nums between indices left and right inclusive where left <= right
 * Implement the NumArray class
 * - NumArray(int[] nums) initialises the object with the integer array nums
 * - int sumRange(int left, int right) returns the sum of th elements of nums between indices left and right inclusive (i.e. num[left] + nums[left + 1] + ... + nums[right])
 * 
 * Example 1:
 * Input 
 * ["NumArray", "sumRange", "sumRange", "sumRange"]
 * [[[-1, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]]
 * Output
 * [null, 1 -1, -3]
 * 
 * Explanation
 * NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]);
 * numArray.sumRange(0, 2); // return (-2) + 0 + 3 = 1
 * numArray.sumRange(2, 5); // return 3 + (-5) + 2 + (-1) = -1
 * numArray.sumRange(0, 5); // return (-2) + 0 + 3 + (-5) + 2 + (-1) = -3
 */

class rangeSumQuery { 
    int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i-1] + nums[i];
        }
    }

    public int sumRange(int left, int right) {
        if (left == 0) {
            return prefix[right];
        }
        return prefix[right] - prefix[left - 1];
    }
}
