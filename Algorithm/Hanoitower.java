package Algorithm;

public class Hanoitower {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			hanoiTower(4,'A','B','C');
	}

	
	//��ŵ������ ���μӵݹ�
	public static void hanoiTower(int num,char a,char b,char c) {
		if(num == 1) {
			System.out.println("��1���̴�"+ a +"->" + c);
		}else {
			//�Ƚ�num-1���̴�a����c��b
			hanoiTower(num-1, a,c,b);
			//�����һ���̴�a��c
			System.out.println("��"+ num + "���̴�" + a + "->" + c);
			//num-1���̴�b����a��c
			hanoiTower(num-1, a,b,c);

		}
	}
}
