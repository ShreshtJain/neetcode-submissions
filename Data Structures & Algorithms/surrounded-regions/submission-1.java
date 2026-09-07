class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;

        int[][] visited = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(board[i][j]=='X')
                {
                    visited[i][j]=1;
                }
                else if(i==n-1 || i==0 || j==0 || j==m-1)
                {
                    visited[i][j]=1;
                    
                    int[] arr = new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    
                    q.offer(arr);
                }
                else
                {
                    board[i][j] = 'X';
                }
            }
        }

        while(!q.isEmpty())
        {
            int[] u = q.poll();
            int i = u[0];
            int j = u[1];

            if(i>0 && visited[i-1][j]!=1)
            {
                visited[i-1][j]=1;
                board[i-1][j] = 'O';

                int[] arr = new int[2];
                arr[0]=i-1;
                arr[1]=j;

                q.offer(arr);
            }
            if(i<n-1 && visited[i+1][j]!=1)
            {
               visited[i+1][j]=1;
                board[i+1][j] = 'O';

                int[] arr = new int[2];
                arr[0]=i+1;
                arr[1]=j;

                q.offer(arr);
            }
            if(j>0 && visited[i][j-1]!=1)
            {
               visited[i][j-1]=1;
                board[i][j-1] = 'O';

                int[] arr = new int[2];
                arr[0]=i;
                arr[1]=j-1;

                q.offer(arr);
            }
            if(j<m-1 && visited[i][j+1]!=1)
            {
               visited[i][j+1]=1;
                board[i][j+1] = 'O';

                int[] arr = new int[2];
                arr[0]=i;
                arr[1]=j+1;

                q.offer(arr);
            }
        }
    }
}
