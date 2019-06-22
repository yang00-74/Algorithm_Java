package DealWithString;

import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

public class StringROL {

	public static void main(String[] args) {
		String str="abcdef";
		System.out.println(new StringROL().LeftRotateString(str, 2));
	}
	
	public String LeftRotateString(String str,int n) {
        if(str.length()==0||n==0) return str;
        
        Queue q=new ArrayBlockingQueue(str.length()) ;
        
        char[] a=str.toCharArray();
        int len=a.length;
        for(int i=0;i<len;i++){
            q.add(a[i]);
        }
        
        for(int j=0;j<n;j++){
            q.add(q.poll());
        }
        StringBuilder sb=new StringBuilder();
        for(int k=0;k<len;k++){
            sb.append((char)q.poll());
        }
      return sb.toString();
    }
}
