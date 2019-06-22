package Others;

public class Fibonacci {

	/**
	 *  쳲�������������
	 * 1.����ʵ��  1 1 2 3 5 8 13....
	 *   a[0]=1,a[1]=1;
	 *   a[x>=2]=a[x-1]+a[x-2];
	 * 
	 * 2.�����仯ʵ��      a   b
	 *                 1   1
	 *                 1   2
	 *                 2   3
	 *                 3   5
	 *                 5   8
	 *   a=1,b=1;
	 *   tem=a;
	 *   a=b;
	 *   b=b+tem;
	 * 3.�ݹ�ʵ��
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
               System.out.println("�ڶ�ʮ�����ǣ�"+fib(20));
             
	}
    public static int fib(int n){
    	if(n==0) return 0;
    	if(n==1||n==2){
    		return 1;
    	}else{
    		return fib(n-1)+fib(n-2);
    	}
    }
}
