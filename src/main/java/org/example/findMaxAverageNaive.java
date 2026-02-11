public class MaximumAverageSubarrayNaive {

    // I don't fully understand how this translates to computing the average sum of a sliding window and checking if it is greater than the last window
    public static double findMaxAverage(int[] nums, int k) {
        double maxAverage = Double.NEGATIVE_INFINITY;

        for (int i = 0; i <= nums.length - k; i++) {

            int sum = 0;

            // compute sum of subarray of size k starting at i
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }

            double average = (double) sum / k;
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }
}