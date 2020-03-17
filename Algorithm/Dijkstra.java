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
		//记录各个顶点是否被访问 1表示访问0 表示未访问
		public int[] already_array;
		//给个下标对应的值为前一个原点下标，会动态更新
		public int[] pre_visited;
		//记录出发顶点到其它所有顶点的距离
		public int[] dis;
		
		public VisitedVertex(int length,int index) {
			this.already_array = new int[length];
			//index表示出发顶点对应的下标
			this.pre_visited = new int[length];
			this.dis = new int[length];
			//初始化dis
			Arrays.fill(dis, 65535);
			this.already_array[index] = 1; //设置出发顶点被访问过
			this.dis[index] = 0;
		}
		
		//判断Index是否被访问古过 如果访问过返回true
		public boolean in(int index) {
			return already_array[index] == 1;
		}

		public void updateDis(int index,int len) {
			//更新出发结点到index结点的距离
			dis[index] = len;
		}
		

		
		//更新结点Pre的前驱结点为index
		public void updatePre(int pre,int index) {
			pre_visited[pre] = index;
		}
		
		public void show() {
			//输出数组
			System.out.println(Arrays.toString(already_array));
			System.out.println(Arrays.toString(pre_visited));
			System.out.println(Arrays.toString(dis));


		}
		
		//返回出发结点到index结点的距离
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
		private VisitedVertex vv;//已经访问的顶点的集合
		//构造器

		public void dsj(int index) {
			
			//重点注意这一句 我写的VisitedVertex vv = new VisitedVertex(vertex.length,index);然后报错 是因为此时的vv被重新创建必然为null
 
			vv = new VisitedVertex(vertex.length,index);
			update(index);
			for(int i = 1; i < vertex.length; i++) {
				index = vv.updateArr();
				update(index);

			}

		}
		
		//更新Index下标
		private void update(int index) {
			int len = 0;
			//根据遍历邻接矩阵的 matrix[index]
			for(int i = 0; i < matrix[index].length;i++) {
				//出发结点到index的距离+index到结点i的距离
				len = vv.getDis(index) + matrix[i][index];
				//如果i结点没有访问过并且Len要小于出发点到I的距离，则将距离替换为vv,将index的前驱为i
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
		
		//显示图
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
