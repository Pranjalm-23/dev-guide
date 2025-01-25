import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> numsIdx = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            numsIdx.put(nums1[i], i);
        }
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);

        Stack<Integer> st = new Stack<>(); // mono decreasing

        for (int i = 0; i < nums2.length; i++) {
            while (!st.isEmpty() && st.peek() < nums2[i]) {
                int v = st.pop();
                ans[numsIdx.get(v)] = nums2[i];
            }
            if (numsIdx.containsKey(nums2[i]))
                st.push(nums2[i]);
        }
        return ans;
    }
}