package sort;

import java.util.Arrays;

/*
 * �ֶ���֮
 * �鲢����
 */
public class DivideSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {8,4,5,7,1,3,6,2};
		int temp[] = new int[array.length];
		mergeSort(array,0,array.length-1,temp);
		System.out.printf("������Ϊ��%s", Arrays.toString(array));
	}
	
	//��+ �Ϸ���
	public static void mergeSort(int[] array, int left,int right,int[] temp) {
		if(left < right) {
			int mid = (left + right)/2;
			mergeSort(array,left,mid,temp);
			mergeSort(array,mid + 1,right,temp);
			merge(array,left,mid,right,temp);
		
		}
	}
	
	
	public static void merge(int[] array,int left,int mid,int right,int[] temp) {
		int i = left;  //��ʼ��i������������еĳ�ʼ����
		int j = mid + 1; //��ʼ��j,�ұ����������еĳ�ʼ����
		int t = 0; 
		//���������ߣ����򣩵����鰴�չ�����䵽temp����
		while(i <= mid && j <= right) {
			if(array[i] <= array[j]) {
				temp[t++] = array[i++];
				
			}else {
				temp[t++] = array[j++];

			}
		}
		
		//������ʣ�����ݵ�һ��ȫ����䵽temp
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
