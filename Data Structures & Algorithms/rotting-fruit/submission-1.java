class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        int fresh = 0;

        // Queue contains all currently rotten oranges.
        // Each element stores {row, column}.
        Queue<int[]> q = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        // Add all initially rotten oranges to the queue
        // and count the total number of fresh oranges.
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = j;

                    q.offer(arr);
                } else if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        // If there are no fresh oranges, no time is needed.
        if (fresh == 0) {
            return 0;
        }

        // null marks the end of the current BFS level (one minute).
        if (!q.isEmpty()) {
            q.offer(null);
        }

        while (!q.isEmpty()) {
            int[] u = q.poll();

            // Reaching the sentinel means we have finished
            // processing all oranges from the current minute.
            if (u == null) {
                if (!q.isEmpty()) {
                    // Mark the end of the next minute.
                    q.offer(null);
                    minutes++;
                }
                continue;
            }

            int i = u[0];
            int j = u[1];

            // Check the cell above.
            if (i > 0 && grid[i - 1][j] == 1) {
                grid[i - 1][j] = 2;

                int[] arr = new int[2];
                arr[0] = i - 1;
                arr[1] = j;

                q.offer(arr);
                fresh--;
            }

            // Check the cell below.
            if (i < n - 1 && grid[i + 1][j] == 1) {
                grid[i + 1][j] = 2;

                int[] arr = new int[2];
                arr[0] = i + 1;
                arr[1] = j;

                q.offer(arr);
                fresh--;
            }

            // Check the cell to the left.
            if (j > 0 && grid[i][j - 1] == 1) {
                grid[i][j - 1] = 2;

                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = j - 1;

                q.offer(arr);
                fresh--;
            }

            // Check the cell to the right.
            if (j < m - 1 && grid[i][j + 1] == 1) {
                grid[i][j + 1] = 2;

                int[] arr = new int[2];
                arr[0] = i;
                arr[1] = j + 1;

                q.offer(arr);
                fresh--;
            }
        }

        // If fresh oranges remain, they were unreachable.
        return fresh == 0 ? minutes : -1;
    }
}