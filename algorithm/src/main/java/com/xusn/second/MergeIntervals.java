package com.xusn.second;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * �ϲ�����
 * ������ intervals ��ʾ���ɸ�����ļ��ϣ����е�������Ϊ intervals[i] = [starti, endi] ������ϲ������ص������䣬������ һ�����ص����������飬��������ǡ�ø��������е��������� ��
 *
 * ʾ�� 1��
 *
 * ���룺intervals = [[1,3],[2,6],[8,10],[15,18]]
 * �����[[1,6],[8,10],[15,18]]
 * ���ͣ����� [1,3] �� [2,6] �ص�, �����Ǻϲ�Ϊ [1,6].
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][];
        }
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> result = new ArrayList<>();
        result.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            int[] lastInterval = result.get(result.size() - 1);
            // ���ص�
            if (current[0] <= lastInterval[1]) {
                lastInterval[1] = Math.max(current[1], lastInterval[1]);
            } else {
                result.add(current);
            }
        }
        return result.toArray(new int[0][]);

    }
}
