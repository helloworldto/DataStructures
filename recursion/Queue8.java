package recursion;
/*
 * �˻ʺ��������
 * ʹ��һά����array[i] = value
 * i�����i+1��λ���ϵİ˻ʺ�value����˻ʺ����ֵ
 */

public class Queue8 {
	int max = 8;
	int  []array = new int[max];
	static int  count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue8 queue = new Queue8();
		queue.check(0);
		System.out.printf("�ܹ���%d�ֽⷨ.\n",count);
	}
	
	
	//��ӡ
	public void printAarray() {
		count++;
		for(int i  = 0; i < max;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}
	
	public void check(int n) {
		if(n == max) {
			printAarray();
			return;
		}
		
		for(int i = 0; i < max; i++) {
			array[n] = i;
			if(judge(n)) {
				check(n+1);
			}
			
			
		}
	}
	
	//�ж��Ƿ��ͻ
	public boolean judge(int n) {
		//�������ͬһ�л���б���ϱ�������ͻ�������ж�����Ϊ�б���Ͳ���ͬ
		for(int i = 0; i < n; i++) {
			if(array[i] == array[n] || Math.abs(n-i)== Math.abs(array[n]- array[i])) {
				return false;
			}
		}
		return true;
	}

}
