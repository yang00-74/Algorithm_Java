package com.nathan.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FindPathFromTree {

    /**
     * 目标和为target的路径(回溯法)
     * <p>
     * 需从根节点到叶节点的完整路径
     */
    private List<List<Integer>> result = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> findPath(TreeNode root, Integer target) {
        if (Objects.isNull(root) || target <= 0) {
            return result;
        }
        target -= root.val;
        path.add(root.val);
        if (0 == target && Objects.isNull(root.left) && Objects.isNull(root.right)) {
            result.add(new ArrayList<>(path));
        }

        findPath(root.left, target);
        findPath(root.right, target);

        path.remove(path.size() - 1);
        return result;

    }

}
