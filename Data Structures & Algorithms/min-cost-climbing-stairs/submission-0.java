//Tabulation
class Solution {
    
    int[] dp;
    int n;

    public int minCostClimbingStairs(int[] cost) {
        this.n = cost.length;
        this.dp=new int[n+1];

        dp[0]=0;
        dp[1]=0;

        for(int i=2;i<=n;i++)
        {
            dp[i] = Math.min(dp[i-1]+cost[i-1],dp[i-2]+cost[i-2]);
        }

        return dp[n];
    }
}
