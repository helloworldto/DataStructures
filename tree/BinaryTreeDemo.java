package tree;

public class BinaryTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BinaryTree binaryTree = new BinaryTree();
		HeroNode root = new HeroNode(1,"宋江");
		HeroNode node2 = new HeroNode(2,"吴用");

		HeroNode node3 = new HeroNode(3,"卢俊义");

		HeroNode node4 = new HeroNode(4,"林冲");
		
		HeroNode node5 = new HeroNode(5,"张");

		binaryTree.setRoot(root);
		root.setLeft(node2);
		root.setRight(node3);
		node3.setRight(node4);
		node3.setLeft(node5);
		
		binaryTree.delNode(3);
		binaryTree.preOrder();

//		System.out.println("前序遍历");
//		binaryTree.preOrder();
//		HeroNode resNode = binaryTree.preOrderSearch(5);
//		if(resNode != null) {
//			System.out.printf("找到了，信息为no=%d name=%s",resNode.getNo(),resNode.getName());
//		}else {
//			System.out.printf("没有找到no = %d的英雄",5);
//		}
	}
	
	 static class BinaryTree{
		private HeroNode root;

		public void setRoot(HeroNode root) {
			this.root = root;
		}
		
		
		//前序遍历
		public void preOrder() {
			if(this.root != null) {
				this.root.preOrder();
			}else {
				System.out.println("二叉树为空，无法遍历");
			}
		}
		
		//前序搜索
		public HeroNode preOrderSearch(int no) {
			if(root != null) {
				return root.preOrdersearch(no);
			}else {
				return null;
			}
		}
		
		//中序搜索
		public HeroNode infixOrderSearch(int no) {
			if(root != null) {
				return root.infixOrderSearch(no); 
			}else {
				return null;
			}
		}
		
		//后序搜索
		public HeroNode postOrderSearch(int no) {
			if(root != null) {
				return root.postOrdersearch(no);
			}else {
				return null;
			}
		}
		
		//中序遍历
		public void infixOrder() {
			if(this.root != null) {
				this.root.infixOrder();
			}else {
				System.out.println("二叉树为空，无法遍历");
			}
		}
		
		//后序遍历
		public void postOrder() {
			if(this.root != null) {
				this.root.postOrder();;
			}else {
				System.out.println("二叉树为空，无法遍历");
			}
		}
		
		//删除节点
		public void delNode(int no) {
			if(root != null) {
				//如果只有一个root节点，直接判断root是不是就是要删除的节点
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
	
	//创建HeroNode节点
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
		
		//编写前序遍历的方法
		public void preOrder() {
			System.out.println(this);//打印父节点
			if(this.left != null) {
				this.left.preOrder();
			}
			if(this.right != null) {
				this.right.preOrder();
			}
		}
		
		//中序遍历节点
		public void infixOrder() {
			//递归向左子树中序遍历
			if(this.left != null) {
				this.left.infixOrder();
			}
			//输出父节点
			System.out.println(this);
			//递归向右子树中序遍历
			if(this.right != null) {
				this.right.infixOrder();
			}
		}
		
		//后续遍历
		public void postOrder() {
			if(this.left != null) {
				this.left.postOrder();
			}
			if(this.right != null) {
				this.right.postOrder();
			}
			System.out.println(this);
		}
		
		//前序搜索
		public HeroNode preOrdersearch(int no) {
			System.out.println("开始前序查找了");
			if(this.no == no) {
				return this;
			}
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.preOrdersearch(no);
			}
			if(resNode != null) {
				return resNode;//说明在左子树中找到相应的节点
			}if(this.right != null) {
				resNode = this.right.preOrdersearch(no);
			}
			return resNode;
		}
		
		//中序搜索
		public HeroNode infixOrderSearch(int no) {
			HeroNode resNode = null;
			if(this.left != null) {
				resNode = this.left.infixOrderSearch(no);
			}
			if(resNode != null) {
				return resNode;
			}
			System.out.println("开始中序搜索");
			if(this.no == no)
				return this;
			if(this.right != null) {
				resNode = this.right.infixOrderSearch(no);
			}
			return resNode;
		}
		
		//后序搜索
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
			System.out.println("开始后序查找");
			if(this.no == no) {
				return this;
			}
			return resNode;
		}
		
		//删除节点
		public void delNode(int no) {
			/*
			 * 因为我们的二叉树是单向的，所以我是判断当前节点的子节点是否需要删除节点，而不能去判断当前这个节点是不是需要删除节点
			 * 如果当前节点的左子节点不为空，并且左子节点就是要删除的节点，就将this.left = null，并且就返回（结束递归删除）
			 * 如果当前节点的右子节点不为空，并且右子节点就是要删除的节点，就将this.rigth = null,并且就返回（结束递归删除）
			 * 如果以上两步没有删除节点，那么就需要向左子树进行递归删除
			 * 如果上一步也没有删除节点，则向右子树进行递归删除
			 * 
			 */
			if(this.left != null && this.left.no == no) {
				if(this.left.left != null) {
					System.out.println("左结点搜索");
					if(this.left.right != null) {
						//如果该删除节点有左子树和右子树，将左子树代替为节点，并将右子树继续当右子树
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
				System.out.println("右结点搜索");

				if(this.right.left != null) {
					if(this.right.right != null) {
						//如果该删除节点有左子树和右子树，将左子树代替为节点，并将右子树继续当右子树
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
				System.out.println("左结点搜索1");

				this.left.delNode(no);
			}
			if(this.right != null) {
				System.out.println("右结点搜索1");

				this.right.delNode(no);
			}
		}
		
	}

}
