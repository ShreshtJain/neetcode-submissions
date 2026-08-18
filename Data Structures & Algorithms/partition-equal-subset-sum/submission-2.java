class Solution {
    int[] nums;
    Boolean[] dp;
    int n;
    public boolean canPartition(int[] nums) {
        int sum = 0;
        this.n=nums.length;
        this.nums=nums;

        for(int i:nums)
        {
            sum+=i;
        }
        this.dp = new Boolean[(sum/2)+1];

        if(sum%2!=0)
            return false;
        
        return solve(sum/2,0);
    }

    public boolean solve(int sum, int i)
    {
        if(sum==0)
            return true;
        
        if(sum<0||i>=n)
            return false;
        
        if(dp[sum]!=null)
            return dp[sum];
        
        boolean pick = solve(sum-nums[i],i+1);
        boolean notPick = solve(sum,i+1);

        return dp[sum] = pick||notPick;

    }
}
