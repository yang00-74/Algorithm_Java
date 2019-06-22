package Count;

import java.util.ArrayList;
import java.util.Scanner;

public class CountHuiWenNumber{
  public boolean pandun(int n){
	  int m=n; 
	  String s=String.valueOf(m);
	   char[] ch=s.toCharArray();
	   int len=ch.length;
	   for(int i=0,j=len-1;i<=j;i++,j--){
		   if(ch[i]!=ch[j]){
			   return false;
		   }
	   }
	   return true;
  }
  
  public static void main(String[] args) {
	//输入要求的数，以0为结束
	  Scanner sc=new Scanner(System.in);
	  ArrayList<Integer> list=new ArrayList();
	
	while(sc.hasNext()){
		int f=sc.nextInt();
		if(f==0){	
			break;
		}else{
	      list.add(f);
	    }
	}
	sc.close();
	for(int k=0;k<list.size();k++){
	if(list.get(k)!=0){
		int count=0;
		for(int i=1;i<=list.get(k);i++){
			if(new CountHuiWenNumber().pandun(i)){
				count++;
			}
		}
		System.out.println(count);
	  } 
	}
  }
}
