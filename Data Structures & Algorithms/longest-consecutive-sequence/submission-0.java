class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();

        for(int i:nums)
        {
            set.add(i);
        }

        int max=0;
        
        for(int i:nums)
        {
            if(!set.contains(i-1))
            {
                int j=i;
                int curr=0;
                
                while(set.contains(j))
                {
                    curr++;
                    j++;
                }
                max=Math.max(curr,max);
            }
        }
        return max;
    }
}
