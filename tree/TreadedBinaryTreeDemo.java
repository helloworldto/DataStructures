package tree;
/*
 * �е��Ѷȵ�����
 * 
 * ǰ�����������������ʵ��
 */
import tree.BinaryTreeDemo.HeroNode;

public class TreadedBinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HeroNode root = new HeroNode(1,"tom");
		HeroNode node2 = new HeroNode(3,"jack");
		HeroNode node3 = new HeroNode(6,"smith");
		HeroNode node4 = new HeroNode(8,"marry");
		HeroNode node5 = new HeroNode(10,"king");
		HeroNode node6 = new HeroNode(14,"dim");

		//������ �Ժ��ݹ鴴��
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		//����������
		BinaryTree threadedBinaryTree = new BinaryTree();
		threadedBinaryTree.setRoot(root);
		threadedBinaryTree.threadedNodes();

		//����   ��10�Ž��Node5����
		HeroNode leftNode = node2.getLeft();
		HeroNode rightNode = node2.getRight();
		System.out.println("10�Ž���ǰ������ǣ�"+ leftNode);//3
		System.out.println("10�Ž���ǰ������ǣ�"+ rightNode);//1
	



		

	}
	
	 static class BinaryTree{
			private HeroNode root;
			//Ϊ�˴��������� ��Ҫ����ָ��ǰ����ǰ������ָ��
			private HeroNode pre = null;

			public void setRoot(HeroNode root) {
				this.root = root;
			}
			
			public void threadedNodes() {
				this.threadedNodes(root);
			}
			
//			public void prethreadNodes() {
//				this.prethreadNodes(root);
//			}
			
			public void preThreadList() {
				//����һ����������浱ǰ�����Ľ�㣬��root��ʼ
				HeroNode node = root;
				
			}
			

			
			
			public void threadedList() {
				//����һ���������洢��ǰ�����Ľ�㣬��root��ʼ
				HeroNode node = root;
				while(node != null) {
					//ѭ�����ҵ�leftType == 1�Ľ�㣬��һ���ҵ��ľ�������ĵ�һ�����
					//�ҵ�����ʱ���ոý�㿪ʼ������
					//��������Ч���
					while(node.getLeftType() == 0) {
						node = node.getLeft();
					}
					//��ӡ��ǰ������
					System.out.println(node);
					//�������һ��leftType == 1�����ҵ��������ͷ�����ڿ��԰���ͷ���������� ����ý���к�̽�㣬��һֱ���
					while(node.getRightType() == 1) {
						//��ȡ����ǰ���ĺ�̽��
						node = node.getRight();
						System.out.println(node);
					}
					//���û�к�̽�㣬���������Ǹ���Ů˫ȫ�ĸ���㣬��ʱ���������������һ�����Ӧ���Ǹ�����������
					node = node.getRight();
				}
			}

			//�д�˼��
//			public void prethreadNodes(HeroNode node) {
//				//���node == null������������
//				if(node == null) {
//					return;
//				}else {
//					//�ȸ�������������
//					if(node.getLeft() != null && node.getRight() != null) {
//						node.setLeft(pre);
//						node.setLeftType(1);;
//					}
//					
//					if(pre != null && pre.getRight() == null) {
//						pre.setRight(node);
//						pre.setRightType(1);
//					}
//						pre = node;
//					prethreadNodes(node.getLeft());
//					prethreadNodes(node.getRight());
//					
//					
//				}
//			}
			
			public void threadedNodes(HeroNode node) {
				//���node == null,����������
				if(node == null) {
					return;
				}else {
					//�ȴ����������������������
					threadedNodes(node.getLeft());
					//�ȴ���ǰ����ǰ�����
					if(node.getLeft() == null) {
						//�õ�ǰ������ָ��ָ��ǰ�����
						node.setLeft(pre);
						//�޸ĵ�ǰ��ָ�������
						node.setLeftType(1);
					}
					//���������  ��Ҫ����һ���д���
					if(pre!=null&&pre.getRight() == null) {
						pre.setRight(node);
						pre.setRightType(1);
					}
					
					//ÿ����һ�������õ�ǰ�������һ������ǰ�����
					pre = node;
					
					threadedNodes(node.getRight());
				
				}
			

			}
	 }	
	
	//����HeroNode�ڵ�
		static class HeroNode{
			private int no;
			private String name;
			private HeroNode left;
			private HeroNode right;
			
			/*
			 * ����
			 * ���leftType == 0 ��ʾָ������������������1���ʾָ��ǰ�����
			 * ���fightTpye == 0��ʾָ������������������1���ʾָ��������
			 */
			private int leftType;
			private int rightType;
			
			public int getLeftType() {
				return leftType;
			}
			public void setLeftType(int leftType) {
				this.leftType = leftType;
			}
			public int getRightType() {
				return rightType;
			}
			public void setRightType(int rightType) {
				this.rightType = rightType;
			}
			public HeroNode(int no, String name) {
				super();
				this.no = no;
				this.name = name;
			}
			public int getNo() {
				return no;
			}
			public void setNo(int no) {
				this.no = no;
			}
			public String getName() {
				return name;
			}
			public void setName(String name) {
				this.name = name;
			}
			public HeroNode getLeft() {
				return left;
			}
			public void setLeft(HeroNode left) {
				this.left = left;
			}
			public HeroNode getRight() {
				return right;
			}
			public void setRight(HeroNode right) {
				this.right = right;
			}
			@Override
			public String toString() {
				return "HeroNode [no=" + no + ", name=" + name + "]";
			}
		}	

}
