package com.nathan.tree;

import java.util.Stack;

public class BSTToDoublyList426 {
    /**
     * 将二叉搜索树转换成一个排序的循环双向链表。要求不能创建任何新的节点，只能调整树中节点指针的指向
     *
     * 思路：二叉搜索树中序遍历即为有序
     * */
    public TreeNode treeToDoublyList(TreeNode root) {
        if (null == root) {
            return root;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode tail = null;
        TreeNode head = null;
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                // 保存链表头节点
                if (null == head) {
                    head = root;
                }
                // tail 作为双向链表当前的尾节点
                if (null != tail) {
                    tail.right = root;
                    root.left = tail;
                }
                tail = root;
                root = root.right;
            }
        }

        // 最后头尾节点也需要互相指向
        if (null != head) {
            head.left = tail;
            tail.right = head;
        }

        return head;
    }


    // 二叉搜索树转化为有序的双向链表
    public TreeNode convertToList(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = convertToList(root.left);
        TreeNode head = left;
        // 2.定位至左子树双链表最后一个节点
        while (head != null && head.right != null) {
            head = head.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            head.right = root;
            root.left = head;
        }
        // 4.将右子树构造成双链表，并返回链表头节点
        TreeNode right = convertToList(root.right);
        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
        if (right != null) {
            right.left = root;
            root.right = right;
        }
        return left != null ? left : root;
    }

}
