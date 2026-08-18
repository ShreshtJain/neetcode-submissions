class Solution {
    Graph g;
    int[] parent;
    int[] visited;
    public boolean validTree(int n, int[][] edges) {
        this.g=new Graph(n);
        this.g.addEdges(edges);
        this.parent=new int[n];
        this.visited=new int[n];

        Arrays.fill(visited,-1);
        Arrays.fill(parent,-1);
if(edges.length != n - 1)
        return false;
        for(int i=0;i<n;i++)
        {
            if(visited[i]==-1)
            {
                boolean result =dfs(i);
                if(result==false)
                    return false;
            }
        }
        
        return true;
    }

    boolean dfs(int i)
    {
        visited[i]=1;

        for(int w:g.adj.get(i))
        {
            if(visited[w]==-1)
            {
                parent[w]=i;
                if(!dfs(w))
                    return false;
            }
            else if(visited[w]!=-1 && parent[i]!=w)
                return false;
        }

        return true;
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

    void addEdges(int[][] edges)
    {
        int n= edges.length;

        for(int i=0;i<n;i++)
        {
            int u = edges[i][0];
            int v = edges[i][1];

            this.adj.get(u).add(v);
            this.adj.get(v).add(u);
        }
    }
}