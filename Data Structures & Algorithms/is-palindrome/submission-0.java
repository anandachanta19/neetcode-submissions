class Solution {
    public boolean isPalindrome(String s) {
        StringBuilder processedString = new StringBuilder();
        char[] characters = s.toCharArray();
        for (char character : characters) {
            if (Character.isAlphabetic(character) || Character.isDigit(character)) {
                processedString.append(Character.toLowerCase(character));
            }
        }
        s = processedString.toString();
        int left = 0;
        int right = s.length() - 1;
        while (left <= right) {
            if (s.charAt(right) != s.charAt(left)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
