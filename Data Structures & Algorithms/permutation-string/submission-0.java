class Solution {

    private boolean isFreqSame (int[] freq1, int[] freq2) {
        for (int i = 0; i < 26; i++) {
            if (freq1[i] == freq2[i]) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean checkInclusion(String s1, String s2) {
        int[] freq1 = new int[26];
        int windowSize = s1.length();
        for (int i = 0; i < windowSize; i++) {
            freq1[s1.charAt(i) - 'a']++; 
        }
        int left = 0;
        while (left <= s2.length() - windowSize) {
            int[] freq2 = new int[26];
            for (int i = 0; i < windowSize; i++) {
                freq2[s2.charAt(left + i) - 'a']++; 
            }
            if (isFreqSame(freq1, freq2)) {
                return true;
            }
            left++;
        }
        return false;
    }
}
