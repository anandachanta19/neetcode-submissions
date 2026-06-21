class Solution {
    public int orangesRotting(int[][] grid) {
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLS; col++) {
                if (grid[row][col] == 2) {
                    queue.add(new int[]{row, col});
                }else if (grid[row][col] == 1) {
                    freshCount += 1;
                }
            }
        }

        if (queue.size() == 0 && freshCount != 0) return -1;
        if (freshCount == 0) return 0;

        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        boolean[][] visited = new boolean[ROWS][COLS];
        int minute = -1;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            while(levelSize != 0) {
                int[] curOrange = queue.poll();
                int row = curOrange[0];
                int col = curOrange[1];
                for (int[] dir: directions) {
                    int r = row + dir[0];
                    int c = col + dir[1];
                    if (r < 0 || r >= ROWS || c < 0 || c >= COLS || grid[r][c] == 0 || visited[r][c]) {
                        continue;
                    }
                    if (grid[r][c] == 1 && !visited[r][c]) {
                        visited[r][c] = true;
                        queue.add(new int[]{r,c});
                        freshCount--;
                    }
                }
                levelSize--;
            }
            minute++;
        }
        return freshCount == 0 ? minute : -1;
        
    }
}