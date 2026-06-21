class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> dStack = new Stack<>();
        HashMap<Integer, Integer> nextGreaterIndices = new HashMap<>();
        int days = temperatures.length;
        int[] result = new int[days];

        for (int i = 0; i < days; i++) {
            while (!dStack.isEmpty() && temperatures[i] > temperatures[dStack.peek()]) {
                nextGreaterIndices.put(dStack.pop(), i);
            }
            dStack.push(i);
        }
        
        for (int j = 0; j < days; j++) {
            if (!nextGreaterIndices.containsKey(j)) {
                result[j] = 0;
            } else {
                result[j] = nextGreaterIndices.get(j) - j;
            }
        }

        return result;
    }
}