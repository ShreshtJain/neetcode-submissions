class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Graph g = new Graph(numCourses);
        g.addEdges(prerequisites);

        int[] indegree = new int[numCourses];
        indegree(indegree,prerequisites);

        Queue<Integer> q = new LinkedList<>();
        int count = numCourses;

        for(int i = 0; i < numCourses; i++)
        {
            if(indegree[i] == 0)
            {
                q.offer(i);
            }
        }

        System.out.println(Arrays.toString(indegree));

        while(!q.isEmpty())
        {
            int u = q.poll();
            count--;

            for(int v: g.adj.get(u))
            {
                if(--indegree[v]==0)
                {
                    q.offer(v);
                }
            }
        }

        if(count!=0)
            return false;

        return true;

    }

    void indegree(int[] indegree, int[][] prerequisites)
    {
        for(int[] arr: prerequisites)
        {
            indegree[arr[0]]++;
        }
    }
}

class Graph
{
    int v;
    List<List<Integer>> adj;

    Graph(int v)
    {
        this.v=v;
        this.adj = new ArrayList<>();

        for(int i=0;i<v;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
    }

    void addEdges(int[][] edges)
    {
        for(int[] edge: edges)
        {
            adj.get(edge[1]).add(edge[0]);
        }
    }
}