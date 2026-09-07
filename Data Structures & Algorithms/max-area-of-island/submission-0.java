class Solution {
    int n;
    int m;
    int currArea;
    int maxArea;

    public int maxAreaOfIsland(int[][] grid) {
        this.n = grid.length;
        
        if(n<=0)
            return 0;
        
        this.m = grid[0].length; 
        this.maxArea=0;
        this.currArea=0;
        
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m;j++)
            {
                if(grid[i][j]==1)
                {
                    grid[i][j]=0;
                    currArea++;
                    dfs(grid,i,j);
                    maxArea=Math.max(maxArea,currArea);
                    currArea=0;
                }
            }
        }
        return maxArea;
    }

    void dfs(int[][] grid, int i, int j)
    {
        if(j<m-1 && grid[i][j+1]==1)
        {
            grid[i][j+1]=0;
            currArea++;
            dfs(grid,i,j+1);
        }
        if(j>0 && grid[i][j-1]==1)
        {
            grid[i][j-1]=0;
            currArea++;
            dfs(grid,i,j-1);
        }
        
        if(i<n-1 && grid[i+1][j]==1)
        {
            grid[i+1][j]=0;
            currArea++;
            dfs(grid,i+1,j);
        }
        if(i>0 && grid[i-1][j]==1)
        {
            grid[i-1][j]=0;
            currArea++;
            dfs(grid,i-1,j);
        }
    }
}
