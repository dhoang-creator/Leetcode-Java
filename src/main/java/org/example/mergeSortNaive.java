public static void merge(int[] nums1, int m, int[] nums2, int n) {
    // Step 1: Copy nums2 into nums1
    for (int i = 0; i < n; i++) {
        // O(n)
        num1[m + i] = nums2[i];
    }

    // Step 2: Sort nums1
    Arrays.sort(nums1); // O(m + n) log(m + n)
}

// Test example
public static void main(String[] args) {
    int[] nums1 = { 1, 2, 3, 0, 0, 0 };
    int m = 3;
    int[] nums2 = { 2, 5, 6 };
    int n = 3;

    merge(nums1, m, nums2, n);

    System.out.println(Arrays.toString(nums1));
    // Output: [1,2,2,3,5,6]
}
