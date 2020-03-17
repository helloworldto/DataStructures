package search;
/*
 * 实现 了有序插入
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
			System.out.println("add: 添加雇员");
			System.out.println("list:显示雇员");
			System.out.println("exit:退出系统");
			
			key = scanner.next();
			switch(key){
			case "add":
				System.out.println("输入id");
				int id = scanner.nextInt();
				System.out.println("输入名字");
				String name = scanner.next();
				//创建雇员
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
	
	//定义一个雇员类
	static class Emp{
		public int id;
		public String name;
		public Emp next; //next默认为null；
		
		//构造器
		public Emp(int id,String name) {
			super();
			this.id = id;
			this.name = name;
		}
		
		//创建HashTab,管理多条链表
		static class  HashTab{
			private EmpLinkList[] empLinkListArray;
			private int size; //表示由多少条链表
			
			public void add(Emp emp) {
				//根据员工的id,得到该员工应当添加到哪条链表
				int empLinkListNO = hashFun(emp.id);
				empLinkListArray[empLinkListNO].add(emp);
			}
			
			//遍历链表
			public void list() {
				for(int i = 0; i < size;i++) {
					empLinkListArray[i].list();
				}
			}
			
			//编写散列函数，使用一个简单取模法
			public int hashFun(int id) {
				return id % size;
			}
			
			
			//构造器
			public HashTab(int size) {
				this.size = size;
				empLinkListArray = new EmpLinkList[size];
				for(int i = 0; i < size; i++) {
					empLinkListArray[i] = new EmpLinkList();

				}
			}
		}
		
		//创建链表
		static class EmpLinkList{
			//头指针，直接指向第一个Emp
			private Emp head; //默认为null
			
			public void add(Emp emp) {
				if(head == null) {
					head = emp;
					return;
				}
				Emp temp = head;
				while(true) {
						if(temp.next == null) {
							//说明找到了链表的最后
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
			
			//遍历链表中的信息
			public void list() {
				if(head == null) {
					System.out.println("当前链表为空");
					return;
				}
				System.out.println("当前链表的信息为：");
				Emp temp = head; //辅助指针
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
