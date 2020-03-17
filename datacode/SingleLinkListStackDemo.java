package datacode;

import java.util.Stack;

/*
 * 使用单链表模拟栈
 * push pop list
 */

public class SingleLinkListStackDemo {
	
	
	//定义HeroNode,每个HeroNode对象就是一个节点
	static class HeroNode{
		public int no;
		public String name;
		public HeroNode next; //指向下一个节点
		
		//构造器
		public HeroNode(int no,String name) {
			this.no = no;
			this.name = name;
		

		}
		
		@Override
		public String toString() {
			return "HeroNode [no=" + no +",name="+ name +"]";
		}
	}	
	
	public static class SingleLinkListStaack{
		private HeroNode head = new HeroNode(0,"");
		public HeroNode getHead() {
			return head;
		}
		
		//是否为空
		public boolean isEmpty() {
			System.out.println("栈为空");
			return head.next == null;
		}
		
		
		
		//add
		public void push(HeroNode node) {
			HeroNode temp = head;
			while(true) {
				if(temp.next == null) {
					//说明找到了链表的最后
					break;
				}
				temp = temp.next;
			}
			//当退出循环的时候，temp只可能在链表的最后
			//将这个节点的next指向新的节点
			temp.next = node;
		}
		
		//pop
		public void pop() {
			if(isEmpty()) {
				return;
			}
			HeroNode temp = head;
			while(temp.next.next!=null) {
				temp = temp.next;
			}
			System.out.printf("出栈元素是%d：\n", temp.next.no);
			temp.next = null;
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
			
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1,"宋江");
		
		HeroNode hero3 = new HeroNode(3,"吴用");
		HeroNode hero4 = new HeroNode(4,"林冲");
		HeroNode hero2 = new HeroNode(2,"卢俊义");
		
		SingleLinkListStaack stack = new  SingleLinkListStaack();
		stack.push(hero1);
		stack.ReversePrint(stack.getHead());

		stack.push(hero3);
		stack.ReversePrint(stack.getHead());

		stack.push(hero4);
		stack.push(hero2);
		stack.ReversePrint(stack.getHead());
		stack.pop();
		stack.pop();
		stack.ReversePrint(stack.getHead());




	}

}
