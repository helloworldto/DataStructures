package datacode;

import java.util.Scanner;

import datacode.ArrayQueueDemo.ArrayQueue;

/*
 * 用数组模拟循环队列
 * 规则如下：
 * 1.判断循环队列满的条件 预留一个空间  (rear+1)% maxSize == front
 * 2.判断为空的条件  rear = front
 */
public class CirleQueueDemo {

	static class CirleArray{
		private int maxSize;//表示数组的最大容量
		private int front;//队列头
		private int rear;//队列尾
		private int[] arr;
		//front 和 rear的初始值为0
		
		//构造
		public CirleArray(int arrMaxSize) {
			maxSize = arrMaxSize;
			arr = new int[maxSize];
			
		}
		
		//判断队列是否为空
		public boolean isEmpty() {
			return rear == front;
		}
		
		//判断队列是否满了
		public boolean isFull() {
			return (rear+1) % maxSize == front;
		}
		
		//添加数据到队列
		public void addQueue(int n) {
			//判断队列是否满
			if(isFull()) {
				System.out.println("队列满，无法家属数据");
				return;
			}
			//直接将数据插入
			arr[rear] = n;
			rear = (rear + 1) % maxSize;  
		}
		
		//获取队列的数据，出队列
		public int getQueue() {
			//判断队列是否为空
			if(isEmpty()) {
				throw new RuntimeException("队列空，无法取出数据");
			}
			//先需要一个临时变量保存队列的第一个元素，然后将front后移，考虑取模，再将临时变量返回
			int value = arr[front];
			front = (front + 1)%maxSize;
			return value;
		}
		
		//显示队列的所有数据
		public void showQueue() {
			//遍历
			if(isEmpty()) {
				System.out.println("队列为空，没有数据");
				return;
			}
			//从front 开始遍历 需注意这是循环队列
			for(int i = front; i < front + size();i++ ) {
				System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
			}
		}
		
		//求出当前队列有效数据的个数
		public int size() {
			return(rear + maxSize - front ) % maxSize;
		}
		
		public int headQueue() {
			if(isEmpty()) {
				throw new RuntimeException("队列空");
			}
			return arr[front % maxSize];
		}
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CirleArray queue = new  CirleArray(3); //= new ArrayQueue(3);

		char key = ' ';//接收用户输入
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
			//弹出一个菜单
		while(loop) {
			System.out.println("s(show):显示队列");
			System.out.println("e(exit):退出程序");
			System.out.println("a(add):添加数据到队列");
			System.out.println("g(get):从队列取出数据");
			System.out.println("h(head):查看队列头的数据");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("输出一个数");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				//g和h需要写try catch 否则报错
				try {
					int res = queue.getQueue();
					System.out.printf("取出的数据是%d\n", res);
				}catch(Exception e) {
					System.out.print(e+ "\n");
				}
				
				break;
			case 'h':
				try {
					int res1 = queue.headQueue();
					System.out.printf("队列头的数据是%d\n", res1);
				}catch(Exception e) {
					System.out.print(e+ "\n");
				}

				break;
			case 'e':
				scanner.close();
				loop = false;
				break;
			default:
				break;
			}
		}
	}

}
