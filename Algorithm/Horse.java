package Algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Horse {
	
	private static int X;//列数
	private static int Y;//行数
	//创建数组 标记各个位置是否被访问过
	private static boolean isvisited[];
	//使用一个属性标记是否棋盘所有位置都被访问过了
	private static boolean isfinished;//如果true成功
	
	//完成马踏棋盘row行 colum列step当前第几步  step初始为1
	public static void traversalChessboard(int[][] chessboard,int row,int colum,int step) {
		chessboard[row][colum] = step;
		//System.out.println("菜鸡泪目！！！"+chessboard[row][colum]);
		isvisited[row*X + colum] = true;
		ArrayList<Point> ps = next(new Point(colum,row));
		//遍历ps
		while(!ps.isEmpty()) {
			Point p = (Point) ps.remove(0);
			//判断该点是否已经访问过
			if(!isvisited[p.y*X+p.x]) {
				//判断该点是否已经被访问过
				traversalChessboard(chessboard,p.y,p.x,step+1);
			}
		}
		//step < X* Y成立的情况有两种 棋盘目前为止仍然没有走完 Or 棋盘走完了但是在回漱中
		if(step < X*Y && (!isfinished)) {
			chessboard[row][colum] = 0;
			isvisited[row*X + colum] = false;
			System.out.println("是这里");
		} else {
			isfinished = true;
		}
	}
	
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps = new ArrayList<Point>();
		//创建一个Point
		Point p1 = new Point();
	
		//判断马儿能不能走那些位置
		
		if((curPoint.x - 2) >= 0) {
			p1.x = curPoint.x - 2;
			if(curPoint.y - 1 >= 0) {
				p1.y = curPoint.y - 1;
				ps.add(p1);

			}
				
			if(curPoint.y + 1 < Y)
				p1.y = curPoint.y + 1;
				ps.add(p1);

		}
		
		if((curPoint.x - 1) >= 0) {
			p1.x = curPoint.x - 1;
			if(curPoint.y - 2 >= 0) {
				p1.y = curPoint.y - 2;
				ps.add(p1);

			}
				
			if(curPoint.y + 2 < Y)
				p1.y = curPoint.y + 2;
				ps.add(p1);

		}
		
		if((curPoint.x + 2) < X) {
			p1.x = curPoint.x + 2;
			if(curPoint.y - 1 >= 0) {
				p1.y = curPoint.y - 1;
				ps.add(p1);

			}
				
			if(curPoint.y + 1 < Y)
				p1.y = curPoint.y + 1;
				ps.add(p1);

				
		}
		
		if((curPoint.x + 1) < X) {
			p1.x = curPoint.x + 1;
			if(curPoint.y - 2 >= 0) {
				p1.y = curPoint.y - 2;
				ps.add(p1);

			}
				
			if(curPoint.y + 2 < Y)
				p1.y = curPoint.y + 2;
				ps.add(p1);

		}
//		if(((p1.x = curPoint.x - 2)>= 0) &&((p1.y = curPoint.y - 1)>=0) ){
//			ps.add(p1);
//		}
//		if((p1.x = curPoint.x -1 ) >= 0 &&(p1.y = curPoint.y - 2)>=0)
//			ps.add(p1);
//		if((p1.x = curPoint.x + 1 )>= 0 &&(p1.x = curPoint.x + 1 ) < X &&(p1.y = curPoint.y - 2)>=0)
//			ps.add(p1);
//		if((p1.x = curPoint.x + 2 )>= 0 &&(p1.x = curPoint.x + 2 ) < X &&(p1.y = curPoint.y - 1)>=0)
//			ps.add(p1);
//		if((p1.x = curPoint.x + 2 )>=0&&(p1.x = curPoint.x + 2 ) < X &&(p1.y = curPoint.y + 1)>= 0&&(p1.y = curPoint.y + 1) < Y)
//			ps.add(p1);
//		if((p1.x = curPoint.x + 1 ) >= 0&&(p1.x = curPoint.x + 1 ) < X && (p1.y = curPoint.y + 2) >=0 &&(p1.y = curPoint.y + 2) < Y)
//			ps.add(p1);
//		if((p1.x = curPoint.x - 1 ) >=0 &&(p1.y = curPoint.y + 2) >= 0 && (p1.y = curPoint.y + 2) < Y)
//			ps.add(p1);
//		if((p1.x = curPoint.x -2 ) >=0 &&(p1.y = curPoint.y + 1) >= 0 && (p1.y = curPoint.y + 1) < Y)
//			ps.add(p1);
		return ps;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试骑士周游算法是否正确
		X = 8;
		Y = 8;
		int row = 1; 
		int colum = 1; //马儿初始位置的列
		//创建棋盘
		int[][] chessboard = new int[X][Y];
		isvisited = new boolean[X*Y]; //初始为false
		//测试一下horse
		long start = System.currentTimeMillis();
		traversalChessboard(chessboard,row-1,colum-1,1);
		long end = System.currentTimeMillis();
		System.out.println("共耗时："+ (end-start));
		//输出棋盘的最后情况
		for(int i = 0; i < chessboard.length; i++) {
			for(int j = 0; j< chessboard[0].length;j++) {
				System.out.print(chessboard[i][j] +" ");
			}
			System.out.println();
		}
				
	}

}
