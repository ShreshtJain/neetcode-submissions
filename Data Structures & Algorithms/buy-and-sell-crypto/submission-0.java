class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        // int sell;
        int max = 0;

        for(int i:prices)
        {
            if(i<buy)
            {
                buy=i;
            }
                
            else
            {
                max=Math.max(i-buy,max);
            }
        }

        return max;
    }
}
