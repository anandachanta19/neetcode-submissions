class Solution {
    public void dfs(char[][] grid, int row, int col, int rows, int cols, boolean[][] visited) {
        // Check either it's an invalid move or it's already visited to skip them. 
        if (row < 0 || col < 0 || row > rows - 1 || col > cols - 1 || grid[row][col] == '0' || visited[row][col] == true) {
            return ;
        }
        
        // Update the status to be visited.
        visited[row][col] = true;

        // Check the adjacents.
        dfs(grid, row - 1, col, rows, cols, visited);
        dfs(grid, row + 1, col, rows, cols, visited);
        dfs(grid, row, col - 1, rows, cols, visited);
        dfs(grid, row, col + 1, rows, cols, visited);
        return ;
    }

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        // To count the no of islands.
        int count = 0;

        // We need track visited nodes here.
        boolean[][] visited = new boolean[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (grid[row][col] == '1' && visited[row][col] != true) {
                    count++;
                    /* We encountered a land now we need to visit each land
                    beside it and need to update their visiting status. */
                    dfs(grid, row, col, rows, cols, visited);
                }
            }
        }

        return count;
    }
}