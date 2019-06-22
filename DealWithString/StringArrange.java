package DealWithString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class StringArrange {
    public static void main(String[] args) {
    	Scanner sc=new Scanner(System.in);
    	String str=sc.nextLine();
    	
		ArrayList<String> list=new StringArrange().Permutation(str);
		for(int i=0;i<list.size();i++){
			if(i==list.size()-1){
				System.out.println(list.get(i));
			}else{
			   System.out.print(list.get(i)+",");
			}
		}
	} 
	
	 public ArrayList<String> Permutation(String str) {
	        ArrayList<String> re = new ArrayList<String>();
	        if (str == null || str.length() == 0) {
	            return re;
	        }
	        HashSet<String> set = new HashSet<String>();
	       
	        fun(set, str.toCharArray(), 0);
	        
	        re.addAll(set);
	        Collections.sort(re);//π§æﬂ¿‡≈≈–Ú
	        return re;
	    }
	    void fun(HashSet<String> re, char[] str, int k) {
	        if (k == str.length) {
	            re.add(new String(str));
	            return;
	        }
	        for (int i = k; i < str.length; i++) {
	            swap(str, i, k);
	            
	            fun(re, str, k + 1);
	            
	            swap(str, i, k);
	        }
	    }
	    void swap(char[] str, int i, int j) {
	        if (i != j) {
	            char t = str[i];
	            str[i] = str[j];
	            str[j] = t;
	        }
	    }
}
