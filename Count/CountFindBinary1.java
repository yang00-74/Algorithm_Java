package Count;
/**
 * 找到整数的二进制数中1出现的次数
 * @author Administrator
 *
 */
public class CountFindBinary1 {
  public static void main(String[] args) {
	System.out.println(numberOfOne(15));
	
}
	
	public static int numberOfOne(int n){
		int count=0;
		char[] c=Integer.toBinaryString(n).toCharArray();
		
		for(int i=0;i<c.length;i++){
			if(c[i]==49){
				count++;
			}
		}
		return count;
	}
}
