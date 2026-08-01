class MinStack {

    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
    }
    
    public void pop() {
        this.stack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        Stack<Integer> tmp = new Stack();

         int mini = stack.peek();

        while (!stack.isEmpty()) {
            mini = Math.min(mini, stack.peek());
            tmp.push(stack.pop());
        }
                   
        while (!tmp.isEmpty()) {
            stack.push(tmp.pop());
        }

        return mini;

    }
}
