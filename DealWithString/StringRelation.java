package DealWithString;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class StringRelation {
  public static void main(String[] args) {
   System.out.println("�����루��ʽ :1,a,0��");
   Scanner sc=new Scanner(System.in);
   String s=sc.nextLine();
   
   //1,a,0;2,b,1;3,c,2;4,d,2;5,f,3;
   
   String[] str0=s.split(";");//�ֽ��ַ���
   int len=str0.length ;
   if(len<3){
	   System.out.println("incorrect data");
	   return ;
   }
  
   List<char[]> list=new ArrayList();
   for(int i=0;i<len;i++){
	   char c[]=str0[i].toCharArray();//�ѷֽ�õ����ַ���ת�����ַ��������list��
	   list.add(c);
   }
   
   LinkedList list0=new LinkedList();//list0�洢��������ϵ���ַ�
   List<char[]> listz=new ArrayList();//listZ�洢ȫ����������ϵ���ַ�����
   
   int flag=list.size();
   while(flag >1){
	   int n=flag;
	  
	   for(int i=n-1;i>=0;i--){//�Ӻ���ǰ������������ϵ
		  char[] b=list.get(i); //��ȡҪ������ַ����� //1,a,0;
		  if(!list0.contains(b[2])){
			  list0.add(b[2]);
		  }
		  
		  for(int j=i-1;j>=0;j--){
			   char[] a=list.get(j);//��ȡҪ������ַ����� //���磺1,a,0;
			   if(a[0]==b[4]){
				   list0.add(a[2]);
				   i=j;
				   break;
			   }
		   }
		 } 
           //����ֱ�ӽ�list0����listz����Ϊ�������ã��ᱻ�����������ַ��ı�ֵ
	       char[] ca=new char[list0.size()];
	       for(int i=0;i<list0.size();i++){//�ѻ�õ���������ϵ���ַ�ȡ�������ַ�����
	          ca[i]=(char) list0.get(i);
	       }
           listz.add(ca);//�Ѹ��ַ��������listz��
	       list0.clear();//���list0���Ա�洢��һ�ַ����������ַ�
      
	   flag--;//һ�ֲ������
   }
   
 //��ΪҪ������з�������������ϵ������ȡ��listz�����ݽ��д���
	  String[] st = new String[listz.size()];
	  for (int k = 0; k < listz.size();k++){
	   char[] h=listz.get(k);//ȡ��һ�������ַ�����   
	   StringBuilder sb=new StringBuilder(); //����ת��Ϊ�ַ���
	   for(int j=h.length-1;j>=0;j--){
		  sb.append(h[j]+"-");
	   } 
	   st[k]=sb.substring(0, sb.length()-1);//ת������ַ��������ַ���������
   }
   
   for(int x=0;x<st.length;x++){
	   for(int y=0;y<st.length;y++){
		   if(st[x].startsWith(st[y])&& x!=y){
			   st[y]="";//�����в����������ĳ�ȥ ,�� abcf���ڣ���abc���������� 
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
