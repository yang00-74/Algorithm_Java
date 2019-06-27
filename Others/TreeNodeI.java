package Others;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

 class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
 
    public TreeNode(int val) {
        this.val = val;
 
    }
 
}

public class TreeNodeI {
 
	public static void main(String[] args) {
		TreeNode root=new TreeNode(0);
		TreeNode left=new TreeNode(1);
		TreeNode right=new TreeNode(2);
		TreeNode _left=new TreeNode(5);
		TreeNode _right=new TreeNode(4);
		
		root.left=left;
		root.right=right;
		left.left=_left;
		right.right=_right;
		
		TreeNodeI t=new TreeNodeI();
		
		ArrayList<ArrayList<Integer>> list=new TreeNodeI().PrintLevelOrder(root);
		for(ArrayList<Integer> l:list){		
		  System.out.println(l.toString());
		}
		
		System.out.println(t.IsBalance(root));
		System.out.println(t.KthNode(root, 4).val);
		System.out.println(t.isSymmetrical(root));//判断二叉树是否对称
		
		String s=t.Serialize(root);//序列化
		t.desSerialize(s);//反序列化
		
		list=t.FindPath(root, 6);
		System.out.println(list.toString());
	}
	
//二叉搜索树转化为有序的双向链表
	  public TreeNode Convert(TreeNode root) {
	        if(root==null)
	            return null;
	        if(root.left==null&&root.right==null)
	            return root;
	        // 1.将左子树构造成双链表，并返回链表头节点
	        TreeNode left = Convert(root.left);
	        TreeNode p = left;
	        // 2.定位至左子树双链表最后一个节点
	        while(p!=null&&p.right!=null){
	            p = p.right;
	        }
	        // 3.如果左子树链表不为空的话，将当前root追加到左子树链表
	        if(left!=null){
	            p.right = root;
	            root.left = p;
	        }
	        // 4.将右子树构造成双链表，并返回链表头节点
	        TreeNode right = Convert(root.right);
	        // 5.如果右子树链表不为空的话，将该链表追加到root节点之后
	        if(right!=null){
	            right.left = root;
	            root.right = right;
	        }
	        return left!=null?left:root;       
	    }
	
//目标和为target的路径(回溯法)
	private ArrayList<ArrayList<Integer>> listAll = new ArrayList();
    private ArrayList<Integer> list = new ArrayList();
    
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
        if(root == null) return listAll;
        list.add(root.val);
        target -= root.val;
        if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
        
        FindPath(root.left, target);
        FindPath(root.right, target);
        
        list.remove(list.size()-1);
        return listAll;
	    }
	
//序列化二叉树
	public String Serialize(TreeNode root){
		StringBuilder sb=new StringBuilder();
		if(root==null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		return sb.toString();
	}
//反序列化二叉树
	int index=-1;
	public TreeNode desSerialize(String str){
		index++;
		String []s=str.split(",");
		TreeNode node=null;
		while(!s[index].equals("#")){
			node=new TreeNode(Integer.valueOf(s[index]));
			node.left=desSerialize(str);
			node.right=desSerialize(str);
		}
		return node;
	}
	
//判断二叉树是否对称
	public boolean isSymmetrical(TreeNode root){
		if(root==null) return true;
		return compareTree(root.left,root.right);
	}
	private boolean compareTree(TreeNode left, TreeNode right) {
		if(left==null) return right==null;
		if(right==null) return false;
		if(left.val!=right.val) return false;
		//比较对称的子树
		return  compareTree(left.left, right.right)
				&&compareTree(left.right, right.left);
	}

//查找二叉搜索树的第K大的结点
    public TreeNode KthNode(TreeNode root, int k)
    {   int count=0;
        if(root==null||k<count) return null;
         
        TreeNode p=root;
        Stack<TreeNode> LDRStack = new Stack<TreeNode>();
  
        while(p!=null||!LDRStack.isEmpty()){
            while(p!=null){
                LDRStack.push(p);
                p=p.left;
            }
            TreeNode node = LDRStack.pop();
            count++;
            if(count==k) return node;
            p=node.right;//左结点完毕，遍历右结点
            
        }
        return null;
    }

	
//层次遍历二叉树，打印每一层
	 public ArrayList<ArrayList<Integer> > PrintLevelOrder(TreeNode root) {
		    
	        ArrayList<ArrayList<Integer>> ret = new ArrayList();
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
	        
	        if(root==null) return ret;
	            q.add(root);
	            
	        int now=1,next=0;//当前层次结点数now和下一层次结点数next
	        
	         while(!q.isEmpty()){
	             TreeNode t=q.remove();
	              tmp.add(t.val);
	              now--;
	            
	             if(t.left!=null){
	                 q.add(t.left);
	                 next++;
	             }
	             if(t.right!=null){
	                 q.add(t.right);
	                 next++;
	             }   
	             
	             if(now==0){
	                 ret.add(new ArrayList<Integer>(tmp));
	                 tmp.clear();
	                 now=next;
	                 next=0;
	             }
	         }
	        return ret;        
	    }
	
//判断一棵树包含另一棵树
	 public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
	        boolean result = false;
	        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
	        if (root2 != null && root1 != null) {
	            if(root1.val == root2.val){
	                //如果根相同，以这个根节点为为起点判断是否包含Tree2
	                result = doesTree1HaveTree2(root1,root2);
	            }
	            //如果根不同，那么就再去root的左儿子当作起点，去判断是否包含Tree2
	            if (!result) {
	                result = HasSubtree(root1.left,root2);
	            }            
	          //如果还找不到，那么就再将root的右儿子当作起点，去判断是否包含Tree2
	            if (!result) {
	                result = HasSubtree(root1.right,root2);
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
	        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
	    }
		
//判断二叉树是否平衡（左右子树高度之差小于等于1）
	public static boolean IsBalance(TreeNode root){
		if(root==null) return true;
		if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
			return false;
		}
		return IsBalance(root.left)&&IsBalance(root.right);
	}
//获取树高
	private static int getHeight(TreeNode root) {
		if(root==null) return 0;
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		
		return (left>right)? left+1:right+1;
	}
//从上往下打印树,深度遍历
	 public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
         ArrayList<Integer> list = new ArrayList<Integer>();
         if(root == null) return list;
         Deque<TreeNode> deque = new LinkedList();
         
         deque.add(root);
         while(!deque.isEmpty()){
             TreeNode t = deque.pop();
             list.add(t.val);
             if(t.left != null) deque.add(t.left);
             if(t.right != null) deque.add(t.right);
         }
         return list;
     }

     // 前序遍历二叉树, 栈结构,将 root 压入,出栈,然后将 右子节点 左子节点压入
	public ArrayList<Integer> preOrder(TreeNode root) {
		if (root == null) return null;
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		ArrayList<Integer> result = new ArrayList<>();
		while (!stack.isEmpty()) {
			TreeNode current = stack.pop();
			result.add(current.val);

			if (null!= current.right) {
				stack.push(current.right);
			}
			if (null!= current.left) {
				stack.push(current.left);
			}
		}
		return result;
	}

	// 中序遍历二叉树,先将左节点压入栈,当节点为 null,栈顶元素出栈,遍历出栈元素的右节点
    public ArrayList inOrder(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        ArrayList<Integer> result = new ArrayList<>();
        while (null != root || !stack.isEmpty()) {
            if (null != root) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                result.add(root.val);
                root = root.right;

            }
        }
        return result;
	}

	// 后序遍历二叉树,两个栈实现
    public  ArrayList<Integer> sufOrder(TreeNode root) {
        if (root == null) return null;
        Stack<TreeNode> current = new Stack<>();
        Stack<TreeNode> back = new Stack<>();
        current.push(root);

        while(!current.isEmpty()) {
            TreeNode node = current.pop();
            back.push(node);

            if (null != node.left) {
                current.push(node.left);
            }

            if(null != node.right) {
                current.push(node.right);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while (!back.isEmpty()) {
            TreeNode node = back.pop();
            result.add(node.val);
        }
        return result;
    }

}
