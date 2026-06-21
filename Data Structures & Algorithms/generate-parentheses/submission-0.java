class Solution {

    private void generator (int n, StringBuilder current, int openCount, int closeCount, List<String> result) {
        int maxLength = n + n;

        if (openCount < n) {
            current.append("(");
            generator(n, current, openCount + 1, closeCount, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (closeCount < openCount) {
            current.append(")");
            generator(n, current, openCount, closeCount + 1, result);
            current.deleteCharAt(current.length() - 1);
        }

        if (current.length() == maxLength) {
            result.add(current.toString());
        }

    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder current = new StringBuilder("(");
        generator (n, current, 1, 0, result);
        Collections.sort(result);
        return result;
    }
}
