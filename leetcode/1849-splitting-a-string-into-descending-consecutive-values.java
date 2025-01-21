import java.math.BigInteger;

class Solution {
    public boolean splitString(String s) {
        for (int i = 0; i < s.length() - 1; i++) {
            BigInteger n = new BigInteger(s.substring(0, i + 1));
            if (dfsBackTrack(s, i + 1, n))
                return true;
        }
        return false;
    }

    private boolean dfsBackTrack(String s, int i, BigInteger pre) {
        if (i == s.length())
            return true;

        for (int j = i; j < s.length(); j++) {
            BigInteger n = new BigInteger(s.substring(i, j + 1));

            if (n.equals(pre.subtract(BigInteger.ONE)) // (n == pre - 1)
                    && dfsBackTrack(s, j + 1, n))
                return true;
        }
        return false;
    }
}