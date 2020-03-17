package recursion;
/*
 * 这里解决迷宫问题
 */

public class RecurTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int [][]map = new int[8][7];
		//使用1表示障碍物
		for(int i = 0; i < 7;i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for(int i = 0; i  <8;i++) {
			map[i][0] = 1;
			map[i][6] = 1;
			
		}
		map[3][1] = 1;
		System.out.println("地图的情况");
		for(int i =0; i< 8;i++) {
			for(int j = 0;j < 7;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		
		setWay(map,1,1);
		System.out.println("地图的情况");
		for(int i =0; i< 8;i++) {
			for(int j = 0;j < 7;j++) {
				System.out.print(map[i][j]+ " ");
			}
			System.out.println();
		}
		
	}
	
	/*
	 * 1.Map表示地图
	 * 2。i,j 表示从地图的哪个位置开始出发（1，1）
	 * 3.如果到了map[6][5],则表明成功
	 * 4.约定。当map[i][j]为0表示该点没有走过，当为1时表示墙，2表示通路可以走3.表示该点已经走过但走不通
	 * 下-》右-》上-》左
	 */
	
	public static boolean setWay(int[][]map,int i ,int j) {
		if(map[6][5] == 2) {
			return true;
		}else {
			if(map[i][j] == 0) {
				//按照 下->右->上->左
				map[i][j] = 2;
				if(setWay(map,i+1,j)) {
					return true;
				}else if(setWay(map,i,j+1)){
					return true;
				}else if(setWay(map,i-1,j)) {
					return true;
				}else if(setWay(map,i,j-1)){
					return true;
				}else {
					map[i][j] = 3;
					return false;
				}
			}else {
				return false;
			}
		}
	}
	

}
