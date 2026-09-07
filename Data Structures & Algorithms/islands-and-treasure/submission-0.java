class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<Node> q = new LinkedList<>();
        int n = grid.length;

        if(n<0)
            return;
        
        int m =grid[0].length;

        for(int i=0; i<n;i++)
        {
            for(int j=0; j<m; j++)
            {
                if(grid[i][j]==0)
                {
                    q.offer(new Node(i,j,0));
                }
            }
        }

        while(!q.isEmpty())
        {
            Node u = q.poll();
            int i =u.i;
            int j = u.j;

            if(i>0 && grid[i-1][j]!=-1)
            {
                int newD = grid[i][j]+1;

                if(newD<grid[i-1][j])
                {
                    grid[i-1][j] = newD;
                    q.offer(new Node(i-1,j,newD));
                }
            }
            if(i<n-1 && grid[i+1][j]!=-1)
            {
                int newD = grid[i][j]+1;

                if(newD<grid[i+1][j])
                {
                    grid[i+1][j] = newD;
                    q.offer(new Node(i+1,j,newD));
                }
            }
            if(j>0 && grid[i][j-1]!=-1)
            {
                int newD = grid[i][j]+1;

                if(newD<grid[i][j-1])
                {
                    grid[i][j-1] = newD;
                    q.offer(new Node(i,j-1,newD));
                }
            }
            if(j<m-1 && grid[i][j+1]!=-1)
            {
                int newD = grid[i][j]+1;

                if(newD<grid[i][j+1])
                {
                    grid[i][j+1] = newD;
                    q.offer(new Node(i,j+1,newD));
                }
            }
        }

    }

    class Node
    {
        int i;
        int j;
        int distance;

        Node(int i, int j, int distance)
        {
            this.i=i;
            this.j=j;
            this.distance=distance;
        }
    }
}
