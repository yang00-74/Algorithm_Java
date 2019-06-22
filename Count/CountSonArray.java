package Count;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * 统计一个数组（数组成环）所有子数组的和的最大值
 * @author Administrator
 *
 */

public class CountSonArray {
	public static void main(String[] args) {
		int a[]={1,-2,3,5,-1,2};
	    new CountSonArray().maxSum1(a, 6);
	    
		Scanner sc=new Scanner(System.in);
		
		int n=sc.nextInt();
		int b[]=new int[n];
		
		for(int i=0;i<n;i++){
			b[i]=sc.nextInt();
		}
		  new CountSonArray().maxSum1(b, n);
	}
	
   public void maxSum1(int A[], int n)
	{
	   if (A.length==0 || A==null) {
           return ;
       }
	    int max = -1;
	    int i, j, sum;
	      List list=new ArrayList();
          for(int k=0;k<n;k++){
        	  list.add(A[k]);
          }
	          
	    for(int l=0;l<n;l++){      
		    for(i = 0; i < n; i++){
		          sum = 0;
		          for(j = i; j < n; j++){
		                sum += (int)list.get(j);
		                if(sum > max )
		                       max = sum;
		          }
		    }
		    list.add(list.remove(0));//把第一个元素移至尾部，形成环
	    }
	    System.out.println(max);
	}
}
