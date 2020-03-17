package datacode;

import java.util.Scanner;

public class stack {
	
	static class ArrayStack{
		private int maxSize;
		private int[] stack;
		private int top = -1;
		//创建构造器
		public ArrayStack(int maxSize) {
			this.maxSize = maxSize;
			stack = new int[this.maxSize];
		}
		
		//判断栈满
		public boolean isFull() {
			return top == maxSize - 1;
		}
		
		//栈空
		public boolean isEmpty() {
			return top == -1;
		}
		
		//入栈
		public void push(int value) {
			if(isFull()) {
				System.out.print("栈满\n");
				return;
			}
			top++;
			stack[top] = value;
		}
		
		//出栈
		public int pop() {
			if(isEmpty()) {
				throw new RuntimeException("栈空\n");
			}
			int value = stack[top];
			top--;
			return value;
			
		}
		
		//遍历栈  从top开始显示
		public void list() {
			if(isEmpty()) {
				System.out.print("栈为空");
				return;
			}
			for(int i = top; i >= 0;i--) {
				System.out.printf("stack[%d]的元素值为:%d \n",i,stack[i]);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试一下
		//先创建一个对象ArrayStack;
		ArrayStack stack = new ArrayStack(4);
		String key ="";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show:表示显示栈\n");
			System.out.println("exit:退出程序\n");
			System.out.println("push:表示添加数据到栈（入栈）\n");
			System.out.println("pop:表示从栈中取出数据（出栈）\n");
			System.out.println("请输入选择：");
			key = scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("请输入一个数：\n");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("出栈的值是%d: \n",res);
				}catch(Exception e){
					System.out.println(e.getMessage());
				}
				break;
			case "exit":
				scanner.close();
				loop = false;
				break;
			}


		}
		System.out.println("程序退出了");	


	}

}
