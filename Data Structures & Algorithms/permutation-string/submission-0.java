class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n =s1.length();
        int m = s2.length();

        if(n>m)
            return false;

        int[] freq = new int[26];

        for(char c:s1.toCharArray())
        {
            freq[c-97]++;
        }

        for(int left=0;left<m;left++)
        {
            int right=left;
            
            while(right<m && freq[s2.charAt(right)-97]>0)
            {
                freq[s2.charAt(right)-97]--;
                
                if(right-left==n-1)
                    return true;
                
                right++;
            }

            while(right!=left)
            {
                freq[s2.charAt(--right)-97]++;
            }
        }

        return false;
    }
}
