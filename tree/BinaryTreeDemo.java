package tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree = new BinaryTree();
		HeroNode root = new HeroNode(1,"�ν�");
		HeroNode node2 = new HeroNode(2,"����");

		HeroNode node3 = new HeroNode(3,"¬����");

		HeroNode node4 = new HeroNode(4,"�ֳ�");
		
		HeroNode node5 = new HeroNode(5,"��");

		binaryTree.setRoot(root);
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		
		binaryTree.delNode(3);
		binaryTree.preOrder();

//		System.out.println("ǰ�����");
//		binaryTree.preOrder();
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if(resNode != null) {
//			System.out.printf("�ҵ��ˣ���ϢΪno=%d name=%s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("û���ҵ�no = %d��Ӣ��",5);
//		}
	}
	
	 static class BinaryTree{
		private HeroNode root;

		public void setRoot(HeroNode root) {
			this.root = root;
		}
		
		
		//ǰ�����
		public void preOrder() {
			if(this.root != null) {
				this.root.preOrder();
			}else {
				System.out.println("������Ϊ�գ��޷�����");
			}
		}
		
		//ǰ������
		public HeroNode preOrderSearch(int no) {
			if(root != null) {
				return root.preOrdersearch(no);
			}else {
				return null;
			}
		}
		
		//��������
		public HeroNode infixOrderSearch(int no) {
			if(root != null) {
				return root.infixOrderSearch(no); 
			}else {
				return null;
			}
		}
		
		//��������
		public HeroNode postOrderSearch(int no) {
			if(root != null) {
				return root.postOrdersearch(no);
			}else {
				return null;
			}
		}
		
		//�������
		public void infixOrder() {
			if(this.root != null) {
				this.root.infixOrder();
			}else {
				System.out.println("������Ϊ�գ��޷�����");
			}
		}
		
		//�������
		public void postOrder() {
			if(this.root != null) {
				this.root.postOrder();;
			}else {
				System.out.println("������Ϊ�գ��޷�����");
			}
		}
		
		//ɾ���ڵ�
		public void delNode(int no) {
			if(root != null) {
				//���ֻ��һ��root�ڵ㣬ֱ���ж�root�ǲ��Ǿ���Ҫɾ���Ľڵ�
				if(root.getNo() == no) {
					if(root.left != null) {
						if(root.right != null) {
							HeroNode temp = root.right;
							root = root.left;
							root.right = temp;
							return;
						}else {
							root = root.left;
						}
					}else if(root.right != null) {
						root = root.right;
					}else {
						root = null;
					}
				}
				else {
					root.delNode(no);
				}
			}
			
		}
	}
	
	//����HeroNode�ڵ�
	static class HeroNode{
		private int no;
		private String name;
		private HeroNode left;
		private HeroNode right;
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
		
		//��дǰ������ķ���
		public void preOrder() {
			System.out.println(this);//��ӡ���ڵ�
			if(this.left != null) {
				this.left.preOrder();
			}
			if(this.right != null) {
				this.right.preOrder();
			}
		}
		
		//��������ڵ�
		public void infixOrder() {
			//�ݹ����������������
			if(this.left != null) {
				this.left.infixOrder();
			}
			//������ڵ�
			System.out.println(this);
			//�ݹ����������������
			if(this.right != null) {
				this.right.infixOrder();
			}
		}
		
		//��������
		public void postOrder() {
			if(this.left != null) {
				this.left.postOrder();
			}
			if(this.right != null) {
				this.right.postOrder();
			}
			System.out.println(this);
		}
		
		//ǰ������
		public HeroNode preOrdersearch(int no) {
			System.out.println("��ʼǰ�������");
			if(this.no == no) {
				return this;
			}
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.preOrdersearch(no);
			}
			if(resNode != null) {
				return resNode;//˵�������������ҵ���Ӧ�Ľڵ�
			}if(this.right != null) {
				resNode = this.right.preOrdersearch(no);
			}
			return resNode;
		}
		
		//��������
		public HeroNode infixOrderSearch(int no) {
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.infixOrderSearch(no);
			}
			if(resNode != null) {
				return resNode;
			}
			System.out.println("��ʼ��������");
			if(this.no == no)
				return this;
			if(this.right != null) {
				resNode = this.right.infixOrderSearch(no);
			}
			return resNode;
		}
		
		//��������
		public HeroNode postOrdersearch(int no) {
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.postOrdersearch(no);
			}
			if(resNode != null) {
				return resNode;
			}
			if(this.right != null) {
				resNode = this.right.postOrdersearch(no);
			}
			if(resNode != null) {
				return resNode;
			}
			System.out.println("��ʼ�������");
			if(this.no == no) {
				return this;
			}
			return resNode;
		}
		
		//ɾ���ڵ�
		public void delNode(int no) {
			/*
			 * ��Ϊ���ǵĶ������ǵ���ģ����������жϵ�ǰ�ڵ���ӽڵ��Ƿ���Ҫɾ���ڵ㣬������ȥ�жϵ�ǰ����ڵ��ǲ�����Ҫɾ���ڵ�
			 * �����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.left = null�����Ҿͷ��أ������ݹ�ɾ����
			 * �����ǰ�ڵ�����ӽڵ㲻Ϊ�գ��������ӽڵ����Ҫɾ���Ľڵ㣬�ͽ�this.rigth = null,���Ҿͷ��أ������ݹ�ɾ����
			 * �����������û��ɾ���ڵ㣬��ô����Ҫ�����������еݹ�ɾ��
			 * �����һ��Ҳû��ɾ���ڵ㣬�������������еݹ�ɾ��
			 * 
			 */
			if(this.left != null && this.left.no == no) {
				if(this.left.left != null) {
					System.out.println("��������");
					if(this.left.right != null) {
						//�����ɾ���ڵ�������������������������������Ϊ�ڵ㣬����������������������
						HeroNode temp = this.left.right;
						this.left = this.left.left;
						this.left.right = temp;
						return;

					}else {
						this.left = this.left.left;
						return;
					}
				}else if(this.left.right!= null) {
					this.left = this.left.right;
					return;
				}else {
					this.left = null;
					return;
				}
			}
			if(this.right != null && this.right.no == no) {
				System.out.println("�ҽ������");

				if(this.right.left != null) {
					if(this.right.right != null) {
						//�����ɾ���ڵ�������������������������������Ϊ�ڵ㣬����������������������
						HeroNode temp = this.right.right;
						this.right = this.right.left;
						this.right.right = temp;
						return;

					}else {
						this.right = this.right.left;
						return;
					}
				}else if(this.right.right!= null) {
					this.right = this.right.right;
					return;
				}else {
					this.right = null;
					return;
				}
			}
			if(this.left != null) {
				System.out.println("��������1");

				this.left.delNode(no);
			}
			if(this.right != null) {
				System.out.println("�ҽ������1");

				this.right.delNode(no);
			}
		}
		
	}

}
