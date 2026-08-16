//Memoization
class Solution {
    int n;
    int[] dp;
    int[] nums;

    public int rob(int[] nums) {
        this.n =nums.length;
        this.dp = new int[n];
        this.nums=nums;

       if(n==0)
            return 0;
        
        if(n==1)
            return nums[0];
        
        //exclude last house and include first house
        Arrays.fill(dp,-1);

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        int case1= solve(n-2);
        
        //include last house and exclude first house
        Arrays.fill(dp,-1);
        dp[0]=0;
        dp[1] = nums[1];
        int case2 =solve(n-1);

        return Math.max(case1, case2);
    }

    public int solve(int n)
    {
        if(n<0)
            return 0;
        
        if(dp[n]!=-1)
            return dp[n];

        return dp[n] = Math.max(solve(n-1), solve(n-2) + nums[n]);

    }
}
