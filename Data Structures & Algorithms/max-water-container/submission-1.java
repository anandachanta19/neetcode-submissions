class Solution {
    public int maxArea(int[] height) {
        int max_area = Integer.MIN_VALUE;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int min_height = Math.min(height[right], height[left]);
            int current_area = (right - left) * min_height;
            if (current_area > max_area) {
                max_area = current_area;
            }
            if (min_height == height[left]) {
                left++;
            }else{
                right--;
            }
        }
        return max_area;
    }
}
