class Solution {
    String text1;
    String text2;
    Integer[][] dp;

    public int longestCommonSubsequence(String text1, String text2) {
        this.text1=text1;
        this.text2=text2;
        int n=text1.length();
        int m = text2.length();

        dp= new Integer[n][m];

        return solve(text1.length()-1,text2.length()-1);
    }

    public int solve(int i, int j)
    {
        if(i<0||j<0)
            return 0;
        
        if(dp[i][j]!=null)
            return dp[i][j];
        
        if(text1.charAt(i)==text2.charAt(j))
            return dp[i][j] = solve(i-1,j-1)+1;

        int l1= solve(i-1,j);
        int l2 = solve(i,j-1);

        return dp[i][j] = Math.max(l1,l2);

    }
}
