public int minSubArrayLen(int target, int[] nums) {
    int n = nums.length;
    int minLength = Integer.MAX_VALUE;

    for (int start = 0; start < n; start++) {
        int sum = 0;

        for (int end = start; end < n; end++) {
            sum += nums[end];

            if (sum >= target) {
                minLength = Math.min(minLength, end - start + 1);
                break; // no need to continue expanding
            }
        }
    }

    return minLength == Integer.MAX_VALUE ? 0 : minLength;
}