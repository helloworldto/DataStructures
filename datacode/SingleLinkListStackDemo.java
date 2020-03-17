package datacode;

import java.util.Stack;

/*
 * ʹ�õ�����ģ��ջ
 * push pop list
 */

public class SingleLinkListStackDemo {
	
	
	//����HeroNode,ÿ��HeroNode�������һ���ڵ�
	static class HeroNode{
		public int no;
		public String name;
		public HeroNode next; //ָ����һ���ڵ�
		
		//������
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
		
		//�Ƿ�Ϊ��
		public boolean isEmpty() {
			System.out.println("ջΪ��");
			return head.next == null;
		}
		
		
		
		//add
		public void push(HeroNode node) {
			HeroNode temp = head;
			while(true) {
				if(temp.next == null) {
					//˵���ҵ�����������
					break;
				}
				temp = temp.next;
			}
			//���˳�ѭ����ʱ��tempֻ��������������
			//������ڵ��nextָ���µĽڵ�
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
			System.out.printf("��ջԪ����%d��\n", temp.next.no);
			temp.next = null;
		}
		
		
		//�����ӡ
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
			//��ջ��Ԫ��Pop��
			while(stack.size()>0)
				System.out.println(stack.pop());
		}
			
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1,"�ν�");
		
		HeroNode hero3 = new HeroNode(3,"����");
		HeroNode hero4 = new HeroNode(4,"�ֳ�");
		HeroNode hero2 = new HeroNode(2,"¬����");
		
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
