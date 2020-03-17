package recursion;
/*
 * 八皇后问题求解
 * 使用一维数组array[i] = value
 * i代表第i+1行位置上的八皇后，value代表八皇后的列值
 */

public class Queue8 {
	int max = 8;
	int  []array = new int[max];
	static int  count = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Queue8 queue = new Queue8();
		queue.check(0);
		System.out.printf("总共有%d种解法.\n",count);
	}
	
	
	//打印
	public void printAarray() {
		count++;
		for(int i  = 0; i < max;i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();

	}
	
	public void check(int n) {
		if(n == max) {
			printAarray();
			return;
		}
		
		for(int i = 0; i < max; i++) {
			array[n] = i;
			if(judge(n)) {
				check(n+1);
			}
			
			
		}
	}
	
	//判断是否冲突
	public boolean judge(int n) {
		//如果不在同一列或者斜行上表明不冲突，不用判断列因为列本身就不相同
		for(int i = 0; i < n; i++) {
			if(array[i] == array[n] || Math.abs(n-i)== Math.abs(array[n]- array[i])) {
				return false;
			}
		}
		return true;
	}

}
