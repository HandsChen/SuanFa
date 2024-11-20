package Top100;

import java.util.*;

public class num_139 {
    public static void main(String[] args) {

        String str="leetcode";
        List<String> wordDict=new ArrayList<String>();
        wordDict.add("leet");
        wordDict.add("code");
        System.out.println(wordBreak(str,wordDict));

    }
    public static boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordDictSet = new HashSet(wordDict);

        //定义状态矩阵，表示s的前i位是否可以用wordDict中的来单词来表示
        boolean[] dp = new boolean[s.length() + 1];
        System.out.println(Arrays.toString(dp));
        //0也可以北表示
        dp[0]=true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
