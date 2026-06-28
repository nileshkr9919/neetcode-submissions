class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();
        int freshCount = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[] {i, j});
                } else if (grid[i][j] == 1) {
                    freshCount++;
                }
            }
        }

        int[] rowDir = new int[] {0, 0, 1, -1};
        int[] colDir = new int[] {1, -1, 0, 0};

        int time = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean rotted = false;

            for (int i = 0; i < size; i++) {
                int[] item = queue.poll();
                int r = item[0];
                int c = item[1];

                for (int dir = 0; dir < 4; dir++) {
                    int nr = r + rowDir[dir];
                    int nc = c + colDir[dir];

                    if (nr < 0 || nc < 0 || nr >= grid.length || nc >= grid[0].length) {
                        continue;
                    }
                    if (grid[nr][nc] == 1) {
                        grid[nr][nc] = 2;
                        queue.add(new int[] {nr, nc});
                        freshCount--;
                        rotted = true;
                    }
                }
            }
            if (rotted)
                time++;
        }
        return freshCount == 0 ? time : -1;
    }
}
