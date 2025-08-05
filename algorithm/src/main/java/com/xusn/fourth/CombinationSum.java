package com.xusn.fourth;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ܺ�
 *
 * ����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target ���ҳ� candidates �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ��� �������б���ʽ���ء�����԰� ����˳�� ������Щ��ϡ�
 *
 * candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 *
 * ���ڸ��������룬��֤��Ϊ target �Ĳ�ͬ��������� 150 ����
 */
public class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        dfs(candidates, target, 0, path, res);
        return res;
    }

    public void dfs (int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        } else if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            path.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, path, res);
            path.remove(path.size() - 1);
        }
    }
}
