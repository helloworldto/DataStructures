package datacode;

import java.util.Stack;

public class SingleLinklistImprove {


	//����HeroNode,ÿ��HeroNode�������һ���ڵ�
	static class HeroNode{
		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //ָ����һ���ڵ�
		
		//������
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
	
	
	//����SingleLinkLiset�������ǵ�Ӣ��
	static class SingleLikList{



		//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻��������ž��������
		private HeroNode head = new HeroNode(0,"","");
		
		public HeroNode getHead() {
			return head;
		}
		//��ӽڵ㵽��������
		/*
		 * �������Ǳ��˳��ʱ
		 * 1.�ҵ���ǰ��������ڵ�
		 * 2.���������ڵ��nextָ���µĽڵ�
		 */
		public void add(HeroNode heroNode) {
			//��Ϊͷ���ܶ���������Ҫ��������temp
			HeroNode temp = head;
			boolean flag = false;
			while(true) {
				if(temp.next == null) {
					//˵���ҵ�����������
					break;
				}
				if(temp.next.no > heroNode.no) {
					break;
				}else if(temp.next.no == heroNode.no) {
					flag = true;  //˵����Ŵ���
					break;
				}
				temp = temp.next;
			}
			if(flag) {
				System.out.printf("Ӣ�۱��%d�Ѿ�������:\n " , heroNode.no);
			}else {
				//���뵽������ ��temp ��temp.next֮��
				heroNode.next = temp.next;
				temp.next = heroNode;
			}
			//���˳�ѭ����ʱ��tempֻ��������������
			//������ڵ��nextָ���µĽڵ�
			
		}
		

		
		//�޸Ľڵ�����
		public void update(HeroNode heroNode) {
			if(head.next == null) {
				System.out.println("����Ϊ��");
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
				System.out.printf("�����ڱ��Ϊ%d��HeroNode",heroNode.no);
		}
		
		
		//��ʾ����������
		public void list() {

			//�ж������Ƿ�Ϊ��
			if(head.next == null) {
				System.out.println("����Ϊ��");
				return;
			}
			//��Ϊͷ�ڵ㲻�ܶ�ͬ����Ҫtemp
			HeroNode temp = head.next;
			while(true) {
				if(temp == null) {
					break;
				}
				System.out.println(temp);
				temp = temp.next;
			}
			//���˳�ѭ����ʱ��tempֻ��������������
			//������ڵ��nextָ���µĽڵ�
	 
		}

		
		//ɾ���ڵ�
		public void delete(int no) {
			if(head.next == null) {
				System.out.println("�����ǿյ�");
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
				System.out.printf("���Ϊ%d��HeroNode������",no);

			}
		}

	

	

	}
	
	//��ȡ��Ч����
	public static int getlength(HeroNode head) {
		int length = 0;
		HeroNode temp = head.next; //������head
		while(temp != null) {
			length++;
			temp = temp.next;		 
		}
		return length;
	}
	
	//���ҵ�����K���ڵ�
	//����head ��index(����)�ڵ�
	public static void lastIndexNode(HeroNode head,int index) {
		HeroNode temp = head.next;
		int i = 0;
		while(temp!=null){
			i++;
			temp = temp.next;
		}
		temp = head.next;
		if(index > i) {
			System.out.print("����Խ��");

		}else {
			for(int j = 0;j<i-index;j++)
				temp = temp.next;
			System.out.print(temp);
		}
		
		
		
	}
	
	
	//��ת�ڵ�
	public static void reverse(HeroNode head) {
		if(head.next == null||head.next.next == null) {
			return;
		}
		//����һ����ʱָ�����ԭ��������
		HeroNode cur = head.next;
		HeroNode next = null;//ָ��ǰ�ڵ�cur����һ���ڵ�
		HeroNode reverseHead = new HeroNode(0,"","");
		while(cur!= null) {
				
			next = cur.next;//����cur��Next�ڵ�
			cur.next = reverseHead.next;
			reverseHead.next = cur;
			cur = next;
		}
		head.next = reverseHead.next;
		
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
		


	
	public static void main(String[] args) {
		//���в���
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		
		HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");
		HeroNode hero2 = new HeroNode(2,"¬����","������");


		//��������
		SingleLikList singlelinklist = new SingleLikList();
		singlelinklist.add(hero1);
		singlelinklist.add(hero2);
		singlelinklist.add(hero4);
		singlelinklist.add(hero3);
		singlelinklist.add(hero3);
		singlelinklist.list();
		
		//HeroNode hero = new HeroNode(2,"У��","����");
		
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
