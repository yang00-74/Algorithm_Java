
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringRelation {

	/**
	 * 建立链表来确定各个节点互相的依赖关系
	 * */
	public class Node{
		public int currentCatgroy;
		public int parentCatgory;
		public String key;
		public Node[] next;

		public Node(int currentCatgroy, int parentCatgory, String key) {
			this.currentCatgroy = currentCatgroy;
			this.parentCatgory = parentCatgory;
			this.key = key;
		}

		public Node(){}

	}
  public static void main(String[] args) {
   System.out.println("请输入（格式 :1,a,0）");
   Scanner sc=new Scanner(System.in);
   String s=sc.nextLine();

   //1,a,0;2,b,1;3,c,2;4,d,2;5,f,3;

   String[] str0=s.split(";");//分解字符串
   int len=str0.length ;
   if(len<3){
	   System.out.println("incorrect data");
	   return ;
   }

   List<char[]> list=new ArrayList();
   for(int i=0;i<len;i++){
	   char c[]=str0[i].toCharArray();//把分解得到的字符串转化成字符数组存于list中
	   list.add(c);
   }

   LinkedList list0=new LinkedList();//list0存储成依赖关系的字符
   List<char[]> listz=new ArrayList();//listZ存储全部有依赖关系的字符数组

   int flag=list.size();
   while(flag >1){
	   int n=flag;

	   for(int i=n-1;i>=0;i--){//从后往前遍历找依赖关系
		  char[] b=list.get(i); //获取要处理的字符数组 //1,a,0;
		  if(!list0.contains(b[2])){
			  list0.add(b[2]);
		  }

		  for(int j=i-1;j>=0;j--){
			   char[] a=list.get(j);//获取要处理的字符数组 //例如：1,a,0;
			   if(a[0]==b[4]){
				   list0.add(a[2]);
				   i=j;
				   break;
			   }
		   }
		 }
           //不能直接将list0存入listz，因为它是引用，会被后续的依赖字符改变值
	       char[] ca=new char[list0.size()];
	       for(int i=0;i<list0.size();i++){//把获得的有依赖关系的字符取出存入字符数组
	          ca[i]=(char) list0.get(i);
	       }
           listz.add(ca);//把该字符数组存入listz中
	       list0.clear();//清空list0，以便存储下一轮符合条件的字符

	   flag--;//一轮查找完毕
   }

 //因为要输出所有符合条件依赖关系，故需取出listz中数据进行处理
	  String[] st = new String[listz.size()];
	  for (int k = 0; k < listz.size();k++){
	   char[] h=listz.get(k);//取出一个依赖字符数组
	   StringBuilder sb=new StringBuilder(); //将其转化为字符串
	   for(int j=h.length-1;j>=0;j--){
		  sb.append(h[j]+"-");
	   }
	   st[k]=sb.substring(0, sb.length()-1);//转化后的字符串放入字符串数组中
   }

   for(int x=0;x<st.length;x++){
	   for(int y=0;y<st.length;y++){
		   if(st[x].startsWith(st[y])&& x!=y){
			   st[y]="";//将其中不符合条件的除去 ,如 abcf存在，则abc不符合条件
		   }
	   }
   }
   for(int a=0;a<st.length;a++){
	   if(!st[a].equals("")){
		   System.out.println(st[a]);
	   }
   }
 }
}
