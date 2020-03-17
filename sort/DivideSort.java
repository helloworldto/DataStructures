package sort;

import java.util.Arrays;

/*
 * 分而治之
 * 归并排序
 */
public class DivideSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[array.length];
		mergeSort(array,0,array.length-1,temp);
		System.out.printf("输出结果为：%s", Arrays.toString(array));
	}
	
	//分+ 合方法
	public static void mergeSort(int[] array, int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(array,left,mid,temp);
			mergeSort(array,mid + 1,right,temp);
			merge(array,left,mid,right,temp);
		
		}
	}
	
	
	public static void merge(int[] array,int left,int mid,int right,int[] temp) {
		int i = left;  //初始化i，左边有序序列的初始索引
		int j = mid + 1; //初始化j,右边有序列序列的初始索引
		int t = 0; 
		//把左右两边（有序）的数组按照规则填充到temp数组
		while(i <= mid && j <= right) {
			if(array[i] <= array[j]) {
				temp[t++] = array[i++];
				
			}else {
				temp[t++] = array[j++];

			}
		}
		
		//将把有剩余数据的一边全部填充到temp
		while(i <= mid) {
			temp[t++] = array[i++];
		}
		while(j <= right) {
			temp[t++] = array[j++];

		}
		
		t = 0;
		int tempLeft = left;
		while(tempLeft <= right) {
			array[tempLeft++] = temp[t++];
		}
	}
	
	

}
