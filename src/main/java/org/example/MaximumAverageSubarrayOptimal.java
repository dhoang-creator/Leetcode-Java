public class MaximumAverageSubarrayOptimal {

    public static double findMaxAverage(int[] nums, int k) {

        int n = nums.length;

        // Step 1: Compute sum of first window
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxSum = sum;

        // Step 2: Slide the window
        for (int right = k; right < n; right++) {
            sum += nums[right];             // add new element
            sum -= nums[right - k];         // remove element leaving window
            maxSum = Math.max(maxSum, sum)
        }

        return (double) maxSum / k;
    }
}