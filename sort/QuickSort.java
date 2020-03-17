package sort;

import java.util.Arrays;

public class QuickSort {
	public static void main(String[] args) {
		int array[] = {-9,78,0,23,-67,70};
		quickSort(array,0,array.length-1);
		System.out.printf("���յ�������Ϊ��%s",Arrays.toString(array));
	}
	
	public static void quickSort(int[] array,int left,int right) {
		int l = left; //���±�
		int r = right; //���±�
		int privot = array[(l + r) /2];
		int temp = 0;
		while(l < r) {
			while(array[l] < privot) {
				l++;
			}
			while(array[r] > privot) {
				r--;
			}
			if( l >= r) {
				break;
			}
			
			temp = array[l];
			array[l] = array[r];
			array[r] = temp;
			
			if(array[l] == privot) {
				r--;
			}
			if(array[r] == privot) {
				l++;
			}
		}
		
		
		
	}
}
