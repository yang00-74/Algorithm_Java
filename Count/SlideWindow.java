package Count;

import java.util.ArrayList;
import java.util.List;

public class SlideWindow {
	public static void main(String[] args) {
		int a[]={2,3,4,2,6,2,5,1};
		int size=3;
		new SlideWindow().maxInWindows(a,3);
	}

	public ArrayList<Integer> maxInWindows(int [] num, int size){   
		
		if(num==null||size<0){
			return null;
		}
		
        List list0=new ArrayList();
        if(size==0){
        	return (ArrayList<Integer>) list0;
        }
        
        int len=num.length;
        List list=new ArrayList<Integer>();
        for(int i=0;i<len;i++){
            list.add(num[i]);
        }
        
        while(list.size()>=size){
             int max=0; 
            for(int j=0;j<size;j++){
                if(max<(int)list.get(j)){
                    max=(int)list.get(j);
                }
            }
            System.out.print(max);
            list0.add(max);
            list.remove(0);
        }
        
            return (ArrayList<Integer>) list0;
    }
}
