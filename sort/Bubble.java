package sort;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * ð�������ʵ��
 * ���һ��û�б仯���������
 * ÿһ���ҵ����� ����ÿһ�ε�ѭ��array.length-1-i
 * ����ѭ��array.length-1��
 */

public class Bubble {

	
	public static void main(String[] args) {
		//int array[] = {1,2,3,4,8,9,7};
		int [] arr = new int[800];
		for(int i = 0; i < 800; i++) {
			arr[i] = (int)(Math.random()*800);
		}
		Date date = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String data = sim.format(date);
		System.out.println("����ǰ��ʱ��Ϊ��" + data);
		
		
		BubbleSort(arr);
		Date date2 = new Date();
		SimpleDateFormat sim2 = new SimpleDateFormat("yy-MM-dd HH:mm:ss");
		String data2 = sim2.format(date2);
		System.out.println("������ʱ��Ϊ��" + data2);
		
	}
	
	public static void BubbleSort(int[] array) {
		boolean flag = false;
		for(int i = 0; i < array.length; i++) {

			for(int j = 0; j < array.length-1-i;j++) {
				if(array[j] > array[j+1]) {
					int temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					flag = false;
				}
				
			}
			if(flag) 
				break;
			//System.out.printf("��%d�ֵĽ����:" ,i+1);

			for(int count = 0; count < array.length; count++) {
				System.out.print(array[count]+ " ");
	
			}
			flag = true;
			//System.out.println();

		}

	}
}
