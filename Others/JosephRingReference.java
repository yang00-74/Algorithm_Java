package Others;
/**
 * Լɪ���������⣬����������Ϊ1��ĳ�˱����У�����-1��Ϊ�����
 * ��ĳ����������̭�ˣ�������1��ֻ��һ�Σ�
 * �ж����ʣ�µ���˭
 * @author Administrator
 *
 */
public class JosephRingReference {
   public static void main(String[] args) {
	new JosephRingReference().count(9, 3);
  }
	
	public void count(int N,int M){
		 
		 int rs[]=new int[N];
		 boolean flag[]=new boolean[N];
		 
		  for(int i=0;i<N;i++){ //��ʼ��������飬ÿ��������Ϊ1
		   rs[i]=1;
		   flag[i]=true;
		  }
		  
		  int n=N;//ʣ�������������M���˳���
		  int m=0;//�����ı��,��ʼΪ0,
		  
		  while(n>1){
		   for(int j=0;j<N;j++){
		    if(rs[j]!=0){//�����ж�ĳ���Ƿ���֣���������������
		      m++;
		      if(m==M){
			      m=0;
			      if(n>1){//�жϱ���M=1ʱһ��ѭ���Ͱ�ȫ������̭
		    	      rs[j]=rs[j]-1;//�㵽��������ֵ-1
		    	      if(rs[j]==0){
		    	         n--;
		    	      }
			       }
		        }
	         }
           }
		   //��ĳ�����߽��ڶ����֣�������+1,��һ�κ�flag��Ϊfalse
		  //����β��λ�õ��ж�
		   if(rs[0]==0&&rs[N-1]!=0&&rs[N-2]==0){
			   if(flag[N-1]==true){
			     rs[N-1]+=1;
			     flag[N-1]=false;
			   }
		   }
		   //����ͷ��λ�õ��ж�
		   if(rs[0]!=0&&rs[N-1]==0&&rs[1]==0){
			   if(flag[0]==true){
			     rs[0]+=1;
			     flag[0]=false;
			   }
		   }
		   for(int i=1;i<N-1;i++){
			   if(rs[i-1]==0&&rs[i+1]==0&&rs[i]!=0){
				   if(flag[i]==true){
				     rs[i]+=1;
				     flag[i]=false;
				   }
			   }
		   }
		   
         }
		  //������µ���
		  for(int k=0;k<N;k++){ 
			   if(rs[k]>=1){
			    System.out.println("������µ��ǵ�"+(k+1)+"�š�");
			    break;
			    
			   }
		  }
	}
}
