package sort;
/*
 * ѡ������ÿ��ѡ�������е���Сֵ��Ĭ��Ϊarray[i];���ѭ�����и�С����ֵ���ҳ���С����ֵ����array[i]���н���
 * ѭ������Ϊarray.length-1,ÿ��ѭ��Ϊi��array.length-1
 */

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = {1,2,3};

		Select(array);
	}

	
	public static void Select(int[] array) {

		for(int i = 0; i < array.length-1; i++) {
			int min = i;//Ĭ����Сλ��0
			for(int j = i ; j < array.length-1;j++) {
				if(array[min] > array[j+1]) {
					min = j+1;
				}
			if(min != i) {
				//���������پ��Ľ���
				int temp = 0;
				temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
			
			
			}
			System.out.printf("��%d�εĽ���ǣ�", i+1);
			for(int j = 0; j < array.length;j++) {
				System.out.print(array[j]+ " ");

			}
			System.out.println();

		}
		

		
		
	}
}
