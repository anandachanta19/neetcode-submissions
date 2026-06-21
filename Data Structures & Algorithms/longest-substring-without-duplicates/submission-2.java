class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return n;
        }
        int left = 0;
        int right = 1;
        HashSet<Character> visited = new HashSet<>();
        visited.add(s.charAt(left));
        int result = 1;
        while (left < n && right < n) {
            if (!visited.contains(s.charAt(right))) {
                visited.add(s.charAt(right));
                right++;
            } else {
                visited.remove(s.charAt(left));
                left++;
            }
            result = Math.max(result, visited.size());
        }
        return result;
    }
}
