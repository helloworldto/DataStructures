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
			System.out.printf("��%d�ε����н���ǣ�%s",count,Arrays.toString(array));
			System.out.println();
		}
		
	}
	
	//�Ż��㷨
	//�Ż�֮�����ھ�������С��ֵ��ǰ��
	public static void Shell2(int[] array) {
		int count = 0;
		for(int gap = array.length/2; gap > 0; gap /= 2 ) {
			for(int i = gap; i < array.length;i++) {
				int j = i;
				int temp = array[j];
				
				//��λ���ĺ����淴������Ȼ˵��Խ��
				while ((j-gap >= 0)&&(temp < array[j-gap])){
					array[j] = array[j - gap];
					j -= gap;
				}
				array[j] = temp;

			}
			count++;
			System.out.printf("��%d�ε�����ǣ�%s", count,Arrays.toString(array));
	
		}
	}
}
