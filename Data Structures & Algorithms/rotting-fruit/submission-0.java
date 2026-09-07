class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes=0;
        int fresh=0;

        Queue<int[]> q = new LinkedList<>();

        int n =grid.length;
        int m =grid[0].length;

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    int[] arr = new int[2];
                    arr[0]=i;
                    arr[1]=j;

                    q.offer(arr);
                }
                else if(grid[i][j]==1)
                {
                    fresh++;
                }
                   
            }
        }

        if (fresh == 0) {
            return 0;
        }

        if(!q.isEmpty())
        {
            q.offer(null);
        }

        while(!q.isEmpty())
        {
            int[] u = q.poll();

                if(u==null)
                {
                    if(!q.isEmpty())
                    {
                        q.offer(null);
                        minutes++;
                    }
                    continue;
                }

            int i = u[0];
            int j = u[1];

            if(i>0 && grid[i-1][j]==1)
            {   
                    grid[i-1][j]=2;
                    
                    int[] arr = new int[2];
                    arr[0]=i-1;
                    arr[1]=j;

                    q.offer(arr);

                    fresh--;
            }

            if(i<n-1 && grid[i+1][j]==1)
            {
                    grid[i+1][j]=2;
                    
                    int[] arr = new int[2];
                    arr[0]=i+1;
                    arr[1]=j;

                    q.offer(arr);
                    fresh--;
            }

            if(j>0 && grid[i][j-1]==1)
            {
                    grid[i][j-1]=2;
                    
                    int[] arr = new int[2];
                    arr[0]=i;
                    arr[1]=j-1;

                    q.offer(arr);
                    fresh--;
            }

            if(j<m-1 && grid[i][j+1]==1)
            {
                    grid[i][j+1]=2;
                    
                    int[] arr = new int[2];
                    arr[0]=i;
                    arr[1]=j+1;

                    q.offer(arr);
                    fresh--;
            }
        }

        return fresh==0?minutes:-1;
    }
}
