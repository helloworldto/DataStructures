package Algorithm;

import java.util.Arrays;

public class Kruskal {

	private int edgeNum; //��¼�ߵĸ���
	private char[] vertexs;// ��������
	private int[][] matrix; //�ڽӾ���
	private static final int INF = Integer.MAX_VALUE; //��ʾ�������㲻����ͨ
	
	//������
	public Kruskal(char[] vertexs,int[][]matrix) {
		//��ʼ���������ͱߵĸ���
		int vlen = vertexs.length;
		//��ʼ������
		this.vertexs = new char[vlen];
		for(int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
			
			
		}
		
		//��ʼ��
		this.matrix = new int[vlen][vlen];
		for(int i = 0; i < vlen; i++) {
			for(int j = 0; j < vlen; j++)
				this.matrix[i][j] = matrix[i][j];
		}
		

		
		//ͳ�Ʊ�
	
		for(int i = 0; i < vlen; i++) {
			for(int j = i + 1; j < vlen; j++)
				if(matrix[i][j]!= INF)
				
					edgeNum++;
		}
		
	}
	
	//��ȡ�±�Ϊi�Ķ����Ӧ���յ�
	private int getEnd(int[]ends,int i) {
		while(ends[i] != 0) {
			i =  ends[i];
		}
		return i;
	}
	
	
	//Kruskal
	public  void Kruskals() {
		int index = 0;//��ʾ��������������
		int[] ends = new int[edgeNum];//�߶�Ӧ���յ�
		//����������飬����������С������
		Edata[] rets = new Edata[edgeNum];
		
		//��ʼһ����12����
		Edata[] edges = getEdges();
		//�Ա߽�������
		sortEdge(edges);
		//���߼��뵽�����в��ж��¼ӵı��Ƿ񹹳ɻ�·
		for(int i = 0; i < edgeNum; i++) {
			//��ȡ����i���ߵ����
			int p1= getPosition(edges[i].start);
			int p2= getPosition(edges[i].end);
			
			//��ȡp1�������������������е��յ�
			int m = getEnd(ends,p1);
			int n = getEnd(ends,p2);
			if(n != m) {
				ends[m] = n;  //m����С�������е��յ���n
				rets[index++] = edges[i];//�������߼��뵽res��
			}

			
		}
		//���res����
		for(int i = 0; i < index; i++) {
			System.out.println(rets[i]);

		}
	}
	
	public void print() {
		System.out.println("�ڽӾ���Ϊ:");
		for(int i = 0; i < vertexs.length; i++) {
			for(int j = 0; j < vertexs.length; j++)
				System.out.printf("%20d\t",matrix[i][j]);
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertexs = {'A','B','C','D','E','F','G'};
		int matrix[][] = {
				{0,12,INF,INF,INF,16,14},
				{12,0,10,INF,INF,7,INF},
				{INF,10,0,3,5,6,INF},
				{INF,INF,3,0,4,INF,INF},
				{INF,INF,5,4,0,2,8},
				{16,7,6,INF,2,0,9},
				{14,INF,INF,INF,8,9,0}
		};
		Kruskal kruskal = new Kruskal(vertexs,matrix);
		kruskal.print();
		System.out.println(Arrays.toString(kruskal.getEdges()));
		kruskal.Kruskals();
	}
	
	//�Ա߽���������  ð��
	private void sortEdge(Edata[] edges) {
		for(int i = 0; i < edges.length - 1; i++ ) {
			for(int j = 0; j < edges.length - 1;j ++) {
				if(edges[j].weight > edges[j+1].weight) {
					Edata temp = edges[j];
					edges[j] = edges[j+1];
					edges[j+1] = temp;
				}
			}
		}
	}
	
	private int getPosition(char ch) {
		for(int i = 0; i < vertexs.length;i++)
			if(vertexs[i] == ch)
				return i;
		return -1;
	}
	
	private Edata[] getEdges() {
		//��ȡ�߷���Edata��
		int index = 0;
		Edata[] data = new Edata[edgeNum];
		for(int i = 0; i < vertexs.length;i++) {
			for(int j = i+1;j < vertexs.length;j++)
				if(matrix[i][j]!= INF )
						data[index++] = new Edata(vertexs[i],vertexs[j],matrix[i][j]);
			}
			return data;
		}
	
	//����һ����Edata,��ʾһ����
	static class Edata{
		char start; //�ߵ����
		char end; //�ߵ��յ�
		int weight;//�ߵ�Ȩֵ
		
		public Edata(char start,char end,char weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		public Edata(char start, char end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public String toString() {
			return "Edata [start=" + start + ", end=" + end + ", weight=" + weight + "]";
		}
		
		
	} 

}
