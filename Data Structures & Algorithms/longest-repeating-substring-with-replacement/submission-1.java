class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int right =0;
        int max = 0;
        int maxFreq=0;

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int n = s.length();

        while(right<n)
        {
            char c= s.charAt(right);
            int freq = map.getOrDefault(c,0)+1;
            map.put(c,freq);
            maxFreq= Math.max(maxFreq,freq);
            
            while(right-left+1-maxFreq>k)
            {
                char v = s.charAt(left);
                int v_freq = map.get(s.charAt(left));
                map.put(v,v_freq-1);
                left++;
            }
    
            max=Math.max(max,right-left+1);
            right++;
        }

        return max;
    }
}
