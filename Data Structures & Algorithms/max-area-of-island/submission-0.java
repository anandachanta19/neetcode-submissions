class Solution {
    int area = 0;

    public void solve(int[][] grid, int row, int col) {
        if (row < 0 || col < 0 || row >= grid.length || col >= grid[0].length || grid[row][col] == 2 || grid[row][col] == 0){
            return;
        }
        area += 1;
        grid[row][col] = 2;
        solve(grid, row - 1, col);
        solve(grid, row + 1, col);
        solve(grid, row, col - 1);
        solve(grid, row, col + 1);
    }

    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = Integer.MIN_VALUE;

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == 1) {
                    area  = 0;
                    solve(grid, row, col);
                }
                maxArea = Math.max(maxArea, area);
            }
        }
        return maxArea;
    }
}