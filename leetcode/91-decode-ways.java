class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0)
            return 0;

        int n = s.length();

        int[] dp = new int[n + 1];
        // dp[i] = number of ways to decode the string before index i in s
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i <= s.length(); i++) {
            int d1 = Integer.parseInt(s.substring(i - 1, i));
            int d2 = Integer.parseInt(s.substring(i - 2, i));

            if (d1 != 0)
                dp[i] += dp[i - 1];
            if (d2 >= 10 && d2 <= 26)
                dp[i] += dp[i - 2];
        }
        return dp[n];
    }
}