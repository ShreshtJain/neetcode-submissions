/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;

        Map<Node, Node> map = new HashMap<>();

        while(temp!=null)
        {
            Node node;
            if(!map.containsKey(temp))
            {
                node=new Node(temp.val);
                map.put(temp,node);
            }
            else
            {
                node = map.get(temp);
            }
            
            Node next = temp.next;
            Node random = temp.random;

            Node cloneNext = null;
            Node cloneRandom = null;

            if(!map.containsKey(next))
            {
                if(next!=null)
                    cloneNext=new Node(next.val);
                
                map.put(next,cloneNext);
            }
            else
            {
                cloneNext = map.get(next);
            }
            node.next=cloneNext;

            if(!map.containsKey(random))
            {
                if(random!=null)
                    cloneRandom=new Node(random.val);
                
                map.put(random,cloneRandom);
            }
            else
            {
                cloneRandom = map.get(random);
            }
            node.random=cloneRandom;
            
            temp=temp.next;
        }

        return map.get(head);
    }
}
