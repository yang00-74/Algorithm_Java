package Count;

import java.util.ArrayList;
import java.util.List;
/**
 * 统计一个数以内的3个质数之和等于该数的组合
 * @author Administrator
 *
 */
public class CountPrimeNumber {
    public static void main(String[] args) {
	          CountPrimeNumber c=new CountPrimeNumber();
	          c.count(15);
	}  
    private void count(int number){
		if(number==1||number==2){
			return ;
		}
		int count=0;

    	List list=new ArrayList();
    	list.add(0, 2);
    	int index=1;
         boolean flag=false;
    	
    	for(int i=3;i<number;i++){
    			
    	   for(int k=2;k<i;k++){
    		   if(i%k==0){
                 //一旦检查到i为合数，则将flag置为false，并跳出循环
                   flag=false;
                   break;
    		   }
    		      flag=true;
    		}
    	   if(flag==true){
    		   list.add(index,i);
    		   index++;
    	   }
    	}
    	
    	int len=list.size();
    	for(int i=0;i<len;i++){
    		for(int j=0;j<len;j++){
    			for(int k=0;k<len;k++){
    	    		if(list.get(i)!=list.get(j)&&list.get(i)!=list.get(k)&&list.get(k)!=list.get(j)
    	    				&&(int)list.get(i)+(int)list.get(j)+(int)list.get(k)==number){
    	    			
    	    			System.out.println(list.get(i)+" "+list.get(j)+" "+list.get(k));
    	    			count++;    	    			
    	    		}
    	    	}
        	}
    	}
    	System.out.println(count);    	
    }
}
