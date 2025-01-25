import java.util.*;

class MyStack {
    Queue<Integer> q;

    public MyStack() {
        this.q = new ArrayDeque<>();
    }

    public void push(int x) {
        this.q.offer(x);
        int size = this.q.size();
        // Rotate the queue to simulate stack behavior
        while (size > 1) {
            this.q.offer(this.q.poll());
            size--;
        }
    }

    public int pop() {
        return this.q.poll();
    }

    public int top() {
        return this.q.peek();
    }

    public boolean empty() {
        return this.q.size() == 0;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */