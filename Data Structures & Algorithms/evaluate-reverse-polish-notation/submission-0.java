class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> evalStack = new Stack<>();
        int n = tokens.length;
        for (int i = 0; i < n; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                int operand2 = evalStack.pop();
                int operand1 = evalStack.pop();
                switch (tokens[i]) {
                    case "+":
                        operand1 += operand2;
                        break;
                    case "-":
                        operand1 -= operand2;
                        break;
                    case "*":
                        operand1 *= operand2;
                        break;
                    case "/":
                        operand1 /= operand2;
                        break;
                    default:
                        break;
                }
                evalStack.push(operand1);                
            } else {
                evalStack.push(Integer.parseInt(tokens[i]));
            }
        }
        return evalStack.pop();
    }
}
