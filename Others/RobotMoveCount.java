package Others;
/**
 * ������ÿ����һ����������x*y���������ܴﵽ�ĸ�����
 * @author Administrator
 *
 */
public class RobotMoveCount {
    public static void main(String[] args) {
		System.out.println(new RobotMoveCount().moveingCount(16, 10, 10));
	} 
	
	
	public int moveingCount(int k,int x,int y){
		if(k<=0) return 0;//���ж�k�Ƿ�Ϸ�
		boolean[][] b=new boolean[x][y];//�������
		//��ʼ���������
		b[0][0]=true;
		for(int i=1;i<x;i++){
			if(b[i-1][0]&&canReach(k,i,0)){//ÿ��ֻ���ƶ�һ�񣬹ʵ���ʱ��ǰһ�����뵽��
				b[i][0]=true;
			}else{
				b[i][0]=false;
			}
		}
		for(int i=1;i<y;i++){
			if(b[0][i-1]&&canReach(k,0,i)){//ÿ��ֻ���ƶ�һ�񣬹ʵ���ʱ��ǰһ�����뵽��
				b[0][i]=true;
			}else{
				b[0][i]=false;
			}
		}
		
		//�ж��䲻���������ϵĿɴ����
		for(int i=1;i<x;i++){
			for(int j=1;j<y;j++){
				if(b[i][j-1]&&canReach(k, i, j)||b[i-1][j]&&canReach(k, i, j)){
					b[i][j]=true;
				}else{
					b[i][j]=false;
				}
			}
		}
		
		//ͳ�ƿɴ�ĸ�����
		int count=0;
		for(int i=0;i<x;i++){
			for(int j=0;j<y;j++){
				if(b[i][j]==true)
					count++;
			}
		}
		
		return count;
		
	}

	private boolean canReach(int k, int i, int j) {
		int sum=0;
		while(i>0){
			sum+=i%10;
			i=i/10;
		}
		while(j>0){
			sum+=j%10;
			j=j/10;
		}
		return sum<=k;
	}
}
