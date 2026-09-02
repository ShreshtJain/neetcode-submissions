class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        if (n > m)
            return false;

        // Required frequency from s1
        int[] freq1 = new int[26];

        // Frequency of characters in current window
        int[] freq2 = new int[26];

        for (char c : s1.toCharArray()) {
            freq1[c - 'a']++;
        }

        int matches = 0;

        // Build the first window of size n
        for (int i = 0; i < n; i++) {
            int index = s2.charAt(i) - 'a';
            freq2[index]++;
        }

        // Check which character frequencies already match
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) {
                matches++;
            }
        }
        
        // All 26 character frequencies match
        if (matches == 26)
            return true;

        // Slide the window
        for (int right = n; right < m; right++) {

            // Character entering the window
            int add = s2.charAt(right) - 'a';

            // If it was matching before changing it,
            // it will stop matching after incrementing
            if (freq1[add] == freq2[add])
                matches--;

            freq2[add]++;

            // If it matches after incrementing, add it back
            if (freq1[add] == freq2[add])
                matches++;


            // Character leaving the window
            int remove = s2.charAt(right - n) - 'a';

            // If it was matching before removing it,
            // it will stop matching after decrementing
            if (freq1[remove] == freq2[remove])
                matches--;

            freq2[remove]--;

            // If it matches after decrementing, add it back
            if (freq1[remove] == freq2[remove])
                matches++;


            // All 26 character frequencies match
            if (matches == 26)
                return true;
        }

        return false;

    }
}
