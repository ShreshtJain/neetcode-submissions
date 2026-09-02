class Solution {
    public int characterReplacement(String s, int k) {

        int left = 0;
        int right = 0;

        // Stores the maximum valid window length found so far
        int max = 0;

        // Highest frequency of a single character in the current window
        int maxFreq = 0;

        // Stores the frequency of each character in the current window
        Map<Character, Integer> map = new HashMap<>();

        int n = s.length();

        while (right < n) {

            // Add the current character to the window
            char c = s.charAt(right);
            int freq = map.getOrDefault(c, 0) + 1;
            map.put(c, freq);

            // Update the highest frequency character in the window
            maxFreq = Math.max(maxFreq, freq);

            // Number of characters that need to be replaced
            // = window size - frequency of the most frequent character
            //
            // If this is greater than k, the window is invalid
            while (right - left + 1 - maxFreq > k) {

                // Remove the leftmost character from the window
                char v = s.charAt(left);
                int v_freq = map.get(v);
                map.put(v, v_freq - 1);

                // Shrink the window from the left
                left++;
            }

            // Update the maximum valid window length
            max = Math.max(max, right - left + 1);

            // Expand the window to the right
            right++;
        }

        return max;
    }
}