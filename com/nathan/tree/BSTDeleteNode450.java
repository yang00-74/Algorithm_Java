package com.nathan.tree;

public class BSTDeleteNode450 {
    /**
     * 删除二叉搜索树的指定节点
     *
     * 有以下五种情况：
     *
     * 第一种情况：没找到删除的节点，遍历到空节点直接返回了
     * 找到删除的节点
     * 第二种情况：左右孩子都为空（叶子节点），直接删除节点， 返回NULL为根节点
     * 第三种情况：删除节点的左孩子为空，右孩子不为空，删除节点，右孩子补位，返回右孩子为根节点
     * 第四种情况：删除节点的右孩子为空，左孩子不为空，删除节点，左孩子补位，返回左孩子为根节点
     * 第五种情况：左右孩子节点都不为空，则将删除节点的左子树头结点（左孩子）放到删除节点的右子树的最左面节点的左孩子上，返回删除节点右孩子为新的根节点。
     * */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        if (key == root.val) {
            if (null == root.left) {
                return root.right;
            } else if (null == root.right) {
                return root.left;
            } else {
                TreeNode cur = root.right;
                while (null != cur.left) {
                    cur = cur.left;
                }
                cur.left = root.left;
                return root.right;
            }
        }
        if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        if (root.val < key) {
            root.right = deleteNode(root.right, key);

        }
        return root;
    }

    public TreeNode deleteNode2(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        TreeNode cur = root;
        TreeNode pre = null;
        while (null != cur) {
            if (key == cur.val) {
                break;
            }
            pre = cur;
            if (key > cur.val) {
                cur = cur.right;
            }
            if (key < cur.val) {
                cur = cur.left;
            }
        }
        if (null == pre) {
            return removeOneNode(cur);
        }
        // 可能没有目标节点，所以需判空
        if (null != pre.left && pre.left.val == key) {
            pre.left = removeOneNode(pre.left);
        }
        if (null != pre.right && pre.right.val == key) {
            pre.right = removeOneNode(pre.right);
        }
        return root;
    }

    public TreeNode removeOneNode(TreeNode node) {
        if (null == node) {
            return null;
        }
        if (null == node.left) {
            return node.right;
        } else if (null == node.right) {
            return node.left;
        } else {
            // 将被删除节点的左节点挂在其右子树最左节点上
            TreeNode cur = node.right;
            while (null != cur.left) {
                cur = cur.left;
            }
            cur.left = node.left;
            return node.right;
        }
    }
}
