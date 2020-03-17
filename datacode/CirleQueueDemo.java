package datacode;

import java.util.Scanner;

import datacode.ArrayQueueDemo.ArrayQueue;

/*
 * ������ģ��ѭ������
 * �������£�
 * 1.�ж�ѭ�������������� Ԥ��һ���ռ�  (rear+1)% maxSize == front
 * 2.�ж�Ϊ�յ�����  rear = front
 */
public class CirleQueueDemo {

	static class CirleArray{
		private int maxSize;//��ʾ������������
		private int front;//����ͷ
		private int rear;//����β
		private int[] arr;
		//front �� rear�ĳ�ʼֵΪ0
		
		//����
		public CirleArray(int arrMaxSize) {
			maxSize = arrMaxSize;
			arr = new int[maxSize];
			
		}
		
		//�ж϶����Ƿ�Ϊ��
		public boolean isEmpty() {
			return rear == front;
		}
		
		//�ж϶����Ƿ�����
		public boolean isFull() {
			return (rear+1) % maxSize == front;
		}
		
		//������ݵ�����
		public void addQueue(int n) {
			//�ж϶����Ƿ���
			if(isFull()) {
				System.out.println("���������޷���������");
				return;
			}
			//ֱ�ӽ����ݲ���
			arr[rear] = n;
			rear = (rear + 1) % maxSize;  
		}
		
		//��ȡ���е����ݣ�������
		public int getQueue() {
			//�ж϶����Ƿ�Ϊ��
			if(isEmpty()) {
				throw new RuntimeException("���пգ��޷�ȡ������");
			}
			//����Ҫһ����ʱ����������еĵ�һ��Ԫ�أ�Ȼ��front���ƣ�����ȡģ���ٽ���ʱ��������
			int value = arr[front];
			front = (front + 1)%maxSize;
			return value;
		}
		
		//��ʾ���е���������
		public void showQueue() {
			//����
			if(isEmpty()) {
				System.out.println("����Ϊ�գ�û������");
				return;
			}
			//��front ��ʼ���� ��ע������ѭ������
			for(int i = front; i < front + size();i++ ) {
				System.out.printf("arr[%d]=%d\n",i%maxSize,arr[i%maxSize]);
			}
		}
		
		//�����ǰ������Ч���ݵĸ���
		public int size() {
			return(rear + maxSize - front ) % maxSize;
		}
		
		public int headQueue() {
			if(isEmpty()) {
				throw new RuntimeException("���п�");
			}
			return arr[front % maxSize];
		}
	}
	

	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CirleArray queue = new  CirleArray(3); //= new ArrayQueue(3);

		char key = ' ';//�����û�����
		Scanner scanner = new Scanner(System.in);
		boolean loop = true;
			//����һ���˵�
		while(loop) {
			System.out.println("s(show):��ʾ����");
			System.out.println("e(exit):�˳�����");
			System.out.println("a(add):������ݵ�����");
			System.out.println("g(get):�Ӷ���ȡ������");
			System.out.println("h(head):�鿴����ͷ������");
			key = scanner.next().charAt(0);
			switch(key) {
			case 's':
				queue.showQueue();
				break;
			case 'a':
				System.out.println("���һ����");
				int value = scanner.nextInt();
				queue.addQueue(value);
				break;
			case 'g':
				//g��h��Ҫдtry catch ���򱨴�
				try {
					int res = queue.getQueue();
					System.out.printf("ȡ����������%d\n", res);
				}catch(Exception e) {
					System.out.print(e+ "\n");
				}
				
				break;
			case 'h':
				try {
					int res1 = queue.headQueue();
					System.out.printf("����ͷ��������%d\n", res1);
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
