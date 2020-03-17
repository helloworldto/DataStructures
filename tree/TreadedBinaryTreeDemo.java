package tree;
/*
 * 有点难度的亚子
 * 
 * 前序中序后序线索化的实现
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

		//二叉树 以后会递归创建
		root.setLeft(node2);
		root.setRight(node3);
		node2.setLeft(node4);
		node2.setRight(node5);
		node3.setLeft(node6);
		
		//测试线索化
		BinaryTree threadedBinaryTree = new BinaryTree();
		threadedBinaryTree.setRoot(root);
		threadedBinaryTree.threadedNodes();

		//测试   以10号结点Node5测试
		HeroNode leftNode = node2.getLeft();
		HeroNode rightNode = node2.getRight();
		System.out.println("10号结点的前驱结点是："+ leftNode);//3
		System.out.println("10号结点的前驱结点是："+ rightNode);//1
	



		

	}
	
	 static class BinaryTree{
			private HeroNode root;
			//为了创建线索化 需要创建指向当前结点的前驱结点的指针
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
				//定义一额变量，保存当前遍历的结点，从root开始
				HeroNode node = root;
				
			}
			

			
			
			public void threadedList() {
				//定义一个变量，存储当前遍历的结点，从root开始
				HeroNode node = root;
				while(node != null) {
					//循环的找到leftType == 1的结点，第一个找到的就是中序的第一个结点
					//找到结点的时候按照该结点开始索引化
					//处理后的有效结点
					while(node.getLeftType() == 0) {
						node = node.getLeft();
					}
					//打印当前这个结点
					System.out.println(node);
					//当这道第一个leftType == 1表明找到了中序的头，现在可以按照头进行线索化 如果该结点有后继结点，则一直输出
					while(node.getRightType() == 1) {
						//获取到当前结点的后继结点
						node = node.getRight();
						System.out.println(node);
					}
					//如果没有后继结点，则这个结点是个子女双全的父结点，此时按照中序输出，后一个结点应该是父结点的右子树
					node = node.getRight();
				}
			}

			//有待思考
//			public void prethreadNodes(HeroNode node) {
//				//如果node == null，不能线索化
//				if(node == null) {
//					return;
//				}else {
//					//先根结点后左右子树
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
				//如果node == null,不能线索化
				if(node == null) {
					return;
				}else {
					//先处理左子树后中序后右子树
					threadedNodes(node.getLeft());
					//先处理当前结点的前驱结点
					if(node.getLeft() == null) {
						//让当前结点的左指针指向前驱结点
						node.setLeft(pre);
						//修改当前左指针的类型
						node.setLeftType(1);
					}
					//处理后序结点  需要在下一轮中处理
					if(pre!=null&&pre.getRight() == null) {
						pre.setRight(node);
						pre.setRightType(1);
					}
					
					//每处理一个结点后，让当前结点是下一个结点的前驱结点
					pre = node;
					
					threadedNodes(node.getRight());
				
				}
			

			}
	 }	
	
	//创建HeroNode节点
		static class HeroNode{
			private int no;
			private String name;
			private HeroNode left;
			private HeroNode right;
			
			/*
			 * 表明
			 * 如果leftType == 0 表示指向的是左子树，如果是1则表示指向前驱结点
			 * 如果fightTpye == 0表示指向的是右子树，如果是1则表示指向后驱结点
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
