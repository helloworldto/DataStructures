package datacode;

import java.util.Scanner;

public class stack {
	
	static class ArrayStack{
		private int maxSize;
		private int[] stack;
		private int top = -1;
		//����������
		public ArrayStack(int maxSize) {
			this.maxSize = maxSize;
			stack = new int[this.maxSize];
		}
		
		//�ж�ջ��
		public boolean isFull() {
			return top == maxSize - 1;
		}
		
		//ջ��
		public boolean isEmpty() {
			return top == -1;
		}
		
		//��ջ
		public void push(int value) {
			if(isFull()) {
				System.out.print("ջ��\n");
				return;
			}
			top++;
			stack[top] = value;
		}
		
		//��ջ
		public int pop() {
			if(isEmpty()) {
				throw new RuntimeException("ջ��\n");
			}
			int value = stack[top];
			top--;
			return value;
			
		}
		
		//����ջ  ��top��ʼ��ʾ
		public void list() {
			if(isEmpty()) {
				System.out.print("ջΪ��");
				return;
			}
			for(int i = top; i >= 0;i--) {
				System.out.printf("stack[%d]��Ԫ��ֵΪ:%d \n",i,stack[i]);
			}
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����һ��
		//�ȴ���һ������ArrayStack;
		ArrayStack stack = new ArrayStack(4);
		String key ="";
		boolean loop = true;
		Scanner scanner = new Scanner(System.in);
		while(loop) {
			System.out.println("show:��ʾ��ʾջ\n");
			System.out.println("exit:�˳�����\n");
			System.out.println("push:��ʾ������ݵ�ջ����ջ��\n");
			System.out.println("pop:��ʾ��ջ��ȡ�����ݣ���ջ��\n");
			System.out.println("������ѡ��");
			key = scanner.next();
			switch(key) {
			case "show":
				stack.list();
				break;
			case "push":
				System.out.println("������һ������\n");
				int value = scanner.nextInt();
				stack.push(value);
				break;
			case "pop":
				try {
					int res = stack.pop();
					System.out.printf("��ջ��ֵ��%d: \n",res);
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
		System.out.println("�����˳���");	


	}

}
