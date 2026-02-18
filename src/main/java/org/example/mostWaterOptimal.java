public int maxArea(int[] height) {
    // O(1)
    int left = 0; // O(1)
    int right = height.length - 1; // O(1)
    int max = 0; // 0(1)

    while (left < right) {
        // runs at most (n - 1) times -> O(n)
        int h = Math.min(height[left], height[right]); // O(1)
        int w = right - left; // O(1)
        int area = h * w; // O(1)

        max = Math.max(max, area); // O(1)

        if (height[left] < height[right]) {
            // O(1)
            left++; // point moves right -> total O(n) moves
        } else {
            right--; // pointer moves left -> total O(n) moves
        }
    }
    return max; // O(1)
}

// Minimal inline test suite
public static void main(String[] args) {
    Solution sol = new Solution();

    runTest(sol, new int[]{1,8,6,2,5,4,8,3,7}, 49); // classic example
    runTest(sol, new int[]{1,1}, 1); // smallest valid input
    runTest(sol, new int[]{4,3,2,1,4}, 16); // symmetric heights
    runTest(sol, new int[]{1,2,1}, 2); // simple palindrome-like
    runTest(sol, new int[]{5,5,5,5}, 15) // all equal heights
}

private static void runTest(Solution sol, int[] input, int expected) {
    int result = sol.maxArea(input);
    System.out.println(
        "Input: " + java.util.Arrays.toString(input) +
            " | Expected: " + expected +
            " | Got: " + result +
            (result == expected ? "Good" : "Bad")
    );
}
