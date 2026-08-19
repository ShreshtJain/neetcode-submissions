class Solution {
    public boolean isAnagram(String s, String t) {
        char[] arr = new char[26];
        int n =s.length();
        int m = t.length();

        for(int i=0;i<n;i++)
        {
            char ch = s.charAt(i);
            arr[ch-97]++;
        }

        for(int j=0;j<m;j++)
        {
            char ch = t.charAt(j);
            arr[ch-97]--;
        }

        for(int i=0;i<26;i++)
        {
            if(arr[i]!=0)
                return false;
        }

        return true;
    }
}
