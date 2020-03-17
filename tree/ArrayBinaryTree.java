package tree;
/*
 * 将数组前序中序后序遍历
 */

public class ArrayBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};//1 2 4 5 3 6 7 前序 4 2 5 1 6 3 7 中序  4 5 2 6 7 3 1 后序
		//创建一个ArrBinaryTree
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
		arrBinaryTree.postOrder(0);

	}
	
	static class ArrBinaryTree{
		private int[] arr; //存储数据结点的数组

		public ArrBinaryTree(int[] arr) {
			super();
			this.arr = arr;
		}
		
		//编写一个方法，完成顺序存储二叉树的前序遍历
		public void preOrder(int index) {
			//如果数组为空，或者arr.length = 0
			if(arr == null || arr.length == 0) {
				System.out.println("数组为空，不能按照二叉树的前序遍历");
				
			}
			//输出当前这个元素
			System.out.println(arr[index]);
			//向左递归遍历
			if((index*2 + 1) < arr.length) {
				preOrder(2*index + 1);
				//规则左子树是2*index+1
			}
			//向右遍历
			if((index*2 + 1) < arr.length) {
				preOrder(2*index + 2);
				//规则右子树2*index+2
			}
		}
		
		//中序遍历
		public void infixOrder(int index) {
			//如果数组为空，或者arr.length = 0
			if(arr == null || arr.length == 0) {
				System.out.println("数组为空，不能按照二叉树的前序遍历");
				
			}
			if((index*2 + 1) < arr.length) {
				infixOrder(2*index + 1);
				//规则左子树是2*index+1
			}
			//输出当前这个元素
			System.out.println(arr[index]);
			//向左递归遍历
			
			//向右遍历
			if((index*2 + 1) < arr.length) {
				infixOrder(2*index + 2);
				//规则右子树2*index+2
			}
		}
		
		//后序遍历
		public void postOrder(int index) {
			//如果数组为空，或者arr.length = 0
			if(arr == null || arr.length == 0) {
				System.out.println("数组为空，不能按照二叉树的前序遍历");
				
			}
		
			//向左递归遍历
			if((index*2 + 1) < arr.length) {
				postOrder(2*index + 1);
				//规则左子树是2*index+1
			}
			//向右遍历
			if((index*2 + 1) < arr.length) {
				postOrder(2*index + 2);
				//规则右子树2*index+2
			}
			//输出当前这个元素
			System.out.println(arr[index]);
		}
		
	}

}
