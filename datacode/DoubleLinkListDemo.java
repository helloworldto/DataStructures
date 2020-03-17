package datacode;

import datacode.SingleLinklistImprove.HeroNode;
import datacode.SingleLinklistImprove.SingleLikList;

public class DoubleLinkListDemo {
	
	
	

	//����HeroNode,ÿ��HeroNode�������һ���ڵ�
	static class HeroNode{

		public int no;
		public String name;
		public String nickname;
		public HeroNode next; //ָ����һ���ڵ�
		public HeroNode pre; //ָ��ǰһ���ڵ�
		
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
	
	static class DoubleLinkList{
	//�ȳ�ʼ��һ��ͷ�ڵ㣬ͷ�ڵ㲻��������ž��������
		private HeroNode head = new HeroNode(0,"","");
				
		public HeroNode getHead() {
			return head;
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
				//�Ľ� ��Ҫ�������
				//���뵽������ ��temp ��temp.next֮��
				//Ŀǰ��ʵ���������
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
			//���˳�ѭ����ʱ��tempֻ��������������
			//������ڵ��nextָ���µĽڵ�
			
		}
		
		
		//ɾ���ڵ�
		public void delete(int no) {
			if(head.next == null) {
				System.out.println("�����ǿյ�");
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
					//����������һ���ڵ㣬ִ�����������������ֿ�ָ���쳣
					temp.next.pre = temp.pre;

				}else {
					temp.pre.next = null;
				}
			}else {
				System.out.printf("���Ϊ%d��HeroNode������",no);

			}
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
		

	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2 = new HeroNode(2,"¬����","������");
		HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");


		//��������
		DoubleLinkList doublelinklist = new DoubleLinkList();
		doublelinklist.add(hero1);
	
		
		doublelinklist.add(hero4);
		doublelinklist.add(hero2);
		doublelinklist.add(hero3);

		doublelinklist.list();
		HeroNode hero = new HeroNode(2,"У��","����");

		doublelinklist.update(hero);
		doublelinklist.list();

		doublelinklist.delete(2);
		doublelinklist.list();
		doublelinklist.delete(4);
		doublelinklist.list();




		

	}

}
