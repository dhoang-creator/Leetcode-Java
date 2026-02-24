/*
    The next greater element of some element x in an array is the first greater element that is to the right of x in the same array.

    You are given two distinct 0-indexed integer arrays nums1 and nums2. where nums1 is a subset of nums2

    For each 0 <= i < nums1.length, find the index j such that nums1[i] == nums2[j] and determine the next greater element of nums2[j] in nums2.
    If there is no next greater element, then the answer for this query is -1

    Return an array ans of length nums1.length such that ans[i] is the next greate element as described above

    Input: nums1 = [4, 1, 2], nums2 = [1, 3, 4, 2]
    Output: [-1, 3, -1]
    Explanation: The next greater element for each value of nums1 is as follows:
    - 4 is underlined in nums2 = [1, 3, 4, 2]. There is no next greater element, so the answer is -1.
    - 1 is underlined in nums2 = [1, 3, 4, 2]. The next greater element is 3.
    - 2 is underlined in nums2 = [1, 3, 4, 2]. There is no next greater element, so the answer is -1.
 */
/**
 * So you just need to undestand that monotonic stack/queue, you start with the bottom/first index and push it into the stack
 * and work your way up the stack in either popping and/or pushing the value into the stack if it is greater than the number currently in their
 * So ... push first element, is second element greater than first, if so pop first, and push second etc etc, iff an element is smaller than another element in the array, do not pop and just push
 */
import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // Time Complexity: O(n)
        // Each element in nums2 is pushed once and popped once from the stack.
        // Space Complexity: O(n) for stack + hashMap

        Map<Integer, Integer> nextGreaterMap = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        // Build next greater mapping for nums2
        for (int num : nums2) {
            // While current number is greater than stack top,
            // current number is the next greater element for stack top
            while (!stack.isEmpty() && num > stack.peek()) {
                int smaller = stack.pop();
                nextGreaterMap.put(smaller, num);
            }
            stack.push(num);
        }

        // Remaining elements in stack have no next greater
        while (!stack.isEmpty()) {
            nextGreaterMap.put(stack.pop(), -1);
        }

        // Build result for nums1 using the precomputed map
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}