class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m =heights[0].length;

        boolean[][] pacific = new boolean[n][m];
        boolean[][] atlantic = new boolean[n][m];

        Queue<int[]> q =new LinkedList<>();

        List<List<Integer>> result = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(i==0 || j==0)
                {
                    pacific[i][j]=true;
                    
                    int[] arr = new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    q.offer(arr);
                }

                if(i==n-1 || j==m-1)
                {
                    atlantic[i][j]=true;
                    
                    int[] arr = new int[2];
                    arr[0]=i;
                    arr[1]=j;
                    q.offer(arr);
                }
            }
        }

        while(!q.isEmpty())
        {
            int[] node = q.poll();
            int i = node[0];
            int j =node[1];

            boolean p = pacific[i][j];
            boolean a = atlantic[i][j];

            //1st
            if(i>0 && heights[i-1][j]>=heights[i][j])
            {
                if(p&&a)
                {
                    if(!(pacific[i-1][j]&&atlantic[i-1][j]))
                    {
                        pacific[i-1][j]=true;
                        atlantic[i-1][j]=true;

                        int[] arr = new int[2];
                        arr[0]=i-1;
                        arr[1]=j;
                        q.offer(arr);
                    }
                }
                else if(p)
                {
                    if(!pacific[i-1][j])
                    {
                        pacific[i-1][j]=true;

                        int[] arr = new int[2];
                        arr[0]=i-1;
                        arr[1]=j;
                        q.offer(arr);
                    }
                }
                else if(a)
                {
                    if(!atlantic[i-1][j])
                    {
                        atlantic[i-1][j]=true;

                        int[] arr = new int[2];
                        arr[0]=i-1;
                        arr[1]=j;
                        q.offer(arr);
                    }
                }
            }

            //2nd 
            if(i<n-1 && heights[i+1][j]>=heights[i][j])
            {
                if(p&&a)
                {
                    if(!(pacific[i+1][j]&&atlantic[i+1][j]))
                    {
                        pacific[i+1][j]=true;
                        atlantic[i+1][j]=true;

                        int[] arr = new int[2];
                        arr[0]=i+1;
                        arr[1]=j;
                        q.offer(arr);
                    }
                }
                else if(p)
                {
                    if(!pacific[i+1][j])
                    {
                        pacific[i+1][j]=true;

                        int[] arr = new int[2];
                        arr[0]=i+1;
                        arr[1]=j;
                        q.offer(arr);
                    }
                }
                else if(a)
                {
                    if(!atlantic[i+1][j])
                    {
                        atlantic[i+1][j]=true;

                        int[] arr = new int[2];
                        arr[0]=i+1;
                        arr[1]=j;
                        q.offer(arr);
                    }
                }
            }

            //3rd
            if(j>0 && heights[i][j-1]>=heights[i][j])
            {
                if(p&&a)
                {
                    if(!(pacific[i][j-1]&&atlantic[i][j-1]))
                    {
                        pacific[i][j-1]=true;
                        atlantic[i][j-1]=true;

                        int[] arr = new int[2];
                        arr[0]=i;
                        arr[1]=j-1;
                        q.offer(arr);
                    }
                }
                else if(p)
                {
                    if(!pacific[i][j-1])
                    {
                        pacific[i][j-1]=true;

                        int[] arr = new int[2];
                        arr[0]=i;
                        arr[1]=j-1;
                        q.offer(arr);
                    }
                }
                else if(a)
                {
                    if(!atlantic[i][j-1])
                    {
                        atlantic[i][j-1]=true;

                        int[] arr = new int[2];
                        arr[0]=i;
                        arr[1]=j-1;
                        q.offer(arr);
                    }
                }
            }
            //4th
            if(j<m-1 && heights[i][j+1]>=heights[i][j])
            {
                if(p&&a)
                {
                    if(!(pacific[i][j+1]&&atlantic[i][j+1]))
                    {
                        pacific[i][j+1]=true;
                        atlantic[i][j+1]=true;

                        int[] arr = new int[2];
                        arr[0]=i;
                        arr[1]=j+1;
                        q.offer(arr);
                    }
                }
                else if(p)
                {
                    if(!pacific[i][j+1])
                    {
                        pacific[i][j+1]=true;

                        int[] arr = new int[2];
                        arr[0]=i;
                        arr[1]=j+1;
                        q.offer(arr);
                    }
                }
                else if(a)
                {
                    if(!atlantic[i][j+1])
                    {
                        atlantic[i][j+1]=true;

                        int[] arr = new int[2];
                        arr[0]=i;
                        arr[1]=j+1;
                        q.offer(arr);
                    }
                }
            }

        }

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(atlantic[i][j]&&pacific[i][j])
                {
                    List<Integer> list = new ArrayList<Integer>();
                    list.add(i);
                    list.add(j);
                    result.add(list);
                }
            }
        }

        return result;
    }
}
