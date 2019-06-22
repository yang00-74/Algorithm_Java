package DealWithString;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringFindMaxLengthNumber {
	public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(" ‰»Î£∫");
        String s2=sc.nextLine();
        String s1 = findMaxLength(s2);
        System.out.println(s1);
	}
	
	public static String findMaxLength(String s) {
		if(null == s && s.length() <=0 ) return "";
		int count = 0;
		String s0 = new String();
		Pattern p = Pattern.compile("[0-9]*");
		Matcher m = p.matcher(s);
		while(m.find()){
			String ss = m.group();
			int temp = ss.length();
			if(count <= temp ) {
				count = temp;
				s0 = ss;
			}
		}
		if(null != s0){
		   return s0.toString() + "," + count;
		}
	    return "";
	}
}
