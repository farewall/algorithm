package com.xusn.fifth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 单词拆分
 *
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 *
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // dp[i]表示s的前i个字符是否由字典组成
        boolean[] dp = new boolean[s.length() + 1];
        // 空字符串能被拆分
        dp[0] = true;
        // i的范围很重要
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
