package sort;
/*
 * 将无序数据依次添加到有序数组中
 * 如果要插入的数据比index-1要小，两个交换位置并继续和前面的比较
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
			System.out.printf("第%d次的运行结果是:" ,i);
			for(int j = 0; j < i+1;j ++) {
				System.out.print(array[j] + " ");

			}
			
		}

			
	}

}
