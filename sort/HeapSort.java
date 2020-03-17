package sort;
/*
 * 堆排序
 */

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {4,6,8,5,9};
		heapSort(array);
	}
	
	//编写堆排序算法 升序排序用大顶堆
	public static void heapSort(int array[]) {
//		System.out.println("堆排序");
//		adjustHeap(array,1,array.length);
//		System.out.println("第一次" + Arrays.toString(array)); ///4,9,8,5,6
		
		//将无序序列构建成一个堆，根据升序降序确定是大顶堆还是小顶堆
		for(int i = array.length /2 - 1; i >= 0;i--) {
			adjustHeap(array,i,array.length);
			System.out.println(Arrays.toString(array) );
		}
		int temp;
		//当变成大顶堆或小顶堆后，需要将顶的位置和最后一个位置进行交换
		for(int  i = array.length-1; i > 0; i--) {
			temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			
			adjustHeap(array,0,i);
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	//将一个数组（二叉树），调整成一个大顶堆
	public static void adjustHeap(int array[],int i, int length) {
		int temp = array[i];
		for(int k = i * 2 + 1; k < length; k = k * 2 +1) {
			if(k + 1 < length && array[k] <array[k + 1]) {
			k++;
			}
			if(array[k] > temp) {
				array[i] = array[k];
				i = k;
			}else {
				break;
			}
			
			
		}
		array[i] = temp;

	}

}
