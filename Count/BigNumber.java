
import java.math.BigDecimal;
import java.util.Scanner;

public class BigNumber {
   public static void main(String[] args) {
	   Scanner sc=new Scanner(System.in);
	   BigDecimal a = sc.nextBigDecimal();
	   BigDecimal b = sc.nextBigDecimal();
	   System.out.println(BigNumber.getMultiple(a, b));
	
   }
   
   public static BigDecimal getMultiple(BigDecimal a ,BigDecimal b) {
	   return a.multiply(b);   
   }
}
