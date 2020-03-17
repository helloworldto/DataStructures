package sort;
/*
 * 选择排序，每次选出序列中的最小值，默认为array[i];如果循环中有更小的数值，找出最小的数值后与array[i]进行交换
 * 循环次数为array.length-1,每次循环为i到array.length-1
 */

public class SelectSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = {1,2,3};

		Select(array);
	}

	
	public static void Select(int[] array) {

		for(int i = 0; i < array.length-1; i++) {
			int min = i;//默认最小位置0
			for(int j = i ; j < array.length-1;j++) {
				if(array[min] > array[j+1]) {
					min = j+1;
				}
			if(min != i) {
				//如果不相等再尽心交换
				int temp = 0;
				temp = array[i];
				array[i] = array[min];
				array[min] = temp;
			}
			
			
			}
			System.out.printf("第%d次的结果是：", i+1);
			for(int j = 0; j < array.length;j++) {
				System.out.print(array[j]+ " ");

			}
			System.out.println();

		}
		

		
		
	}
}
