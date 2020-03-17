package Algorithm;

public class dynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {1,4,3}; //物品的重量
		int[] val = {1500,3000,2000};
		int n = val.length; //物品的个数
		int m = 4;//背包容量
		//为了计入放入商品的情况，定义二维数组
		int[][] path = new int[n+1][m+1];
		
		
		//创建二维数组 v v[i][j]表示在前i个物品中能够装入容量我ij的背包中的最大价值
		int[][] v = new int[n+1][m+1];
		
		//初始化第一行和第一列
		for(int i = 0; i < v.length; i++)
			v[i][0] = 0;
		for(int i = 0; i < v[0].length; i++)
			v[0][i] = 0;
		
		
//		for(int i = 0; i < v.length; i++) {
//			for(int j = 1; j < v[0].length; j++)
//				System.out.println(v[i][j]);
//		}
		
		for(int i = 1; i < v.length; i++) {
			for(int j = 1; j < v[0].length; j++)
				if(w[i-1] > j) {
					v[i][j] = v[i-1][j];
				}else {
					
					//因为是从1 开始的 公式需要调整
					//v[i][j] = Math.max(v[i-1][j],val[i-1] + v[i-1][j-w[i-1]]);
					//为了记录商品放入背包的情况，不能简单使用上式
					if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]) {
						v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
						path[i][j] = 1;
					}else {
						v[i][j] = val[i-1];
					}
				}
		}
		
		for(int i = 0; i < v.length; i++) {
		for(int j = 1; j < v[0].length; j++) {
			System.out.printf(v[i][j] + " ");
			
		}
		System.out.println();
			
	}
		
//		for(int i = 0; i < path.length; i++) {
//			for(int j = 1; j < path[0].length; j++)
//				if(path[i][j] == 1)
//					System.out.printf("第%d个商品放入背包\n",i);
//		}
//	}
//	
	int i = path.length -1;
	int j = path[0].length -1;
	while(i >0 && j >0) {
		//逆序输出}
		if(path[i][j]==1) {
			System.out.printf("第%d个商品放入背包\n",i);

			j -= w[i-1];
		}
		i--;

	}
	}

}
