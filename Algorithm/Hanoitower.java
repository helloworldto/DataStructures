package Algorithm;

public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			hanoiTower(4,'A','B','C');
	}

	
	//汉诺塔方法 分治加递归
	public static void hanoiTower(int num,char a,char b,char c) {
		if(num == 1) {
			System.out.println("第1个盘从"+ a +"->" + c);
		}else {
			//先将num-1个盘从a经过c到b
			hanoiTower(num-1, a,c,b);
			//将最后一个盘从a到c
			System.out.println("第"+ num + "个盘从" + a + "->" + c);
			//num-1个盘从b经过a到c
			hanoiTower(num-1, a,b,c);

		}
	}
}
