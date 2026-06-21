class Solution {
    int[] dp;

    public int solve(int[] nums, int n) {
        if (n <= 0) {
            return 0;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = Math.max(nums[n - 1] + solve(nums, n - 2), solve(nums, n - 1));
        return dp[n];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        dp = new int[n + 1];
        Arrays.fill(dp, -1);
        solve(nums, n);
        return dp[n];
    }
}