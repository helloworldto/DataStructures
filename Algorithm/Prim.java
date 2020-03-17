package Algorithm;

public class Prim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//����ͼ�Ƿ񴴽�ok
		char[] data = new char[] {'A','B','C','D','E','F','G'};
		int verxs =data.length;
		int[][] weight = new int[][] {
			{10000,5,7,10000,10000,10000,2},
			{5,10000,10000,9,10000,10000,3},
			{7,10000,10000,10000,8,10000,10000},
			{10000,9,10000,10000,10000,4,10000},
			{10000,10000,8,10000,10000,5,4},
			{10000,10000,10000,4,5,10000,6},
			{2,3,10000,10000,4,6,10000}};
			
			//����MGraph����
			MGraph graph = new MGraph(verxs);
			//����һ��MinTree����
			MinTree minTree = new MinTree();
			
			minTree.createGraph(graph, verxs, data, weight);
			minTree.showGraph(graph);
			
			minTree.prim(graph, 0);
			
			
	}
	
	
	static class MinTree{
		public void createGraph(MGraph graph,int verxs,char data[],int[][] weight) {
			int i, j;
			for(i = 0; i < verxs; i++) {
				graph.data[i] = data[i];
				for(j = 0; j < verxs; j++) {
					graph.weight[i][j] = weight[i][j];
				}
			}
		}
		
		//��С������
		public void prim(MGraph graph, int v) {
			//visited[] ��ǽ�㣨ԭ�㣩�Ƿ񱻷��ʹ�
			int visited[] = new int[graph.verxs];
			visited[v] = 1;
			int h1 = -1;
			int h2 = -1;
			int minWeight = 10000;
			
			for(int k = 1; k < graph.verxs; k++) {
				for(int i = 0; i < graph.verxs; i++) {
					for(int j = 0; j < graph.verxs; j++) {
						if(visited[i] == 1 && visited[j] == 0 && graph.weight[i][j] < minWeight) {
							minWeight = graph.weight[i][j];
							h1 = i;
							h2 = j;
						}
					}
				}
				//�ҵ�һ��������С
				System.out.println("��<" + graph.data[h1] + graph.data[h2] + "Ȩֵ:" + minWeight);
				visited[h2] = 1;
				minWeight = 10000;
			}
		}
		
		//��ʾͼ�ķ���
		public void showGraph(MGraph graph) {
			for(int i = 0; i < graph.verxs; i++) {

				for(int j = 0; j < graph.verxs; j++)
				{
					System.out.printf(graph.weight[i][j] + " ");
					
				}
			System.out.println();
			}
			
		}
	}
	
	static class MGraph{
		int verxs;//��ʾͼ�Ľ�����
		char[] data;//��Ž������
		int[][] weight;//��űߣ��������ǵ��ڽӾ���
		
		public MGraph(int verxs) {
			this.verxs = verxs;
			this.data = new char[verxs];
			weight = new int[verxs][verxs];
		}
	}

}
