package datacode;

import datacode.SingleLinklistImprove.HeroNode;
import datacode.SingleLinklistImprove.SingleLikList;

public class DoubleLinkListDemo {
	
	
	

	//定义HeroNode,每个HeroNode对象就是一个节点
	static class HeroNode{

		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //指向下一个节点
		public HeroNode pre; //指向前一个节点
		
		//构造器
		public HeroNode(int no,String name,String nickname) {
			this.no = no;
			this.name = name;
			this.nickname = nickname;

		}
		
		@Override
		public String toString() {
			return "HeroNode [no=" + no +",name="+ name +",nickname="+ nickname+"]";
		}
		
		
	}	
	
	static class DoubleLinkList{
	//先初始化一个头节点，头节点不动，不存放具体的数据
		private HeroNode head = new HeroNode(0,"","");
				
		public HeroNode getHead() {
			return head;
				}
		
		
		//显示链表（遍历）
		public void list() {

			//判断链表是否为空
			if(head.next == null) {
				System.out.println("链表为空");
				return;
			}
			//因为头节点不能动同上需要temp
			HeroNode temp = head.next;
			while(true) {
				if(temp == null) {
					break;
				}
				System.out.println(temp);
				temp = temp.next;
			}
			//当退出循环的时候，temp只可能在链表的最后
			//将这个节点的next指向新的节点
	 
		}
		
		public void add(HeroNode heroNode) {
			//因为头不能动，所以需要辅助遍历temp
			HeroNode temp = head;
			boolean flag = false;
			while(true) {
				if(temp.next == null) {
					//说明找到了链表的最后
					break;
				}
				if(temp.next.no > heroNode.no) {
					break;
				}else if(temp.next.no == heroNode.no) {
					flag = true;  //说明编号存在
					break;
				}
				temp = temp.next;
			}
			if(flag) {
				System.out.printf("英雄编号%d已经存在了:\n " , heroNode.no);
			}else {
				//改进 需要有序插入
				//插入到链表中 在temp 和temp.next之间
				//目前已实现有序插入
				if(temp.next == null) {
					temp.next = heroNode;
					heroNode.pre = temp;
				}else {
					heroNode.next = temp.next;

					temp.next.pre = heroNode;
					heroNode.pre = temp;
					temp.next = heroNode;
				}
			}
			//当退出循环的时候，temp只可能在链表的最后
			//将这个节点的next指向新的节点
			
		}
		
		
		//删除节点
		public void delete(int no) {
			if(head.next == null) {
				System.out.println("链表是空的");
				return;
			}
			HeroNode temp = head.next;
			boolean flag = false;

			while(true) {
				if(temp.no == no) {
					flag = true;
					break;
				}if(temp.next == null){
					break;
				}
				temp = temp.next;
					
			}
			if(flag) {
				temp.pre.next = temp.next;
				if(temp.next != null) {
					//如果不是最后一个节点，执行这种情况，否则出现空指针异常
					temp.next.pre = temp.pre;

				}else {
					temp.pre.next = null;
				}
			}else {
				System.out.printf("编号为%d的HeroNode不存在",no);

			}
		}

		
		//修改节点内容
		public void update(HeroNode heroNode) {
			if(head.next == null) {
				System.out.println("链表为空");
				return;
			}
			HeroNode temp = head.next;
			boolean flag = false;
			while(true) {
				if(temp.next == null)
					break;
				if(temp.no ==heroNode.no) {
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if(flag) {
				temp.name = heroNode.name;
				temp.nickname = heroNode.nickname;
			}else
				System.out.printf("不存在编号为%d的HeroNode",heroNode.no);
		}
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");


		//创建链表
		DoubleLinkList doublelinklist = new DoubleLinkList();
		doublelinklist.add(hero1);
	
		
		doublelinklist.add(hero4);
		doublelinklist.add(hero2);
		doublelinklist.add(hero3);

		doublelinklist.list();
		HeroNode hero = new HeroNode(2,"校长","兔子");

		doublelinklist.update(hero);
		doublelinklist.list();

		doublelinklist.delete(2);
		doublelinklist.list();
		doublelinklist.delete(4);
		doublelinklist.list();




		

	}

}
