package DealWithString;
import java.util.Scanner;


public class StringEmail {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("输入邮箱：");
	    String s1=sc.nextLine();
	    new StringEmail().mail(s1);
	}   
	 
	public void mail(String s1){   
	    String[] str0=s1.split("\\.");//根据点分解字符串
	    
	    for(int k=0;k<str0.length;k++){
	       String[] str=str0[k].split("\\@");//再根据@分解子字符串
	       
	       char[] ch=str[0].toCharArray();//转化字符串为字符数组进行操作
	       
	       if(ch.length >2){
	          for(int j=ch.length-1;j>ch.length-4;j--){
	    	    ch[j]='*';
	          }
	       }
	       StringBuilder sb=new StringBuilder();
	       for(int j=0;j<ch.length;j++){
	    	    sb.append(ch[j]);
	        }
	         sb.append("@");
	         if(str.length>1){
	          sb.append(str[1]);     
	          sb.append(".").append(str0[k+1]);
	          System.out.println(sb.toString());
	         }	       	      
	    }
	 }
	 
}
