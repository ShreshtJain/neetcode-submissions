class KthLargest {
    PriorityQueue<Integer> pq=new PriorityQueue<Integer>();
    int k;

    public KthLargest(int k, int[] nums) {
        this.k=k;
    
        for(int i:nums)
        {
            pq.offer(i);

            if(pq.size()>k)
                pq.poll();
        }

    }
    
    public int add(int val) {
        pq.offer(val);

        if(pq.size()>k)
            pq.poll();
        
        return pq.peek();
    }
}
