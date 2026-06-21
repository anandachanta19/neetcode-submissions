class Solution {
    public int trap(int[] height) {
        int waterFilled = 0;
        int left = 0;
        int n = height.length;
        int right = n - 1;
        int leftMax = 0;
        int rightMax = 0;
        while (left < right) {
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax) {
                waterFilled += leftMax - height[left];
                left++;
            } else {
                waterFilled += rightMax - height[right];
                right--;
            }
        }
        return waterFilled;
    }
}
