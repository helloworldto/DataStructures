package Binarysorttree;
/*
 * 不建议这样做
 * 括号太多 会乱
 */

public class BinarySortTreeDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {7,3,10,12,5,1,9,2};
		BinarySortTree binarySortTree = new BinarySortTree();
		for(int i = 0; i < array.length; i++) {
			binarySortTree.add(new Node(array[i]));
		}
		
		//中序遍历二叉排序树
		System.out.println("中序遍历二叉排序树");
		binarySortTree.infixOrder();
		binarySortTree.delNode(10);
		//中序遍历二叉排序树
		System.out.println("中序遍历二叉排序树");
		binarySortTree.infixOrder();
		//测试删除叶子结点
		binarySortTree.delNode(3);
		System.out.println("中序遍历二叉排序树");

		binarySortTree.delNode(7);
		System.out.println("中序遍历二叉排序树");
		binarySortTree.infixOrder();

	}
	
	static class BinarySortTree {
		private Node root;
		//添加结点的方法
		public void add(Node node) {
			if(root == null) {
				root = node;  //如果root为空则直接让root指向node
			}else {
				root.add(node);
			}
		}
		
		//中序遍历
		public void infixOrder() {
			if(root != null) {
				root.infixOrder();
			}else {
				System.out.println("该二叉树为空");
			}
		}
		
		//查找要删除的结点
		public Node search(int value) {
			if(root == null) {
				return null;
			}else {
				return root.search(value);
			}
		}
		
		//删除结点
		public void delNode(int value) {
			if(root == null)
				return;
			else {
				//需要先找到要删除的结点 targetNode
				Node targetNode = search(value);
				//如果没有找到要删除的结点
				if(targetNode == null) {
					return;
				}
				//如果我们发现当前二叉树只有一个结点
				if(root.left == null && root.right == null) {
					root = null;
					return;
				}

				
				
				//去找到targetNode的父结点
				Node parent = searchParent(value);
				//如果要删除的结点是叶子结点
				if(targetNode.left == null && targetNode.right == null) {
					//判断targetNode 是父结点的左子结点，还是右子结点
					if(parent.left != null && parent.left.value == value) {
						parent.left = null;
					}else if(parent.right != null && parent.right.value == value){
						parent.right = null;
					}
				} else if (targetNode.left != null && targetNode.right != null) {
//					int minVal = delRigthTree(targetNode.right);
//					targetNode.value = minVal;
					//下面代码是按左子树的最大值
					int maxVal = delLeftTree(targetNode.left);
					targetNode.value = maxVal;
				} else {
					// 删除只有一个子树的结点
					// 如果要删除的结点有左子结点
					if (targetNode.left != null) {
						if(parent != null) {
							// 如果targetNode 是parent的左子结点
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
							// 如果要删除结点有右子结点
							if (parent.left.value == value) {
								if (targetNode.right != null) {
									// 如果targetNode 是parent的左子结点
									
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
		
		
		//找左子树的最大结点 即找左子树的最大右结点
		public int delLeftTree(Node node) {
			Node target = node;
			while(target.right != null){
				target = target.right;
			}
			delNode(target.value);
			return target.value;
		}
		
		//删除双子树结点
		
		//1.返回的以Node为根节点的二叉排序树的最小结点的值
		//2.删除Node为根节点的二叉排序树的最小结点
		public int delRigthTree(Node node) {
			Node target = node;
			//循环的查找左子结点，就会找到最小值
			while(target.left != null) {
				target = target.left;
			}
			//这时 target指向最小结点
			delNode(target.value);
			return target.value;
		}
		
		//查找父结点
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
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		
		//添加结点的方法
		//使用递归的方式添加结点，需要注意满足二叉排序树的要求
		public void add(Node node) {
			if(node == null) {
				return;
			}
			
			//判断传入的结点的值和根结点的关系
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
		}
		
		//找到要删除的结点
		public Node search(int value) {
			if(value == this.value) {
				//找到就是该结点
				return this;
			}else if(value < this.value){
				//如果左子结点为空
				if(this.left == null) {
					return null;
				}
				return this.left.search(value);
			}else {
				//如果当前查找的值不小于结点，向右子树递归查找
				if(this.right == null) {
					return null;
				}
				return this.right.search(value);
			}
		}
		
		
		//查找要删除你结点的父结点
		public Node searchParent(int value) {
			//如果当前结点就是要删除的结点的父结点，就返回
			if((this.left != null && this.left.value == value)
					||(this.right != null && this.right.value == value)) {
				return this;
			}else {
				//如果查找的值小于当前结点的值，并且当前结点的左子结点不为空
				if(value < this.value && this.left != null){
					return this.left.searchParent(value);
				}else if(value > this.value && this.right != null) {
					return this.right.searchParent(value);
				}else {
					return null; //没有找到父结点
				}
			}
		}
		
		
		
		//中序遍历
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
