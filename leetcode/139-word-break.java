import java.util.HashSet;
import java.util.List;

class Solution1 {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>(wordDict);
        HashSet<Integer> rs = new HashSet<>();

        int right = s.length();
        int l = right - 1;
        rs.add(right);

        while (l >= 0) {
            for (int r : rs) {
                String sub = s.substring(l, r);
                System.out.println(right + " "+ l);
                if (set.contains(sub)) {
                    rs.add(l);
                    right = l;
                    break;
                }
            }
            l--;
        }
        System.out.println(right + " "+ l);
        return right == 0;
    }
}

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean dp[] = new boolean[s.length()+1];
        dp[s.length()] = true;

        for(int i = s.length() - 1; i >= 0; i --){
            for(String str : wordDict){
                if(i + str.length() <= s.length() && s.substring(i, i + str.length()).equals(str)){
                    dp[i]  = dp[i + str.length()];
                }
                if(dp[i] == true) break;
            }
        }
        return dp[0];
    }
}