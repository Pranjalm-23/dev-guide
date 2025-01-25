import java.util.*;

class FreqStack {
    HashMap<Integer, Integer> freq;
    HashMap<Integer, Stack<Integer>> group;
    int maxf;

    public FreqStack() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxf = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);

        if (f > maxf)
            maxf = f;

        Stack<Integer> st = group.getOrDefault(f, new Stack<>());
        st.push(val);
        group.put(f, st);
        // group.computeIfAbsent(f, x -> new Stack<>()).push(val);

    }

    public int pop() {
        Stack<Integer> st = group.get(maxf);
        int val = st.pop();
        freq.put(val, maxf - 1);

        if (st.isEmpty())
            maxf--;
        return val;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */