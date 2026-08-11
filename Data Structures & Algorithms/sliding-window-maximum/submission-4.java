class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayDeque<Integer> dq= new ArrayDeque<>();

        int[] arr=new int[nums.length-k+1];

        for(int i=0;i<k;i++)
        {
            while(!dq.isEmpty()&&nums[i]>=nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            dq.offerLast(i);
        }

        for(int i=k;i<nums.length;i++)
        {
            arr[i-k]=nums[dq.peekFirst()];

            while(!dq.isEmpty()&&nums[i]>=nums[dq.peekLast()])
            {
                dq.pollLast();
            }
            while(!dq.isEmpty()&&i-k>=dq.peekFirst())
            {
                dq.pollFirst();
            }
            dq.offerLast(i);
        }
        arr[nums.length-k]=nums[dq.peekFirst()];

        return arr;
        
    }
}
