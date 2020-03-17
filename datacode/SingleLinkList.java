package datacode;
/*
 * temp.next�ĺ���
 * �Լ�temp�ĺ���
 * 
 */



public class SingleLinkList {

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
		//��ӽڵ㵽��������
		/*
		 * �������Ǳ��˳��ʱ
		 * 1.�ҵ���ǰ��������ڵ�
		 * 2.���������ڵ��nextָ���µĽڵ�
		 */
		public void add(HeroNode heroNode) {
			//��Ϊͷ���ܶ���������Ҫ��������temp
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
			temp.next = heroNode;
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
		
		

	
	
		

	}
		


	
	public static void main(String[] args) {
		//���в���
		HeroNode hero1 = new HeroNode(1,"�ν�","��ʱ��");
		HeroNode hero2 = new HeroNode(2,"¬����","������");
		HeroNode hero3 = new HeroNode(3,"����","�Ƕ���");
		HeroNode hero4 = new HeroNode(4,"�ֳ�","����ͷ");

		//��������
		SingleLikList singlelinklist = new SingleLikList();
		singlelinklist.add(hero1);
		singlelinklist.add(hero2);
		singlelinklist.add(hero4);
		singlelinklist.add(hero3);

		singlelinklist.list();



	}



}
