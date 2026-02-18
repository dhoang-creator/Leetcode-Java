public int maxArea(int[] height) {
    // O(1)
    int max = 0; // O(1)

    for (int i = 0; i < height.length; i++) {
        // runs n times -> O(n)
        for (int j = i + 1; j < height.length; j++) {
            // runs (n - i - 1) times -> O(n)

            int h = Math.min(height[i], height[j]); // O(1)
            int w = j - i; // O(1)
            int area = h * w; // O(1)

            max = Math.max(max, area); // O(1)
        }
    }

    return max; // O(1)
}
