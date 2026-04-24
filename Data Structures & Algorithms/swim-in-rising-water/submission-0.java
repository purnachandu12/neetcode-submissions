
class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<pair> pq = new PriorityQueue<>((a, b) -> a.value - b.value);

        pq.add(new pair(0, 0, grid[0][0]));

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        while (!pq.isEmpty()) {
            pair current = pq.poll();
            int row = current.row;
            int col = current.col;
            int time = current.value;

            if (visited[row][col]) continue;
            visited[row][col] = true;

            if (row == n - 1 && col == n - 1) {
                return time;
            }

            for (int i = 0; i < 4; i++) {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    pq.add(new pair(newRow, newCol, Math.max(time, grid[newRow][newCol])));
                }
            }
        }

        return -1;
    }
}

class pair {
    int row, col, value;

    public pair(int row, int col, int value) {
        this.row = row;
        this.col = col;
        this.value = value;
    }
}
