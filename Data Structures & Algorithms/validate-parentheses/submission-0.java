class Solution {
    public boolean isValid(String s) {
        Stack<Character> pStack = new Stack<>();
        char[] parantheses = s.toCharArray();
        for (char paran: parantheses) {
            if (paran == '(' || paran =='{' || paran == '[') {
                pStack.push(paran);
            } else {
                switch (paran) {
                    case ')':
                        if (pStack.isEmpty() || pStack.peek() != '(') {
                            return false;
                        } else {
                            pStack.pop();
                        }
                        break;
                    case '}':
                        if (pStack.isEmpty() || pStack.peek() != '{') {
                            return false;
                        } else {
                            pStack.pop();
                        }
                        break;
                    case ']':
                        if (pStack.isEmpty() || pStack.peek() != '[') {
                            return false;
                        } else {
                            pStack.pop();
                        }
                        break;
                
                    default:
                        break;
                }
            }
        }
        return pStack.isEmpty();
    }
}
