package datacode;

import java.util.Stack;

public class SingleLinklistImprove {


	//定义HeroNode,每个HeroNode对象就是一个节点
	static class HeroNode{
		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //指向下一个节点
		
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
	
	
	//定义SingleLinkLiset管理我们的英雄
	static class SingleLikList{



		//先初始化一个头节点，头节点不动，不存放具体的数据
		private HeroNode head = new HeroNode(0,"","");
		
		public HeroNode getHead() {
			return head;
		}
		//添加节点到单向链表
		/*
		 * 当不考虑编号顺序时
		 * 1.找到当前链表的最后节点
		 * 2.将最后这个节点的next指向新的节点
		 */
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
				//插入到链表中 在temp 和temp.next之间
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
			//当退出循环的时候，temp只可能在链表的最后
			//将这个节点的next指向新的节点
			
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

		
		//删除节点
		public void delete(int no) {
			if(head.next == null) {
				System.out.println("链表是空的");
				return;
			}
			HeroNode temp = head;
			boolean flag = false;

			while(true) {
				if(temp.next.no == no) {
					flag = true;
					break;
				}if(temp.next == null){
					break;
				}
				temp = temp.next;
					
			}
			if(flag) {
				temp.next = temp.next.next;
			}else {
				System.out.printf("编号为%d的HeroNode不存在",no);

			}
		}

	

	

	}
	
	//获取有效长度
	public static int getlength(HeroNode head) {
		int length = 0;
		HeroNode temp = head.next; //不考虑head
		while(temp != null) {
			length++;
			temp = temp.next;		 
		}
		return length;
	}
	
	//查找倒数第K个节点
	//接收head 和index(倒数)节点
	public static void lastIndexNode(HeroNode head,int index) {
		HeroNode temp = head.next;
		int i = 0;
		while(temp!=null){
			i++;
			temp = temp.next;
		}
		temp = head.next;
		if(index > i) {
			System.out.print("索引越界");

		}else {
			for(int j = 0;j<i-index;j++)
				temp = temp.next;
			System.out.print(temp);
		}
		
		
		
	}
	
	
	//反转节点
	public static void reverse(HeroNode head) {
		if(head.next == null||head.next.next == null) {
			return;
		}
		//定义一个临时指针遍历原来的链表
		HeroNode cur = head.next;
		HeroNode next = null;//指向当前节点cur的下一个节点
		HeroNode reverseHead = new HeroNode(0,"","");
		while(cur!= null) {
				
			next = cur.next;//保存cur的Next节点
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
		
	}
	
	//逆序打印
	public static void ReversePrint(HeroNode head) {
		if(head.next == null) {
			return;
		}
		Stack<HeroNode> stack = new Stack<HeroNode>();
		HeroNode cur = head.next;
		while(cur != null) {
			stack.push(cur);
			cur = cur.next;
		}
		//将栈中元素Pop出
		while(stack.size()>0)
			System.out.println(stack.pop());
	}
		


	
	public static void main(String[] args) {
		//进行测试
		HeroNode hero1 = new HeroNode(1,"宋江","及时雨");
		
		HeroNode hero3 = new HeroNode(3,"吴用","智多星");
		HeroNode hero4 = new HeroNode(4,"林冲","豹子头");
		HeroNode hero2 = new HeroNode(2,"卢俊义","玉麒麟");


		//创建链表
		SingleLikList singlelinklist = new SingleLikList();
		singlelinklist.add(hero1);
		singlelinklist.add(hero2);
		singlelinklist.add(hero4);
		singlelinklist.add(hero3);
		singlelinklist.add(hero3);
		singlelinklist.list();
		
		//HeroNode hero = new HeroNode(2,"校长","兔子");
		
		//singlelinklist.update(hero);
		reverse(singlelinklist.getHead());
		singlelinklist.list();
		ReversePrint(singlelinklist.getHead());


//		singlelinklist.list();
//		
//		lastIndexNode(singlelinklist.getHead(),5);
//	
//		singlelinklist.delete(1);
//		singlelinklist.list();
//		
//		singlelinklist.delete(2);
//		singlelinklist.list();
//
//		
//		singlelinklist.delete(4);
//		singlelinklist.list();
//
//		
//		System.out.println(getlength(singlelinklist.getHead()));


	}


}
