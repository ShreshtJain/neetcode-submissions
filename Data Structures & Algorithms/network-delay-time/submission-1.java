class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        Graph g = new Graph(n);
        g.addEdges(times);

        int[] distance = new int[n+1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[0]=0;
        distance[k]=0;

        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{k,0});

        int sum = Integer.MIN_VALUE;

        while(!pq.isEmpty())
        {
            int[] arr = pq.poll();
            int u =arr[0];
            int w= arr[1];

            // Ignore stale entry
            if (w > distance[u])
                continue;
            
            for(int[] arr2:g.adj.get(u))
            {
                int v = arr2[0];
                int d = arr2[1];
                int newDistance = w+d;
                
                if(distance[v]>newDistance)
                {
                    distance[v]=newDistance;
                    pq.offer(new int[]{v,newDistance});
                }  
            }
        }
        for(int i:distance)
        {
            // System.out.println(i);
            if(i==Integer.MAX_VALUE)
                return -1;
            
            if(i>sum)
                sum=i;
        }

        return sum;
    }
}

class Graph
{
    int n;
    ArrayList<ArrayList<int[]>> adj;

    Graph(int n)
    {
        this.n=n;
        this.adj=new ArrayList<ArrayList<int[]>>();

        for(int i=0;i<=n;i++)
        {
            this.adj.add(new ArrayList<int[]>());
        }
    }

    void addEdges(int[][] times)
    {
        for(int[] time:times)
        {
            int[] arr = new int[2];
            arr[0]=time[1];
            arr[1]=time[2];

            adj.get(time[0]).add(arr);
        }
    }
}
