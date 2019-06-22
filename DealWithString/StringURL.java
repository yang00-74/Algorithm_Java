package DealWithString;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringURL {
	public static int getIpFromUrl(String url) {  
        // 1.判断是否为空  
        if (url == null || url.trim().equals("")) {  
            return -1;  
        }  
          
        String host = "";  
        Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+");  
        Matcher matcher = p.matcher(url);  
        if (matcher.find()) {  
            host = matcher.group();  
        }  
        System.out.print(host+",");
        return -1;  
    }  
      
    /** 
     * 从url中分析出hostIP:PORT<br/> 
      */  
    public static int getIpPortFromUrl(String url) {  
        // 1.判断是否为空  
        if (url == null || url.trim().equals("")) {  
            return -1;  
        }  
          
        String host = "";  
        Pattern p = Pattern.compile("(?<=//|)((\\w)+\\.)+\\w+(:\\d{0,5})?");  
        Matcher matcher = p.matcher(url);  
        if (matcher.find()) {  
            host = matcher.group() ;  
        }  
          
        // 如果  
        if(host.contains(":") == false){  
           return -1;  
        }           
        String[] ipPortArr = host.split(":");  
        System.out.println(ipPortArr[1]);
		return 0;
    }  
      
    public static void main(String [] args){  
 //       String url = "http://www.sangfor.com:8080/login.action"; 
        Scanner sc=new Scanner(System.in);
        String url=sc.nextLine();
        StringURL.getIpFromUrl(url);
        StringURL.getIpPortFromUrl(url);
        
      
    }  
}
