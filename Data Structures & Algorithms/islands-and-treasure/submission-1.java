class Solution {

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (grid[r][c] == 0) {
                    queue.add(new int[]{r, c});
                }
            }
        }

        if(queue.isEmpty()) return;
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};


        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            int row = node[0];
            int col = node[1];
            for (int[] dir: dirs) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= m || c >= n || r < 0 || c < 0 || grid[r][c] != Integer.MAX_VALUE) {
                    continue;
                }
                queue.add(new int[]{r, c});
                grid[r][c] = grid[row][col] + 1;
            }
        }
    }
}
