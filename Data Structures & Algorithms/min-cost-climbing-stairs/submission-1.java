//Memoization
class Solution {
    int[] cost;
    int[] dp;
    int n;

    public int minCostClimbingStairs(int[] cost) {
        this.n = cost.length;
        this.cost=cost;
        this.dp=new int[n+1];

        return solve(n);
    }

    public int solve(int n)
    {
        if(n==1||n==0)
            return 0;
        
        if(dp[n]!=0)
            return dp[n];
        
        return dp[n] = Math.min(solve(n-1)+cost[n-1],solve(n-2)+cost[n-2]);
    }
}
