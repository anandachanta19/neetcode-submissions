class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        Set<Integer> unique = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (unique.contains(nums[i])) {
                return true;
            }
            unique.add(nums[i]);
        }
        return false;
    }
}