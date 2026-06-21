class MinStack {
    int topIndex;
    int minTopIndex;
    int currentMin;
    ArrayList<Integer> minTimeStack;
    ArrayList<Integer> stack;

    public MinStack() {
        this.currentMin = Integer.MAX_VALUE;
        this.topIndex = -1;
        this.minTopIndex = -1;
        this.stack = new ArrayList<>();
        this.minTimeStack = new ArrayList<>();
    }
    
    public void push(int val) {
        this.topIndex++;
        this.stack.add(val);
        this.currentMin = Math.min(val, this.currentMin);
        this.minTopIndex++;
        this.minTimeStack.add(currentMin);
    }
    
    public void pop() {
        this.topIndex--;
        this.stack.remove(this.topIndex + 1);
        this.minTopIndex--;
        this.minTimeStack.remove(this.minTopIndex + 1);
        if (this.minTopIndex > -1) {
            this.currentMin = this.minTimeStack.get(this.minTopIndex);
        } else {
            this.currentMin = Integer.MAX_VALUE;
        }
    }
    
    public int top() {
        return this.stack.get(this.topIndex);
    }
    
    public int getMin() {
        return this.minTimeStack.get(this.minTopIndex);
    }
}