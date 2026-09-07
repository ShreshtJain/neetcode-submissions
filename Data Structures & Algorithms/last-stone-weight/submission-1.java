class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(Comparator.reverseOrder());
        int diff =0;

        for(int i: stones)
        {
            pq.offer(i);
        }

        while(pq.size()>1)
        {
            diff = pq.poll()-pq.poll();
            pq.offer(diff);
        }

        return pq.poll();

    }
}
