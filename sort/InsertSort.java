package sort;
/*
 * ����������������ӵ�����������
 * ���Ҫ��������ݱ�index-1ҪС����������λ�ò�������ǰ��ıȽ�
 */

public class InsertSort {
	
	public static void main(String[] args) {
		int array[] = {1,2,3,4,8,9,7};
		Insert(array);

	}
	
	public static void Insert(int[] array) {
		int insertIndex = 0;
		int value = 0;
		for(int i = 1; i < array.length; i++) {
			insertIndex = i-1;
			value =  array[i];
			while(value < array[insertIndex] && insertIndex >=0) {
				value =  array[insertIndex];
				array[insertIndex] = array[insertIndex+1] ;
				array[insertIndex+1] = value;
				value = array[insertIndex] ;

				insertIndex--;
			}
			System.out.printf("��%d�ε����н����:" ,i);
			for(int j = 0; j < i+1;j ++) {
				System.out.print(array[j] + " ");

			}
			
		}

			
	}

}
