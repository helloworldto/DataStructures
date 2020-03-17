package Algorithm;

import java.util.Arrays;

public class Dijkstra {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int[][] martex = new int[vertexs.length][vertexs.length];
		final int N = 65535;
		martex[0] = new int[] {N,5,7,N,N,N,2};
		martex[1] = new int[] {5,N,N,9,N,N,3};

		martex[2] = new int[] {7,N,N,N,8,N,N};

		martex[3] = new int[] {N,9,N,N,N,4,N};

		martex[4] = new int[] {N,N,8,N,N,5,4};
		martex[5] = new int[] {N,N,N,4,5,N,6};
		martex[6] = new int[] {2,3,N,N,4,6,N};

		Graph graph = new Graph(vertexs,martex);
		graph.showGraph();
		graph.dsj(6);
		graph.showDijkstra();
	}
	
	
	static class VisitedVertex{
		//��¼���������Ƿ񱻷��� 1��ʾ����0 ��ʾδ����
		public int[] already_array;
		//�����±��Ӧ��ֵΪǰһ��ԭ���±꣬�ᶯ̬����
		public int[] pre_visited;
		//��¼�������㵽�������ж���ľ���
		public int[] dis;
		
		public VisitedVertex(int length,int index) {
			this.already_array = new int[length];
			//index��ʾ���������Ӧ���±�
			this.pre_visited = new int[length];
			this.dis = new int[length];
			//��ʼ��dis
			Arrays.fill(dis, 65535);
			this.already_array[index] = 1; //���ó������㱻���ʹ�
			this.dis[index] = 0;
		}
		
		//�ж�Index�Ƿ񱻷��ʹŹ� ������ʹ�����true
		public boolean in(int index) {
			return already_array[index] == 1;
		}

		public void updateDis(int index,int len) {
			//���³�����㵽index���ľ���
			dis[index] = len;
		}
		

		
		//���½��Pre��ǰ�����Ϊindex
		public void updatePre(int pre,int index) {
			pre_visited[pre] = index;
		}
		
		public void show() {
			//�������
			System.out.println(Arrays.toString(already_array));
			System.out.println(Arrays.toString(pre_visited));
			System.out.println(Arrays.toString(dis));


		}
		
		//���س�����㵽index���ľ���
		public int getDis(int index) {
			return dis[index];
		}
		
		
		public int updateArr() {
			int min = 65535,index = 0;
			for(int i = 0; i < already_array.length; i++) {
				if(already_array[i] == 0 && dis[i] < min) {
					min = dis[i];
					index = i;
					
				}

			}
			already_array[index] = 1;

			return index;
		}
	}
	static class Graph{
		private char[] vertex;
		private int[][] matrix;
		private VisitedVertex vv;//�Ѿ����ʵĶ���ļ���
		//������

		public void dsj(int index) {
			
			//�ص�ע����һ�� ��д��VisitedVertex vv = new VisitedVertex(vertex.length,index);Ȼ�󱨴� ����Ϊ��ʱ��vv�����´�����ȻΪnull
 
			vv = new VisitedVertex(vertex.length,index);
			update(index);
			for(int i = 1; i < vertex.length; i++) {
				index = vv.updateArr();
				update(index);

			}

		}
		
		//����Index�±�
		private void update(int index) {
			int len = 0;
			//���ݱ����ڽӾ���� matrix[index]
			for(int i = 0; i < matrix[index].length;i++) {
				//������㵽index�ľ���+index�����i�ľ���
				len = vv.getDis(index) + matrix[i][index];
				//���i���û�з��ʹ�����LenҪС�ڳ����㵽I�ľ��룬�򽫾����滻Ϊvv,��index��ǰ��Ϊi
				if(!vv.in(i) && len < vv.getDis(i)) {
					vv.updatePre(i, index);
					vv.updateDis(i, len);
				}
			}
		}
		
		public Graph(char[] vertex, int[][] matrix) {
			super();
			this.vertex = vertex;
			this.matrix = matrix;
		}
		
		//��ʾͼ
		public void showGraph() {
			for(int[] link : matrix) {
				System.out.println(Arrays.toString(link));
			}
		}
		
		
		public void showDijkstra() {
			vv.show();
		}
		
		
	}

}
