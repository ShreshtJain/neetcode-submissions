//Memoization
class Solution {
    int[] dp;
    int[] coins;

    public int coinChange(int[] coins, int amount) {
        this.dp=new int [amount+1];
        this.coins=coins;
        
        Arrays.fill(dp,-1);
        
        return solve(amount) == Integer.MAX_VALUE ? -1 : dp[amount];

    }

    public int solve(int n)
    {   
        if(n==0)
            return dp[n]=0;
        
        if(dp[n]!=-1)
            return dp[n];
        
        dp[n] = Integer.MAX_VALUE;
        
        for(int coin:coins)
        {   
            if(n>=coin)
            {
                    int pick = solve(n-coin);
                    if(pick!=Integer.MAX_VALUE)
                        dp[n] = Math.min(dp[n],pick+1);
            }
        }

        return dp[n];

    }
}
