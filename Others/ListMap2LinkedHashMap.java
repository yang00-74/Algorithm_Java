package Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class ListMap2LinkedHashMap {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Scanner sc0=new Scanner(System.in);
		System.out.println("输入cache容量和命令行数：");
		int n=sc.nextInt();
		int m=sc.nextInt();
	    int count=0;
		ListMap2LinkedHashMap t=new ListMap2LinkedHashMap();
		
		System.out.println("输入命令：");
		while(sc0.hasNextLine()){
			String str=sc0.nextLine();
			String s[]=str.split(" "); 
				
			if(s[0].equals("put")){
				t.put(s[1], s[2], n);
			}else if(s[0].equals("get")){
				t.get(s[1]);
			} else{
				System.out.println("数据不合法,结束");
				return ;
			}
			count++;
			if(count==m) break;
		}
		
		
//		new Main().put("a","b",n);
//		new Main().put("c","c",n);
//		new Main().put("v","v",n);
//		new Main().put("d","d",n);
//		new Main().get("a");
	}
	
	static ArrayList<HashMap> list= new ArrayList();
	
	public void put(String a,String b,int n){
		HashMap<String,String> map=new HashMap();
		map.put(a, b);
		if(list.size()<n){
		    list.add(map);
		}else{
			list.remove(0);
			list.add(map);
		}
	}
	
	public void get(String a){
		String s=null;
		for(HashMap m:list){
			s=(String) m.get(a);
			if(s!=null) break;
		}
		System.out.println(s);
	}
}
