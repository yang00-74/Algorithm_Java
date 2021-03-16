package com.nathan.tree;

import java.util.*;

/**
 * 自定义实现二叉树
 */


public class TreeNodeI {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(0);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode _left = new TreeNode(5);
        TreeNode _right = new TreeNode(4);

        root.left = left;
        root.right = right;
        left.left = _left;
        right.right = _right;

        TreeNodeI t = new TreeNodeI();

        ArrayList<ArrayList<Integer>> list = new TreeNodeI().PrintLevelOrder(root);
        for (ArrayList<Integer> l : list) {
            System.out.println(l.toString());
        }

        System.out.println(t.KthNode(root, 4).val);

        String s = t.Serialize(root);//序列化
        t.deSerialize(s);//反序列化

        System.out.println(list.toString());
    }

    //二叉搜索树转化为有序的双向链表
    public TreeNode convertToList(TreeNode root) {
        if (root == null)
            return null;
        if (root.left == null && root.right == null)
            return root;
        // 1.将左子树构造成双链表，并返回链表头节点
        TreeNode left = convertToList(root.left);
        TreeNode p = left;
        // 2.定位至左子树双链表最后一个节点
        while (p != null && p.right != null) {
            p = p.right;
        }
        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
        if (left != null) {
            p.right = root;
            root.left = p;
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

    //序列化二叉树
    public String Serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }
        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));
        return sb.toString();
    }

    //反序列化二叉树
    int index = -1;

    public TreeNode deSerialize(String str) {
        index++;
        String[] s = str.split(",");
        TreeNode node = null;
        while (!s[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(s[index]));
            node.left = deSerialize(str);
            node.right = deSerialize(str);
        }
        return node;
    }

    //查找二叉搜索树的第K小的结点
    public TreeNode KthNode(TreeNode root, int k) {
        int count = 0;
        if (root == null || k < count) return null;

        TreeNode p = root;
        Stack<TreeNode> LDRStack = new Stack<>();

        while (p != null || !LDRStack.isEmpty()) {
            while (p != null) {
                LDRStack.push(p);
                p = p.left;
            }
            TreeNode node = LDRStack.pop();
            count++;
            if (count == k) return node;
            p = node.right;//左结点完毕，遍历右结点

        }
        return null;
    }


    //层次遍历二叉树，打印每一层
    public ArrayList<ArrayList<Integer>> PrintLevelOrder(TreeNode root) {

        ArrayList<ArrayList<Integer>> ret = new ArrayList();
        ArrayList<Integer> tmp = new ArrayList<Integer>();
        LinkedList<TreeNode> q = new LinkedList<TreeNode>();

        if (root == null) return ret;
        q.add(root);

        int now = 1, next = 0;//当前层次结点数now和下一层次结点数next

        while (!q.isEmpty()) {
            TreeNode t = q.remove();
            tmp.add(t.val);
            now--;

            if (t.left != null) {
                q.add(t.left);
                next++;
            }
            if (t.right != null) {
                q.add(t.right);
                next++;
            }

            if (now == 0) {
                ret.add(new ArrayList<Integer>(tmp));
                tmp.clear();
                now = next;
                next = 0;
            }
        }
        return ret;
    }

    //判断一棵树包含另一棵树
    public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
        boolean result = false;
        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
        if (root2 != null && root1 != null) {
            if (root1.val == root2.val) {
                //如果根相同，以这个根节点为为起点判断是否包含Tree2
                result = doesTree1HaveTree2(root1, root2);
            }
            //如果根不同，那么就再去root的左儿子当作起点，去判断是否包含Tree2
            if (!result) {
                result = HasSubtree(root1.left, root2);
            }
            //如果还找不到，那么就再将root的右儿子当作起点，去判断是否包含Tree2
            if (!result) {
                result = HasSubtree(root1.right, root2);
            }
        }
        return result;
    }

    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {
        if (node2 == null) {
            return true;//如果Tree2已经遍历完了都能对应的上，返回true
        }
        if (node1 == null) {
            return false; //如果Tree2还没有遍历完，Tree1却遍历完了。返回false
        }
        if (node1.val != node2.val) {
            return false; //如果其中有一个点没有对应上，返回false
        }
        //如果根节点对应的上，那么就分别去子节点里面匹配
        return doesTree1HaveTree2(node1.left, node2.left) && doesTree1HaveTree2(node1.right, node2.right);
    }

    /**
     * 获取二叉树中两个子节点相距最大距离,可转换为二叉树两子树高度之和的问题
     * Note:根节点两子树高度之和并不一定等于两个子节点相距最大距离,存在相距最远的两子节点在根节点同一子树下的情况,故需变量 max 记录该值
     *  a                                               a
     * / \                                             / \
     * b  c (根节点子树高度之和 = 子节点相距最大距离)          b   c
     *                                               / \
     *                                              d   e
     *                                              /    \
     *                                             f     g (根节点子树高度之和 < 子节点相距最大距离)
     *                                            /       \
     *                                           h        j
     *
     * @return max 全局变量记录最大距离
     */
    public int maxDistanceOfBinaryTree(TreeNode root) {
        getHeight(root);
        return max;
    }

    static int max = 0;

    //获取树高
    private static int getHeight(TreeNode root) {
        if (root == null) return 0;
        int left = getHeight(root.left);
        int right = getHeight(root.right);
        max = Math.max(max, left + right); // 全局变量记录最大距离

        return (left > right) ? left + 1 : right + 1;
    }
}
