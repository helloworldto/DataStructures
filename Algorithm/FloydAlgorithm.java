package Algorithm;

import java.util.Arrays;

public class FloydAlgorithm {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vertex = {'A','B','C','D','E','F','G'};
		int[][] materix = new int[vertex.length][vertex.length];
		final int N = 65535;

		materix[0] = new int[] {0,5,7,N,N,N,2};
		materix[1] = new int[] {5,0,N,9,N,N,3};

		materix[2] = new int[] {7,N,0,N,8,N,N};

		materix[3] = new int[] {N,9,N,0,N,4,N};

		materix[4] = new int[] {N,N,8,N,0,5,4};
		materix[5] = new int[] {N,N,N,4,5,0,6};
		materix[6] = new int[] {2,3,N,N,4,6,0};
		
		Graph graph = new Graph(vertex,materix,vertex.length);
		graph.show();
		graph.Floyd();
		graph.show();

	}
	

	
	static class Graph{
		private char[] vertex;
		private int[][] dis;
		private int[][] pre;

		public Graph(char[] vertex, int[][] matrix, int length) {
			super();
			this.vertex = vertex;
			this.dis = matrix;
			this.pre = new int[length][length];
			for(int i = 0; i < length;i++)
				Arrays.fill(pre[i], i);
		}
		
		
		public void show() {
			for(int k = 0; k < dis.length; k++) {
				for(int i = 0; i < dis.length; i++) {
					System.out.printf(pre[k][i] + " ");
				}
				System.out.println();
				for(int i = 0; i < dis.length; i++) {
					System.out.printf("++"+ vertex[k]+"µ½"+ vertex[i]+" "+dis[k][i] + " ");
				}
				System.out.println();
				
			}
		}
		
		//¸¥ÂåÒÁµÂËã·¨
		public void Floyd() {
			int len = 0;
			for(int k = 0; k < dis.length; k++) {
				for(int i = 0; i < dis.length; i++) {
					for(int j = 0; j < dis.length; j++) {
						len = dis[i][k] + dis[k][j];
						if(len < dis[i][j]) {
							dis[i][j] = len;
							pre[i][j] = pre[k][j];
						}
					}
				}
			}
			
			
		}
		
		
		
	}

}
