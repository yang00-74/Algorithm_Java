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
		System.out.println(t.isSymmetrical(root));//�ж϶������Ƿ�Գ�
		
		String s=t.Serialize(root);//���л�
		t.desSerialize(s);//�����л�
		
		list=t.FindPath(root, 6);
		System.out.println(list.toString());
	}
	
//����������ת��Ϊ�����˫������
	  public TreeNode Convert(TreeNode root) {
	        if(root==null)
	            return null;
	        if(root.left==null&&root.right==null)
	            return root;
	        // 1.�������������˫��������������ͷ�ڵ�
	        TreeNode left = Convert(root.left);
	        TreeNode p = left;
	        // 2.��λ��������˫�������һ���ڵ�
	        while(p!=null&&p.right!=null){
	            p = p.right;
	        }
	        // 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
	        if(left!=null){
	            p.right = root;
	            root.left = p;
	        }
	        // 4.�������������˫��������������ͷ�ڵ�
	        TreeNode right = Convert(root.right);
	        // 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
	        if(right!=null){
	            right.left = root;
	            root.right = right;
	        }
	        return left!=null?left:root;       
	    }
	
//Ŀ���Ϊtarget��·��(���ݷ�)
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
	
//���л�������
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
//�����л�������
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
	
//�ж϶������Ƿ�Գ�
	public boolean isSymmetrical(TreeNode root){
		if(root==null) return true;
		return compareTree(root.left,root.right);
	}
	private boolean compareTree(TreeNode left, TreeNode right) {
		if(left==null) return right==null;
		if(right==null) return false;
		if(left.val!=right.val) return false;
		//�Ƚ϶ԳƵ�����
		return  compareTree(left.left, right.right)
				&&compareTree(left.right, right.left);
	}

//���Ҷ����������ĵ�K��Ľ��
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
            p=node.right;//������ϣ������ҽ��
            
        }
        return null;
    }

	
//��α�������������ӡÿһ��
	 public ArrayList<ArrayList<Integer> > PrintLevelOrder(TreeNode root) {
		    
	        ArrayList<ArrayList<Integer>> ret = new ArrayList();
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        LinkedList<TreeNode> q = new LinkedList<TreeNode>();
	        
	        if(root==null) return ret;
	            q.add(root);
	            
	        int now=1,next=0;//��ǰ��ν����now����һ��ν����next
	        
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
	
//�ж�һ����������һ����
	 public static boolean HasSubtree(TreeNode root1, TreeNode root2) {
	        boolean result = false;
	        //��Tree1��Tree2����Ϊ���ʱ�򣬲Ž��бȽϡ�����ֱ�ӷ���false
	        if (root2 != null && root1 != null) {
	            if(root1.val == root2.val){
	                //�������ͬ����������ڵ�ΪΪ����ж��Ƿ����Tree2
	                result = doesTree1HaveTree2(root1,root2);
	            }
	            //�������ͬ����ô����ȥroot������ӵ�����㣬ȥ�ж��Ƿ����Tree2
	            if (!result) {
	                result = HasSubtree(root1.left,root2);
	            }            
	          //������Ҳ�������ô���ٽ�root���Ҷ��ӵ�����㣬ȥ�ж��Ƿ����Tree2
	            if (!result) {
	                result = HasSubtree(root1.right,root2);
	               }
	            }
	        return result;
	    }
	 
	    public static boolean doesTree1HaveTree2(TreeNode node1, TreeNode node2) {        
	        if (node2 == null) {
	            return true;//���Tree2�Ѿ��������˶��ܶ�Ӧ���ϣ�����true
	        }	       
	        if (node1 == null) {
	            return false; //���Tree2��û�б����꣬Tree1ȴ�������ˡ�����false
	        }       
	        if (node1.val != node2.val) {  
	                return false; //���������һ����û�ж�Ӧ�ϣ�����false
	        }	         
	        //������ڵ��Ӧ���ϣ���ô�ͷֱ�ȥ�ӽڵ�����ƥ��
	        return doesTree1HaveTree2(node1.left,node2.left) && doesTree1HaveTree2(node1.right,node2.right);
	    }
		
//�ж϶������Ƿ�ƽ�⣨���������߶�֮��С�ڵ���1��
	public static boolean IsBalance(TreeNode root){
		if(root==null) return true;
		if(Math.abs(getHeight(root.left)-getHeight(root.right))>1){
			return false;
		}
		return IsBalance(root.left)&&IsBalance(root.right);
	}
//��ȡ����
	private static int getHeight(TreeNode root) {
		if(root==null) return 0;
		int left=getHeight(root.left);
		int right=getHeight(root.right);
		
		return (left>right)? left+1:right+1;
	}
//�������´�ӡ��,��ȱ���
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

     // ǰ�����������, ջ�ṹ,�� root ѹ��,��ջ,Ȼ�� ���ӽڵ� ���ӽڵ�ѹ��
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

	// �������������,�Ƚ���ڵ�ѹ��ջ,���ڵ�Ϊ null,ջ��Ԫ�س�ջ,������ջԪ�ص��ҽڵ�
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

	// �������������,����ջʵ��
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
