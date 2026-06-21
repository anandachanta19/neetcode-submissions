class Solution {
    public int longestConsecutive(int[] nums) {
        int best = 0;
        HashSet<Integer> numberSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            numberSet.add(nums[i]);
        }
        // Now checking elements in HashSet
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (!numberSet.contains(x - 1)) {
                int y = x + 1;
                while (numberSet.contains(y)) {
                    y += 1;
                }
                best = Math.max(y - x, best);
            }
        }
        return best;
    }
}
