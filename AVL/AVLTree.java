package AVL;
/*
 * ����������˼·�ܽ᣺
 * 1���������������ĳ��ȱ�������������Ҫ����ת
 * 2.
 */


public class AVLTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] array = {4,3,6,5,7,8};
		int[] array = {10,12,8,9,7,6};

		AVLTreeC avlTree = new AVLTreeC();
		for(int i = 0; i < array.length; i++) {
			avlTree.add(new Node(array[i]));
		}
		
		//����
		System.out.println("�������");
		avlTree.infixOrder();
		
		System.out.println("����");
		System.out.println(avlTree.root.height());
		
		System.out.println("�������ĳ��ȣ�"+avlTree.getRoot().left.height());
		System.out.println("�������ĳ���"+avlTree.getRoot().right.height());
		System.out.println("��ǰ�����"+avlTree.getRoot().value);
		System.out.println("��ǰ����������"+avlTree.getRoot().right.value);


	}
	
	//����AVL��
	static class AVLTreeC{
		private Node root;
		public Node getRoot() {
			return root;
		}

		//��ӽ��ķ���
		public void add(Node node) {
			if(root == null) {
				root = node;  //���rootΪ����ֱ����rootָ��node
			}else {
				root.add(node);
			}
		}
		
		//�������
		public void infixOrder() {
			if(root != null) {
				root.infixOrder();
			}else {
				System.out.println("�ö�����Ϊ��");
			}
		}
		
		//����Ҫɾ���Ľ��
		public Node search(int value) {
			if(root == null) {
				return null;
			}else {
				return root.search(value);
			}
		}
		
		//ɾ�����
		public void delNode(int value) {
			if(root == null)
				return;
			else {
				//��Ҫ���ҵ�Ҫɾ���Ľ�� targetNode
				Node targetNode = search(value);
				//���û���ҵ�Ҫɾ���Ľ��
				if(targetNode == null) {
					return;
				}
				//������Ƿ��ֵ�ǰ������ֻ��һ�����
				if(root.left == null && root.right == null) {
					root = null;
					return;
				}

				
				
				//ȥ�ҵ�targetNode�ĸ����
				Node parent = searchParent(value);
				//���Ҫɾ���Ľ����Ҷ�ӽ��
				if(targetNode.left == null && targetNode.right == null) {
					//�ж�targetNode �Ǹ��������ӽ�㣬�������ӽ��
					if(parent.left != null && parent.left.value == value) {
						parent.left = null;
					}else if(parent.right != null && parent.right.value == value){
						parent.right = null;
					}
				} else if (targetNode.left != null && targetNode.right != null) {
//					int minVal = delRigthTree(targetNode.right);
//					targetNode.value = minVal;
					//��������ǰ������������ֵ
					int maxVal = delLeftTree(targetNode.left);
					targetNode.value = maxVal;
				} else {
					// ɾ��ֻ��һ�������Ľ��
					// ���Ҫɾ���Ľ�������ӽ��
					if (targetNode.left != null) {
						if(parent != null) {
							// ���targetNode ��parent�����ӽ��
							if (parent.left.value == value) {
								parent.left = targetNode.left;
							} else {
								parent.right = targetNode.left;
							}
						}else {
							root = targetNode.left;
						}
	
					}
					else {
						if(parent != null) {
							// ���Ҫɾ����������ӽ��
							if (parent.left.value == value) {
								if (targetNode.right != null) {
									// ���targetNode ��parent�����ӽ��
									
										parent.left = targetNode.right;
									} else {
										parent.right = targetNode.right;
									}
								
							}
						}else {
							root = root.left;
						}
		
					}
				}

			}
		}
		
		
		//��������������� ����������������ҽ��
		public int delLeftTree(Node node) {
			Node target = node;
			while(target.right != null){
				target = target.right;
			}
			delNode(target.value);
			return target.value;
		}
		
		//ɾ��˫�������
		
		//1.���ص���NodeΪ���ڵ�Ķ�������������С����ֵ
		//2.ɾ��NodeΪ���ڵ�Ķ�������������С���
		public int delRigthTree(Node node) {
			Node target = node;
			//ѭ���Ĳ������ӽ�㣬�ͻ��ҵ���Сֵ
			while(target.left != null) {
				target = target.left;
			}
			//��ʱ targetָ����С���
			delNode(target.value);
			return target.value;
		}
		
		//���Ҹ����
		public Node searchParent(int value) {
			if(root == null)
				return null;
			else
				return root.searchParent(value);
		}
	}
	

	static class Node{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			super();
			this.value = value;
		}
		
		//�����������ĸ߶�
		public int leftHeight() {
			if(left == null)
				return 0;
			return left.height();
		}	
		
		//�����������ĸ߶�
		public int rightHeight(){
			if(right == null)
				return 0;
			return right.height();
		}
		//�����Ըõ�Ϊ���ڵ�����ĳ���
		public int height() {
			return Math.max(left == null ? 0 : left.height(), right == null ? 0 :right.height()) + 1;
		}
		
		
		//����ת����
		private void rightRotate() {
			//�����µĽ�㣬�Ե�ǰ������ֵ
			Node newNode = new Node(value);
			//�ѵ�ǰ�½�������������Ϊ��ǰ����������
			newNode.right = right;
			//�ѵ�ǰ�½�������������Ϊ��ǰ������������������
			newNode.left = left.right;
			//�ѵ�ǰ����ֵ����Ϊ��������ֵ
			value = left.value;
			//�ѽ��� ��������Ϊ�½��
			right = newNode;
			//������������
			left = left.left;
		}
		
		//����ת����
		private void leftRotate() {
			//�����µĽ�㣬�Ե�ǰ������ֵ
			Node newNode = new Node(value);
			//�µĽ�������������Ϊ��ǰ����������
			newNode.left = left;
			//�½�������������Ϊ��ǰ������������������
			newNode.right = right.left;
			//�ѵ�ǰ����ֵ��λ���ӽ���ֵ
			value = right.value;
			//�ѵ�ǰ��������������Ϊ�½��
			left = newNode;
			right = right.right;
			
		}
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		
		//��ӽ��ķ���
		//ʹ�õݹ�ķ�ʽ��ӽ�㣬��Ҫע�����������������Ҫ��
		public void add(Node node) {
			if(node == null) {
				return;
			}
			
			//�жϴ���Ľ���ֵ�͸����Ĺ�ϵ
			if(node.value < this.value) {
				if(this.left == null) {
					this.left = node;
				}else {
					this.left.add(node);
				}
			}else {
				if(this.right == null){
					this.right = node;
				}else {
					this.right.add(node);
				}
			}
			
			
			//�����һ����������������ĸ߶ȱ��������ĸ߶ȴ�1 ���������ת
			if(rightHeight() - leftHeight() >1) {
				if(right != null && right.leftHeight() > right.rightHeight()) {
					right.rightHeight();
					leftRotate();
				}else {
					leftRotate();

				}
				return;


			}if(leftHeight() - rightHeight() > 1) {
				if(left != null && left.rightHeight() > left.leftHeight()) {
					left.leftRotate();
					rightRotate();

				}else {
					rightRotate();
	
				}
				return;
			}
		}
		
		//�ҵ�Ҫɾ���Ľ��
		public Node search(int value) {
			if(value == this.value) {
				//�ҵ����Ǹý��
				return this;
			}else if(value < this.value){
				//������ӽ��Ϊ��
				if(this.left == null) {
					return null;
				}
				return this.left.search(value);
			}else {
				//�����ǰ���ҵ�ֵ��С�ڽ�㣬���������ݹ����
				if(this.right == null) {
					return null;
				}
				return this.right.search(value);
			}
		}
		
		
		//����Ҫɾ������ĸ����
		public Node searchParent(int value) {
			//�����ǰ������Ҫɾ���Ľ��ĸ���㣬�ͷ���
			if((this.left != null && this.left.value == value)
					||(this.right != null && this.right.value == value)) {
				return this;
			}else {
				//������ҵ�ֵС�ڵ�ǰ����ֵ�����ҵ�ǰ�������ӽ�㲻Ϊ��
				if(value < this.value && this.left != null){
					return this.left.searchParent(value);
				}else if(value > this.value && this.right != null) {
					return this.right.searchParent(value);
				}else {
					return null; //û���ҵ������
				}
			}
		}
		
		
		
		//�������
		public void infixOrder() {
			if(this.left != null) {
				this.left.infixOrder();
			}
			System.out.println(this);
			if(this.right != null) {
				this.right.infixOrder();
			}
		}
		
	}


}
