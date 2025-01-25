import java.util.Stack;

class MinStack {
    private Stack<Integer> elements;
    private Stack<Integer> currMin;

    public MinStack() {
        this.elements = new Stack<>();
        this.currMin = new Stack<>();
    }

    public void push(int val) {
        this.elements.push(val);
        int min = val;
        if(!currMin.isEmpty())
            min = Math.min(val, currMin.peek());
        this.currMin.push(min);
        
    }

    public void pop() {
        this.elements.pop();
        this.currMin.pop();
    }

    public int top() {
        return this.elements.peek();
    }

    public int getMin() {
        return this.currMin.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */