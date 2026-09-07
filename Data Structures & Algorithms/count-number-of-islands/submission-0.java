class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        
        if(n<=0)
            return 0;
        
        int m = grid[0].length; 
        int islands=0;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m;j++)
            {
                if(grid[i][j]=='1')
                {
                    grid[i][j]='0';
                    dfs(grid,i,j,m,n);
                    islands++;
                }
            }
        }
        return islands;
    }

    void dfs(char[][] grid, int i, int j, int m, int n)
    {
        if(j<m-1 && grid[i][j+1]=='1')
        {
            grid[i][j+1]='0';
            dfs(grid,i,j+1,m,n);
        }
        if(j>0 && grid[i][j-1]=='1')
        {
            grid[i][j-1]='0';
            dfs(grid,i,j-1,m,n);
        }
        
        if(i<n-1 && grid[i+1][j]=='1')
        {
            grid[i+1][j]='0';
            dfs(grid,i+1,j,m,n);
        }
        if(i>0 && grid[i-1][j]=='1')
        {
            grid[i-1][j]='0';
            dfs(grid,i-1,j,m,n);
        }
    }
}
