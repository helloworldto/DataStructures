package datacode;

import java.util.Scanner;

/*
 * ʹ������ģ�����,��ע��
 * 1.����ʹ��static����ArrayQueue�࣬��Ϊmain�����Ǳ�static���εģ�����ᱨ��
 * 2.h��g�Ĳ�����Ҫʹ��try catch������ᱨ��
 * 3.��ʾ�������ݵ�ʱ�򣬳���Ӧ����front+1 ��rear+1֮�� ��Ϊ��ʼ��Ϊ1��rear��������ݵ�ʱ������1��front��ɾ�����ݵ�ʱ���1
 * �������������Ͻ�
 */
public class ArrayQueueDemo {
	//����ArrayQueue��
	
	//ע��Ҫ��static������ArrayQueue
	static class ArrayQueue{
		private int MaxSize; //��ʾ������������
		private int front; //����ͷ
		private int rear;//����β
		private int[] arr; //���ڴ�����ݣ�ģ�����
		

		
		//�ж϶����Ƿ���
		public boolean isFull() {
			return rear == MaxSize - 1;
		}
		
		//�ж϶����Ƿ�Ϊ��
		public boolean isEmpty() {
			return rear == front;
		}
		
		//������ݵ�����
		public void addQueue(int n ) {
			if(isFull()) {
				System.out.print("���������޷��������");
				return;
			}
			rear++;
			arr[rear] = n;
		}
		
		//��ȡ���е����ݳ�����
		public int getQueue() {
			//�ж϶���Ϊ��
			if(isEmpty()) {
				throw new RuntimeException("���пգ��޷���ȡ����");
			}
			front++;
			return arr[front];
		}
		
		//��ʾ�����е���������
		public void showQueue() {
			if(isEmpty()) {
				System.out.print("����Ϊ�գ�������");
				return; 
			}
			//���ﲻӦ����arr�ĳ��ȣ���Ӧ����rear+1
			for(int i = front+1; i<rear + 1;i++) {
				System.out.printf("arr[%d]=%d\n",i,arr[i]);
			}
		}
		
		//��ʾ���е�ͷ���ݣ�����ȡ������
		public int headQueue() {
			if(isEmpty()) {
				throw new RuntimeException("���п�");
			}
			return arr[front + 1];
		}
		
		//�������еĹ�����
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
