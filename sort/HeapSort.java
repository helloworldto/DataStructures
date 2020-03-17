package sort;
/*
 * ������
 */

import java.util.Arrays;

public class HeapSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {4,6,8,5,9};
		heapSort(array);
	}
	
	//��д�������㷨 ���������ô󶥶�
	public static void heapSort(int array[]) {
//		System.out.println("������");
//		adjustHeap(array,1,array.length);
//		System.out.println("��һ��" + Arrays.toString(array)); ///4,9,8,5,6
		
		//���������й�����һ���ѣ�����������ȷ���Ǵ󶥶ѻ���С����
		for(int i = array.length /2 - 1; i >= 0;i--) {
			adjustHeap(array,i,array.length);
			System.out.println(Arrays.toString(array) );
		}
		int temp;
		//����ɴ󶥶ѻ�С���Ѻ���Ҫ������λ�ú����һ��λ�ý��н���
		for(int  i = array.length-1; i > 0; i--) {
			temp = array[i];
			array[i] = array[0];
			array[0] = temp;
			
			adjustHeap(array,0,i);
		}
		System.out.println(Arrays.toString(array));
	}
	
	
	//��һ�����飨����������������һ���󶥶�
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
