class Solution {
    int visited[];
    Graph g;
    public int countComponents(int n, int[][] edges) {
        this.g = new Graph(n);
        g.addEdges(edges);

        this.visited = new int[n];
        int count=0;

        for(int i=0;i<n;i++)
        {
            if(visited[i]==0)
            {
                count++;
                visited[i]=1;
                dfs(i);
            }
        }
        return count;
    }

    void dfs(int i)
    {

        for(int v:g.adj.get(i))
        {
            if(visited[v]==0)
            {
                visited[v]=1;
                dfs(v);
            }
        }
    }
}

class Graph
{
    int v;
    ArrayList<ArrayList<Integer>> adj;

    Graph(int v)
    {
        this.v=v;
        this.adj=new ArrayList<ArrayList<Integer>>();

        for(int i=0;i<v;i++)
        {
            this.adj.add(new ArrayList<Integer>());
        }
    }

    public void addEdges(int[][] edges)
    {
        for(int i=0;i<edges.length;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
}
