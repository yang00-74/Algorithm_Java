package com.nathan.others;

/**
 * 机器人每次走一步，求其在x*y的坐标内能达到的格子数
 * @author Administrator
 *
 */
public class RobotMoveCount {
    public static void main(String[] args) {
		System.out.println(new RobotMoveCount().moveingCount(16, 10, 10));
	} 
	
	
	public int moveingCount(int k,int x,int y){
		if(k<=0) return 0;//先判断k是否合法
		boolean[][] b=new boolean[x][y];//标记数组
		//初始化标记数组
		b[0][0]=true;
		for(int i=1;i<x;i++){
			if(b[i-1][0]&&canReach(k,i,0)){//每次只能移动一格，故到达时其前一个必须到达
				b[i][0]=true;
			}else{
				b[i][0]=false;
			}
		}
		for(int i=1;i<y;i++){
			if(b[0][i-1]&&canReach(k,0,i)){//每次只能移动一格，故到达时其前一个必须到达
				b[0][i]=true;
			}else{
				b[0][i]=false;
			}
		}
		
		//判断其不在坐标轴上的可达格子
		for(int i=1;i<x;i++){
			for(int j=1;j<y;j++){
				if(b[i][j-1]&&canReach(k, i, j)||b[i-1][j]&&canReach(k, i, j)){
					b[i][j]=true;
				}else{
					b[i][j]=false;
				}
			}
		}
		
		//统计可达的格子数
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
