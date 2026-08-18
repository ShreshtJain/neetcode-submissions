//Tabulation
class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int i:nums)
        {
            sum+=i;
        }

        if(sum%2!=0)
            return false;
        sum=sum/2;
        boolean dp[] = new boolean[sum+1];
        dp[0] = true;

        for(int i:nums)
        {
            for(int j=sum;j>0;j--)
            {
                boolean pick = false;
                if(j>=i)
                {
                    pick=dp[j-i];
                }
                boolean notPick = dp[j];
                dp[j] = pick||notPick;
            }
        }
        return dp[sum];
    }
}
