//Memoization
class Solution {
    int[] dp;
    int[] nums;
    int n;

public int rob(int[] nums) {
    this.n = nums.length;
    this.nums = nums;

    if (n == 0) return 0;
    if (n == 1) return nums[0];

    this.dp = new int[n];

    return solve(n-1);
}

    int solve(int n)
    {
        if(n==0)
            return nums[0];
        
        if(n==1)
            return Math.max(nums[0], nums[1]);
        
        if(dp[n]!=0)
            return dp[n];

        return dp[n] = Math.max(solve(n-1), solve(n-2) + nums[n]);
    }
}
