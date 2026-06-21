class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int max = 0;
        int left = 0;
        int maxLength = 0;
        HashMap<Character, Integer> frequency = new HashMap<>();
        for (int right = 0; right < n; right++) {
            frequency.put(s.charAt(right), frequency.getOrDefault(s.charAt(right), 0) + 1);
            max = Math.max(frequency.get(s.charAt(right)), max);

            while ((right - left + 1) - max > k) {
                frequency.put(s.charAt(left), frequency.get(s.charAt(left)) - 1);
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
