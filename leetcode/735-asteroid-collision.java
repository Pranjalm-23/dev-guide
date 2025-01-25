import java.util.Stack;

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for (int a : asteroids) {
            while (!st.isEmpty() && a < 0 && st.peek() > 0) {
                int diff = a + st.peek(); // 
                if (diff < 0) { // means a is greater in size
                    // burst left one
                    st.pop();
                } else if (diff > 0) {
                    a = 0; // a gets burst
                } else {
                    // both burst
                    st.pop();
                    a = 0;
                }
            }
            if (a != 0)
                st.push(a);
        }
        int[] ans = new int[st.size()];
        for (int i = ans.length - 1; i >= 0; i--)
            ans[i] = st.pop();
        return ans;
    }
}