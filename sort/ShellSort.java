package sort;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ShellSort {
	public static void main(String[] args) {
		int array[] = {8,9,1,7,2,3,5,4,6,0};
		Shell2(array);
		
	}
	
	public static void Shell(int[] array) {
		int temp = 0;
		int count = 0;
		for(int gap = array.length/2; gap > 0;gap /=2) {
			for(int i = gap; i < array.length;i++) {
				for(int j = i -gap;j >= 0; j -= gap ) {
					if(array[j] > array[j+gap]) {
						temp = array[j];
						array[j] = array[j + gap];
						array[j + gap] = temp;
					}
				}

			}
			count++;
			System.out.printf("第%d次的运行结果是：%s",count,Arrays.toString(array));
			System.out.println();
		}
		
	}
	
	//优化算法
	//优化之处在于尽量将较小的值往前移
	public static void Shell2(int[] array) {
		int count = 0;
		for(int gap = array.length/2; gap > 0; gap /= 2 ) {
			for(int i = gap; i < array.length;i++) {
				int j = i;
				int temp = array[j];
				
				//这段话真的好神奇反过来竟然说我越界
				while ((j-gap >= 0)&&(temp < array[j-gap])){
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = temp;

			}
			count++;
			System.out.printf("第%d次的输出是：%s", count,Arrays.toString(array));
	
		}
	}
}
