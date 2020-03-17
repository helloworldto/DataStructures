package search;

import java.util.ArrayList;
import java.util.List;

/*
 * ʹ�ö��ֲ���ǰ�᣺ �����������
 */

public class BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1,8,10,10,89,1000,1000,1000,1000,1211,1234};
		//int data = BinarySearch(array,0,array.length-1,10);
		BinarySearch2(array,0,array.length-1,10);

	
	}
	
	//���ֲ���
	public static int BinarySearch(int[] array,int left,int right, int value) {
		int mid = (left + right)/2;
		if(left > right)
			return -1;
		if(value < array[mid]) {
			BinarySearch(array,left,mid-1,value);
		}else if(value > array[mid]) {
			BinarySearch(array,mid+1,right,value);
		}else {
			return mid;
		}
		return -1;



	}
	
	//�����ж����ͬ��ֵ��ȫ������
	public static void BinarySearch2(int[] array,int left,int right, int value) {
		int mid = (left + right)/2;
		ArrayList<Integer> resIndexlist = new ArrayList<Integer>();

	
		if(value < array[mid]) {
			BinarySearch2(array,left,mid-1,value);
		}else if(value > array[mid]) {
			BinarySearch2(array,mid+1,right,value);
		}else {
			System.out.println(mid);

			int temp = mid -1;
			while(true) {
				if(temp < 0 ||array[temp]!= value) {
					break;
				}
				resIndexlist.add(temp);
				temp--;
			}
			resIndexlist.add(mid);

			temp = mid + 1;

			while(true) {
				if(array[temp]!= value || temp > array.length-1) {
					break;
				}
				resIndexlist.add(temp);
				temp++;
		
			}
			System.out.println(resIndexlist.toString());
		}
		//return resIndexlist.toString();




	}

}
