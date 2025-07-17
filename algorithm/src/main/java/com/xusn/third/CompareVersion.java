package com.xusn.third;

/**
 * �Ƚϰ汾��
 *
 * �������� �汾���ַ��� version1 �� version2 ������Ƚ����ǡ��汾���ɱ��� '.' �ֿ����޶�����ɡ��޶��ŵ�ֵ ���� ת��Ϊ���� ������ǰ���㡣
 *
 * �Ƚϰ汾��ʱ���밴 �����ҵ�˳�� ���αȽ����ǵ��޶��š��������һ���汾�ַ������޶��Ž��٣���ȱʧ���޶�����Ϊ 0��
 *
 * ��� version1 < version2 ���� -1��
 * ��� version1 > version2 ���� 1��
 * ����֮�ⷵ�� 0��
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
