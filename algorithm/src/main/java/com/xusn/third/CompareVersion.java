package com.xusn.third;

/**
 * 比较版本号
 *
 * 给你两个 版本号字符串 version1 和 version2 ，请你比较它们。版本号由被点 '.' 分开的修订号组成。修订号的值 是它 转换为整数 并忽略前导零。
 *
 * 比较版本号时，请按 从左到右的顺序 依次比较它们的修订号。如果其中一个版本字符串的修订号较少，则将缺失的修订号视为 0。
 *
 * 如果 version1 < version2 返回 -1，
 * 如果 version1 > version2 返回 1，
 * 除此之外返回 0。
 */
public class CompareVersion {

    public static int compareVersion (String version1, String version2) {
        String[] version1Array = version1.split("\\.");
        String[] version2Array = version2.split("\\.");
        int size = Math.max(version1Array.length, version2Array.length);

        for (int i = 0; i < size; i++) {
            int subversion1 = i < version1Array.length ? Integer.parseInt(version1Array[i]) : 0;
            int subversion2 = i < version2Array.length ? Integer.parseInt(version2Array[i]) : 0;

            if (subversion1 < subversion2) {
                return -1;
            } else if (subversion1 > subversion2) {
                return 1;
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(compareVersion("1.2", "1.10"));
    }
}
