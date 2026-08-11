class Solution {
    public boolean isPalindrome(String s) {
        String arr = s.replaceAll("[^A-Za-z0-9]","").toLowerCase();
        System.out.println(arr);
        
        int left=0;
        int right=arr.length()-1;

        while(left<right)
        {
            if(arr.charAt(left++)!=arr.charAt(right--))
                return false;
        }

        return true;
    }
}
