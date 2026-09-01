class Solution {
    public int maxProfit(int[] prices) {

        // Lowest price seen so far (best day to buy)
        int buy = Integer.MAX_VALUE;

        // Maximum profit found so far
        int max = 0;

        // Treat the current price as the selling price
        for (int i : prices) {

            // If today's price is lower, update the best buying price
            if (i < buy) {
                buy = i;
            }

            // Otherwise, calculate the profit if we sell today
            else {
                max = Math.max(i - buy, max);
            }
        }

        // Return the maximum profit possible
        return max;
    }
}