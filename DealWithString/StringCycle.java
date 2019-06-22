package DealWithString;

public class StringCycle {
       public static void main(String[] args) {
		String s="lkjljkm";
		char[] c=s.toCharArray();
		int len=c.length-1;
	
		
		for(int start=0,end1=len;start<=len&&end1>=0;start++,end1--){
			if(c[start]!=c[end1]){
				System.out.println("不是回文");
				return;
			}
		}
		System.out.println("是回文");
	} 
}
