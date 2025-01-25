import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String s = "";
        path += '/';

        for (int i = 0; i < path.length(); i++) {
            char c = path.charAt(i);
            if (c == '/') {
                if (s.equals("..")) {
                    if (!st.isEmpty())
                        st.pop();
                } else if (!s.equals("") && !s.equals(".")) {
                    st.push(s);
                }
                s = "";
            } else {
                s += c;
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!st.isEmpty()) {
            ans.insert(0, "/" + st.pop());
        }

        return ans.length() > 0 ? ans.toString() : "/";
    }
}