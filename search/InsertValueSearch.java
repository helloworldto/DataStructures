package search;
/*
 * 插值查找算法也要求有序
 * 
 * 自适应查找
 */
public class InsertValueSearch {
	
	
	public static int InsertValueSearch(int[] array,int left,int right,int value) {
		if(left > right || value < array[0]||value > array[array.length-1]) {
			return -1;
		}
		
		int mid = left + (right - left)*(value - array[left])/(array[right]- array[left]);

		int data = array[mid];
		if(value < data) {
			InsertValueSearch(array,left,mid-1,value);
		}else if(value < data) {
			InsertValueSearch(array,mid+1,right,value);

		}else {
			return mid;
		}
		return -1;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = new int[100];
		for(int i = 0; i < 100;i++) {
			array[i] = i;
		}
		int result = InsertValueSearch(array,0,array.length-1,1);
		System.out.print(result);
		
		
	}


	
	
	

}
