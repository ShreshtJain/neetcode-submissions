//Tabulation
class Solution {
    int[] dp;
    int[] nums;
    int n;

    public int rob(int[] nums) {
        this.n=nums.length;
        this.nums=nums;
        this.dp=new int[n+1];

        if(n<=1)
            return nums[0]; 

        dp[0]=nums[0];
        dp[1]=Math.max(nums[1],nums[0]);

        for(int i=2;i<n;i++)
        {
            dp[i] = Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        return dp[n-1];

    }
}
