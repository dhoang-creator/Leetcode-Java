/*
    Subsets
    - Given an integer array nums of unique elements, return all possible subsets (the power set)
    - The solution set must not contain duplicate subsets. Return the solution in any order

    Input: nums = [1,2,3]
    Output: [[], [1], [2], [1,2], [3], [1,3], [2,3], [1,2,3]]
 */
class Solution {
    List<List<Integer>> list = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        List<Integer> current = new ArrayList<>();
        backtrack(0, current);
        return list;
    }

    public void backtrack(int index, List<Integer> current) {
        // recursive case
        if (index == nums.length) {
            list.add(new ArrayList<>(current));
            return ;
        }

        current.add(nums[index]);
        backtrack(index+1, current);
        current.remove(current.size()-1);
        backtrack(index+1, current);
    }
}