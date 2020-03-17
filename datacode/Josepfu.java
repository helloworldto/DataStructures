package datacode;

public class Josepfu {
	
	static class Boy{
		private int no; //���
		private Boy next;
		public int getNo() {
			return no;
		}
		public void setNo(int no) {
			this.no = no;
		}
		public Boy getNext() {
			return next;
		}
		public void setNext(Boy next) {
			this.next = next;
		}
		public Boy(int no) {
			this.no = no;
		}


	
	}
	
	//�������ε�������
	static class CicleSingleLinkList{
		//����һ��first�ڵ㣬��ǰû�б��
		private Boy first = new Boy(-1);
		//���С���ڵ㣬������һ�����ε�����
		public void addBoy(int nums) {
			//nums ��Ҫ���м���
			if(nums < 2) {
				System.out.println("nums��ֵ����ȷ");
				return;
			}
			Boy curBoy = null; //�����ڵ�
			//ʹ��forѭ��������������
			for(int i = 1; i <= nums;i++) {
				Boy boy = new Boy(i);
				if(i == 1) {
					first = boy;
					curBoy = first; //curBoyָ���һ��С��
				}else {
					 curBoy.setNext(boy);
					 boy.setNext(first);
					 curBoy = boy;
				}
			}
		}
		
		//������������
		public void list() {
			//�����Ƿ�Ϊ��
			if(first == null) {
				System.out.println("����Ϊ��");
				return;
			}
			Boy curBoy = first;
			while(true) {
				System.out.printf("Boy�ı��%d\n",curBoy.no);
				if(curBoy.getNext() == first) {
					System.out.println("�Ѿ���������\n");
					break;
				}
				curBoy = curBoy.getNext();
			}
		}
		
		//ɾ��
		/*
		 * �Ƚ�first �� helper�ƶ�k-1��
		 */
		public void delete(int startNo,int countNum,int nums) {
			//���ĸ�С����ʼ��  ������ ����м���С��
			if(first == null||startNo < 1|| startNo > nums) {
				System.out.println("������������������");
				return;
				}
			Boy helper = first;
			while(true) {
				if(helper.next == first)
					break;
				helper = helper.getNext();
			
			}
			//��ʼλ��
			for(int i = 0; i < startNo -1; i++) {
				first = first.getNext();
				helper = helper.getNext();
			}
			
			//ѭ����Ȧ����
			while(true) {
				if(helper.no == first.no)
					break;
				//��first��helperͬʱ�ƶ��ܶ��
				for(int i =0; i < countNum-1;i++) {
					first = first.getNext();
					helper = helper.getNext();
				}
				//��ʱfirst����λ��Ҫ��Ȧ
				System.out.printf("Ҫ��Ȧ��С����%d\n",first.getNo());
				first = first.next;
				helper.next = first;
				//helper.setNext(first);
			}
			System.out.printf("���һλ��%d",helper.getNo());
			
			
		}
	}	
		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		CicleSingleLinkList circlesinglelinklist = new CicleSingleLinkList();
		circlesinglelinklist.addBoy(5);
		circlesinglelinklist.list();
		//û�п��ǵ�һ�����  Ϊ��,���ں��������һ������û���õ������ж���
		circlesinglelinklist.delete(1, 2, 5);
	}

}
