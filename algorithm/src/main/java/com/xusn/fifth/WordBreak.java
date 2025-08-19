package com.xusn.fifth;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * ���ʲ��
 *
 * ����һ���ַ��� s ��һ���ַ����б� wordDict ��Ϊ�ֵ䡣������������ֵ��г��ֵ�һ����������ƴ�ӳ� s �򷵻� true��
 *
 * ע�⣺��Ҫ���ֵ��г��ֵĵ���ȫ����ʹ�ã������ֵ��еĵ��ʿ����ظ�ʹ�á�
 *
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        // dp[i]��ʾs��ǰi���ַ��Ƿ����ֵ����
        boolean[] dp = new boolean[s.length() + 1];
        // ���ַ����ܱ����
        dp[0] = true;
        // i�ķ�Χ����Ҫ
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
