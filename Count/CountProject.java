package Count;

public class CountProject {
/**
 * ������ִ����Ŀ��k����ʼ�ɱ�w,
 * ��Ŀ�����ַ��� ��1 2 3
 * ��Ŀ�ɱ��ַ����� 0 1 1
 * ����ɻ�õ��������
 */
	public static void main(String[] args) {
		new CountProject().count(3,2,"1 2 3 4","0 1 1 2");
	}
	
	public void count (int k,int w,String profit,String b0){
		int sum=0;
		String[] p=profit.split(" ");
		String []b=b0.split(" ");
		int len=p.length;
		
		int []p1=new int [len];
		int []b1=new int [len];
		int []flag=new int [len];//�����Ŀ״̬������
		
		for(int i=0;i<len;i++){
			p1[i]=Integer.valueOf(p[i]);
			b1[i]=Integer.valueOf(b[i]);
		}		
		while(k>0){
			    int max=0, index=0, f=0;
				
				for(int i=0;i<len;i++){
					if(w>=b1[i]&&max<p1[i]&&flag[i]==0){
						max=p1[i];
						f=i;
				    }
				}
				flag[f]=1;
				w+=max;
				sum+=max;
				k--;
			}				
		System.out.println(sum);
	}
}
