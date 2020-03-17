package search;
/*
 * ʵ�� ���������
 */

import java.util.Scanner;

import search.HashTabDemo.Emp.HashTab;

public class HashTabDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashTab hashTab = new HashTab(7);
		String key = "";
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("add: ��ӹ�Ա");
			System.out.println("list:��ʾ��Ա");
			System.out.println("exit:�˳�ϵͳ");
			
			key = scanner.next();
			switch(key){
			case "add":
				System.out.println("����id");
				int id = scanner.nextInt();
				System.out.println("��������");
				String name = scanner.next();
				//������Ա
				Emp emp = new Emp(id,name);
				hashTab.add(emp);
				break;
			case "list":
				hashTab.list();
				break;
			case "exit":
				scanner.close();
				System.exit(0);
			default:
				break;
			}
		}
		

	}
	
	//����һ����Ա��
	static class Emp{
		public int id;
		public String name;
		public Emp next; //nextĬ��Ϊnull��
		
		//������
		public Emp(int id,String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		//����HashTab,�����������
		static class  HashTab{
			private EmpLinkList[] empLinkListArray;
			private int size; //��ʾ�ɶ���������
			
			public void add(Emp emp) {
				//����Ա����id,�õ���Ա��Ӧ����ӵ���������
				int empLinkListNO = hashFun(emp.id);
				empLinkListArray[empLinkListNO].add(emp);
			}
			
			//��������
			public void list() {
				for(int i = 0; i < size;i++) {
					empLinkListArray[i].list();
				}
			}
			
			//��дɢ�к�����ʹ��һ����ȡģ��
			public int hashFun(int id) {
				return id % size;
			}
			
			
			//������
			public HashTab(int size) {
				this.size = size;
				empLinkListArray = new EmpLinkList[size];
				for(int i = 0; i < size; i++) {
					empLinkListArray[i] = new EmpLinkList();

				}
			}
		}
		
		//��������
		static class EmpLinkList{
			//ͷָ�룬ֱ��ָ���һ��Emp
			private Emp head; //Ĭ��Ϊnull
			
			public void add(Emp emp) {
				if(head == null) {
					head = emp;
					return;
				}
				Emp temp = head;
				while(true) {
						if(temp.next == null) {
							//˵���ҵ�����������
							break;
						}
						if(temp.next.id > emp.id) {
							break;
						}
						temp = temp.next;

				}
				if(head.next == null && head.id > emp.id) {
					Emp cur = head;
					head = emp;
					emp.next = cur;
				}else {
					emp.next = temp.next;
					temp.next = emp;
				}
				
		
			}
			
			//���������е���Ϣ
			public void list() {
				if(head == null) {
					System.out.println("��ǰ����Ϊ��");
					return;
				}
				System.out.println("��ǰ�������ϢΪ��");
				Emp temp = head; //����ָ��
				while(true) {
					System.out.printf("=> id=%d name=%s\t ", temp.id,temp.name);
					if(temp.next == null)
						break;
					temp = temp.next;
				}
				System.out.println();
				
					
			}
		
			
		}
		

	}

}
