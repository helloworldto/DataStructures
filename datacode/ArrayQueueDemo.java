package datacode;

import java.util.Scanner;

/*
 * 使用数组模拟队列,需注意
 * 1.必须使用static修饰ArrayQueue类，因为main方法是被static修饰的，否则会报错
 * 2.h和g的操作需要使用try catch，否则会报错
 * 3.显示队列数据的时候，长度应该是front+1 到rear+1之间 因为初始都为1，rear是添加数据的时候增加1，front是删除数据的时候加1
 * 这样操作更加严谨
 */
public class ArrayQueueDemo {
	//构建ArrayQueue类
	
	//注意要用static修饰类ArrayQueue
	static class ArrayQueue{
		private int MaxSize; //表示数组的最大容器
		private int front; //队列头
		private int rear;//队列尾
		private int[] arr; //用于存放数据，模拟队列
		

		
		//判断队列是否满
		public boolean isFull() {
			return rear == MaxSize - 1;
		}
		
		//判断队列是否为空
		public boolean isEmpty() {
			return rear == front;
		}
		
		//添加数据到队列
		public void addQueue(int n ) {
			if(isFull()) {
				System.out.print("队列满，无法添加数据");
				return;
			}
			rear++;
			arr[rear] = n;
		}
		
		//获取队列的数据出队列
		public int getQueue() {
			//判断队列为空
			if(isEmpty()) {
				throw new RuntimeException("队列空，无法读取数据");
			}
			front++;
			return arr[front];
		}
		
		//显示队列中的所有数据
		public void showQueue() {
			if(isEmpty()) {
				System.out.print("队列为空，无数据");
				return; 
			}
			//这里不应该是arr的长度，而应该是rear+1
			for(int i = front+1; i<rear + 1;i++) {
				System.out.printf("arr[%d]=%d\n",i,arr[i]);
			}
		}
		
		//显示队列的头数据，不是取出数据
		public int headQueue() {
			if(isEmpty()) {
				throw new RuntimeException("队列空");
			}
			return arr[front + 1];
		}
		
		//创建队列的构造器
		public ArrayQueue(int arrMaxSize) {
			this.MaxSize = arrMaxSize; 
			front = -1;
			rear = -1;
			arr = new int[MaxSize];

		}
	}
	
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ArrayQueue queue = new  ArrayQueue(3); //= new ArrayQueue(3);

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
