/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<Node, Node>();

        if(node==null)
            return null;
        
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        Node clonedRoot =  new Node(node.val,new ArrayList<Node>());
        map.put(node, clonedRoot);

        while(!q.isEmpty())
        {   
            Node u = q.poll();
            Node clone = map.get(u);

            for(Node v: u.neighbors)
            {   
                if(!map.containsKey(v))
                {
                    Node newNode = new Node(v.val,new ArrayList<Node>());
                    clone.neighbors.add(newNode);
                    map.put(v,newNode);
                    q.offer(v);
                }
                else
                {
                    clone.neighbors.add(map.get(v));
                }
            } 
                
        }
        return clonedRoot;
    }

}