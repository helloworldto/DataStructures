package Algorithm;

public class BinarySearchNo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {1,3,8,10,11,67,100};
		int index = BinarySearch(array,1);

			System.out.println(index);
	

	}
	
	
	public static int BinarySearch(int[] array,int value) {
		int left = 0;
		int right =  array.length - 1;
		
	
		
		while(left <= right) {
			int mid = (left + right)/2;
			if(array[mid] == value) {
				return mid;
			}else if(array[mid] < value) {
				left = mid +1;
			}else{
				right = mid - 1;
			}
		}
		return -1;
		
	} 

}
