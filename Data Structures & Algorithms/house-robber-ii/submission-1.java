//Tabulation
class Solution {
    public int rob(int[] nums) {
        int n =nums.length;
        int[] dp = new int[n];

        if (n == 0) 
            return 0;
        if (n == 1) 
            return nums[0];
        
        //exclude last house and include first house
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i=2;i<n-1;i++)
        {

            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        int case1 = dp[n-2];

        //include last house and exclude first house
        dp[0] = 0;
        dp[1] = nums[1];

        for(int i=2;i<n;i++)
        {
            dp[i]= Math.max(dp[i-1],dp[i-2]+nums[i]);
        }

        int case2 = dp[n - 1];

        return Math.max(case1, case2);
    }
}
