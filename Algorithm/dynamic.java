package Algorithm;

public class dynamic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] w = {1,4,3}; //��Ʒ������
		int[] val = {1500,3000,2000};
		int n = val.length; //��Ʒ�ĸ���
		int m = 4;//��������
		//Ϊ�˼��������Ʒ������������ά����
		int[][] path = new int[n+1][m+1];
		
		
		//������ά���� v v[i][j]��ʾ��ǰi����Ʒ���ܹ�װ��������ij�ı����е�����ֵ
		int[][] v = new int[n+1][m+1];
		
		//��ʼ����һ�к͵�һ��
		for(int i = 0; i < v.length; i++)
			v[i][0] = 0;
		for(int i = 0; i < v[0].length; i++)
			v[0][i] = 0;
		
		
//		for(int i = 0; i < v.length; i++) {
//			for(int j = 1; j < v[0].length; j++)
//				System.out.println(v[i][j]);
//		}
		
		for(int i = 1; i < v.length; i++) {
			for(int j = 1; j < v[0].length; j++)
				if(w[i-1] > j) {
					v[i][j] = v[i-1][j];
				}else {
					
					//��Ϊ�Ǵ�1 ��ʼ�� ��ʽ��Ҫ����
					//v[i][j] = Math.max(v[i-1][j],val[i-1] + v[i-1][j-w[i-1]]);
					//Ϊ�˼�¼��Ʒ���뱳������������ܼ�ʹ����ʽ
					if(v[i-1][j] < val[i-1] + v[i-1][j-w[i-1]]) {
						v[i][j] = val[i-1] + v[i-1][j-w[i-1]];
						path[i][j] = 1;
					}else {
						v[i][j] = val[i-1];
					}
				}
		}
		
		for(int i = 0; i < v.length; i++) {
		for(int j = 1; j < v[0].length; j++) {
			System.out.printf(v[i][j] + " ");
			
		}
		System.out.println();
			
	}
		
//		for(int i = 0; i < path.length; i++) {
//			for(int j = 1; j < path[0].length; j++)
//				if(path[i][j] == 1)
//					System.out.printf("��%d����Ʒ���뱳��\n",i);
//		}
//	}
//	
	int i = path.length -1;
	int j = path[0].length -1;
	while(i >0 && j >0) {
		//�������}
		if(path[i][j]==1) {
			System.out.printf("��%d����Ʒ���뱳��\n",i);

			j -= w[i-1];
		}
		i--;

	}
	}

}
