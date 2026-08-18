class LRUCache {

    Dll dll = new Dll();
    Map<Integer,Node> map = new HashMap<Integer,Node>();
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node==null)
            return -1;
        dll.remove(node);
        return node.value;

    }
    
    public void put(int key, int value) {
        // Key already exists
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            dll.remove(node); // move to head
            return;
        }

        // Cache full
        if (dll.capacity == capacity) {
            Node node = dll.removeLast();
            map.remove(node.key);
        }

        Node node = new Node(key, value);
        dll.addNode(node);
        map.put(key, node);
    }
}
    class Node
    {
        int key;
        int value;
        Node next;
        Node prev;

    Node(int key, int value)
    {
        this.key=key;
        this.value=value;
    }
    }
class Dll
{
    Node head;
    Node tail;
    int capacity;

    void addNode(Node node)
    {
        if(head==null)
        {
            head=node;
            tail=node;
        }
        else
        {
            node.next=head;
            head.prev=node;
            head=node;
        }
        this.capacity++;
    }
    Node removeLast()
    {
        Node node = tail;
        if(tail==head)
        {
            tail=null;
            head=tail;
        }
        else
        {
            tail=tail.prev;
            tail.next=null;
        }
        this.capacity--;
        return node;
    }

    void remove(Node node)
    {
        if(node==head)
        {
            return;
        }
        else if(node==tail)
        {
            tail=tail.prev;
            tail.next=null;

        }
        else
        {
            Node prev=node.prev;
            Node next=node.next;
            prev.next=next;
            next.prev=prev;
        }
            node.next=head;
            node.prev=null;
            head.prev=node;
            head=node;
    }
}