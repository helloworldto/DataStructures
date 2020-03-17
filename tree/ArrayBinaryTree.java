package tree;
/*
 * ������ǰ������������
 */

public class ArrayBinaryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,7};//1 2 4 5 3 6 7 ǰ�� 4 2 5 1 6 3 7 ����  4 5 2 6 7 3 1 ����
		//����һ��ArrBinaryTree
		ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
		arrBinaryTree.postOrder(0);

	}
	
	static class ArrBinaryTree{
		private int[] arr; //�洢���ݽ�������

		public ArrBinaryTree(int[] arr) {
			super();
			this.arr = arr;
		}
		
		//��дһ�����������˳��洢��������ǰ�����
		public void preOrder(int index) {
			//�������Ϊ�գ�����arr.length = 0
			if(arr == null || arr.length == 0) {
				System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
				
			}
			//�����ǰ���Ԫ��
			System.out.println(arr[index]);
			//����ݹ����
			if((index*2 + 1) < arr.length) {
				preOrder(2*index + 1);
				//������������2*index+1
			}
			//���ұ���
			if((index*2 + 1) < arr.length) {
				preOrder(2*index + 2);
				//����������2*index+2
			}
		}
		
		//�������
		public void infixOrder(int index) {
			//�������Ϊ�գ�����arr.length = 0
			if(arr == null || arr.length == 0) {
				System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
				
			}
			if((index*2 + 1) < arr.length) {
				infixOrder(2*index + 1);
				//������������2*index+1
			}
			//�����ǰ���Ԫ��
			System.out.println(arr[index]);
			//����ݹ����
			
			//���ұ���
			if((index*2 + 1) < arr.length) {
				infixOrder(2*index + 2);
				//����������2*index+2
			}
		}
		
		//�������
		public void postOrder(int index) {
			//�������Ϊ�գ�����arr.length = 0
			if(arr == null || arr.length == 0) {
				System.out.println("����Ϊ�գ����ܰ��ն�������ǰ�����");
				
			}
		
			//����ݹ����
			if((index*2 + 1) < arr.length) {
				postOrder(2*index + 1);
				//������������2*index+1
			}
			//���ұ���
			if((index*2 + 1) < arr.length) {
				postOrder(2*index + 2);
				//����������2*index+2
			}
			//�����ǰ���Ԫ��
			System.out.println(arr[index]);
		}
		
	}

}
