class Solution {
    int dp[];

    public int solve(int[] nums, int n) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = Math.max(nums[n - 1] + solve(nums, n - 2), solve(nums, n - 1));
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        int[] nums1 = Arrays.copyOfRange(nums, 0, n - 1);
        solve(nums1, n - 1);
        int sol1 = dp[n - 1];
        int[] nums2 = Arrays.copyOfRange(nums, 1, n);
        Arrays.fill(dp, -1);
        solve(nums2, n - 1);
        int sol2 = dp[n - 1];
        return Math.max(sol1, sol2);
    }
}