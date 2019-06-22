package DealWithString;
/**
 * 把输入的带符号字符串转化为int整数
 * @author Administrator
 *
 */
public class String2Int {
    public static void main(String[] args) {
		String s="-7894";
		System.out.println(new String2Int().strToInt(s));
	}
	
	public int strToInt (String s){
		if(s==null||s.equals(" ")){
			return 0;
		}
		char[] c=s.toCharArray();
		int huhao=1;
		int INT=0;
		for(int i=0;i<c.length ;i++){
			
			if(c[i]=='-'){
				huhao=-1;
				continue;
			}
			if(c[i]=='+'){
				continue;
			}
			if(c[i]<'0'||c[i]>'9'){
				return 0;
			}
			
			INT=INT*10+c[i]-48;//转换成int数
		}
		
		return huhao==-1?INT*-1:INT;
	}
}
