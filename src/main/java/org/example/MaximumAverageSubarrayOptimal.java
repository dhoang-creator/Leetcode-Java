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

    public static void main(String[] args) {

        test(new int[]{1, 12, -5, -6, 50, 3}, 4, 12.75);
        test(new int[]{5}, 1, 5.0);
        test(new int[]{0, 0, 0, 0}, 2, 0.0);
        test(new int[]{-1, -12, -5, -6, -50, -3}, 2, -5.5);
        test(new int[]{3, 3, 3, 3}, 4, 3.0)
    }

    private static void test(int[] nums, int k, double expected) {
        double result = findMaxAverage(nums, k);

        if (Math.abs(result - expected) < 0.00001) {
            System.out.println("PASS");
        } else {
            System.out.println("FAIL | Expected: " + expect + " | Got: " + result);
        }
    }
}