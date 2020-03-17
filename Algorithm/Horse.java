package Algorithm;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;

public class Horse {
	
	private static int X;//����
	private static int Y;//����
	//�������� ��Ǹ���λ���Ƿ񱻷��ʹ�
	private static boolean isvisited[];
	//ʹ��һ�����Ա���Ƿ���������λ�ö������ʹ���
	private static boolean isfinished;//���true�ɹ�
	
	//�����̤����row�� colum��step��ǰ�ڼ���  step��ʼΪ1
	public static void traversalChessboard(int[][] chessboard,int row,int colum,int step) {
		chessboard[row][colum] = step;
		//System.out.println("�˼���Ŀ������"+chessboard[row][colum]);
		isvisited[row*X + colum] = true;
		ArrayList<Point> ps = next(new Point(colum,row));
		//����ps
		while(!ps.isEmpty()) {
			Point p = (Point) ps.remove(0);
			//�жϸõ��Ƿ��Ѿ����ʹ�
			if(!isvisited[p.y*X+p.x]) {
				//�жϸõ��Ƿ��Ѿ������ʹ�
				traversalChessboard(chessboard,p.y,p.x,step+1);
			}
		}
		//step < X* Y��������������� ����ĿǰΪֹ��Ȼû������ Or ���������˵����ڻ�����
		if(step < X*Y && (!isfinished)) {
			chessboard[row][colum] = 0;
			isvisited[row*X + colum] = false;
			System.out.println("������");
		} else {
			isfinished = true;
		}
	}
	
	public static ArrayList<Point> next(Point curPoint){
		ArrayList<Point> ps = new ArrayList<Point>();
		//����һ��Point
		Point p1 = new Point();
	
		//�ж�����ܲ�������Щλ��
		
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
		//������ʿ�����㷨�Ƿ���ȷ
		X = 8;
		Y = 8;
		int row = 1; 
		int colum = 1; //�����ʼλ�õ���
		//��������
		int[][] chessboard = new int[X][Y];
		isvisited = new boolean[X*Y]; //��ʼΪfalse
		//����һ��horse
		long start = System.currentTimeMillis();
		traversalChessboard(chessboard,row-1,colum-1,1);
		long end = System.currentTimeMillis();
		System.out.println("����ʱ��"+ (end-start));
		//������̵�������
		for(int i = 0; i < chessboard.length; i++) {
			for(int j = 0; j< chessboard[0].length;j++) {
				System.out.print(chessboard[i][j] +" ");
			}
			System.out.println();
		}
				
	}

}
