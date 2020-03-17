package search;

import java.util.Arrays;

/*
 * 쳲����������� 
 * ͬ��ֵ���ң��ı�midֵ
 * �Իƽ�ָ��һ�����⣺
 * ���Ͳ�ֵѰ�Ҷ��Ǹı�midֵ����쳲���������f[k] = f[k-1]+ f[k-2]
 * 			mid = low + f[k-1]-1;
 * ������ǿ����ڲ��ҵ�ʱ���������������ԣ����Ҫ���ҵ�ֵvalue < temp[mid],Ҳ����С�ڷ�[k-1]���������ֵ����϶�����high = mid -1 ͬʱ����k-1
 */

public class FibonacciSearch {

	public static int maxSize = 20;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,8,10,89,1000,1234};
		int result = fibSearch(array,1234);
		if(result!= -1) {
			System.out.printf("����Ϊ��%d",result);
		}else {
			System.out.printf("û�и�����");

		}
	}
	
	//쳲���������
	public static int[] fib() {
		int[] f = new int[maxSize];
		f[0] = 1;
		f[1] = 1;
		for(int i = 2; i < maxSize; i++) {
			f[i] = f[i - 1] + f[i - 2];
		}
		return f;
	}
	

	
	/*
	 * value�ǲ��ҵ�ֵ��������򷵻�������±�
	 */
	public static int fibSearch(int[]array,int value) {
		int low = 0;
		int high = array.length -1;
		int k = 0;//쳲��������е��±�
		int mid = 0; //���midֵ
		int f[] = fib(); //��ȡ쳲���������
		while(high > f[k] - 1) {
			k++;
			
			//�ҵ����ʵ�kֵ
		}
		System.out.printf("�ҵ���KֵΪ:%d \n",k);
		//��Ϊf[k]��ֵ���ܴ���array�ĳ��ȣ������Ҫʹ��Arrays�࣬����һ���µ����飬��ָ��array[]
		int[] temp = Arrays.copyOf(array, f[k]);
		//������ĺ����ǽ�array��ǰf[k]���ȵ����ݸ��Ƶ�temp�У�array���Ȳ�������涼��0
		//Ϊ�˲�ʹ��Ϊ0����Ҫ��0�ı��array[high],��array���������һ��Ԫ�ص�ֵ
		for(int i = high + 1; i < temp.length; i++) {
			temp[i] = array[high];
		}
		
		
		//ʹ��whileѭ�����ҵ�keyֵ
		while(low <= high) {
			mid = low + f[k-1]-1;
			if(value < temp[mid]) {
				high = mid -1;
				k--;
				//��Ϊvalue��ֵС��temp[mid]�������Ҫ��[low,mid]�ķ�Χ���������Χ��Ӧf[k] = f[k-1] + f[k-2];
				//�����Ҫk--,ȥ��ǰ�벿��f[k-1]������  
				//�ڴ˻�������һ��ѭ���� mid ��ֵΪf[k-1] -1 + low
			}else if(value > temp[mid]) {
				low = mid + 1;
				k-=2;
				//��ʱk-=2ͬ�Ϻ����Ԫ�ض�Ӧf[k-2]����
			}else {
				
				//��Ҫ���Ƿ����ĸ��±�
				if(mid <= high) {
					return mid;
				
				}else {
					return high;
				}
			}
		}

		return -1;
	}

}
