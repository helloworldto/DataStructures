package Algorithm;

import java.util.Arrays;

public class Kruskal {

	private int edgeNum; //记录边的个数
	private char[] vertexs;// 顶点数组
	private int[][] matrix; //邻接矩阵
	private static final int INF = Integer.MAX_VALUE; //表示两个顶点不能联通
	
	//构造器
	public Kruskal(char[] vertexs,int[][]matrix) {
		//初始化顶点数和边的个数
		int vlen = vertexs.length;
		//初始化顶点
		this.vertexs = new char[vlen];
		for(int i = 0; i < vertexs.length; i++) {
			this.vertexs[i] = vertexs[i];
			
			
		}
		
		//初始化
		this.matrix = new int[vlen][vlen];
		for(int i = 0; i < vlen; i++) {
			for(int j = 0; j < vlen; j++)
				this.matrix[i][j] = matrix[i][j];
		}
		

		
		//统计边
	
		for(int i = 0; i < vlen; i++) {
			for(int j = i + 1; j < vlen; j++)
				if(matrix[i][j]!= INF)
				
					edgeNum++;
		}
		
	}
	
	//获取下标为i的顶点对应的终点
	private int getEnd(int[]ends,int i) {
		while(ends[i] != 0) {
			i =  ends[i];
		}
		return i;
	}
	
	
	//Kruskal
	public  void Kruskals() {
		int index = 0;//表示最后结果数组的索引
		int[] ends = new int[edgeNum];//边对应的终点
		//创建结果数组，保存最后的最小生成树
		Edata[] rets = new Edata[edgeNum];
		
		//初始一共有12条边
		Edata[] edges = getEdges();
		//对边进行排序
		sortEdge(edges);
		//将边加入到数组中并判断新加的边是否构成回路
		for(int i = 0; i < edgeNum; i++) {
			//获取到第i条边的起点
			int p1= getPosition(edges[i].start);
			int p2= getPosition(edges[i].end);
			
			//获取p1这个结点在已有生成树中的终点
			int m = getEnd(ends,p1);
			int n = getEnd(ends,p2);
			if(n != m) {
				ends[m] = n;  //m在最小生成树中的终点是n
				rets[index++] = edges[i];//把这条边加入到res中
			}

			
		}
		//输出res数组
		for(int i = 0; i < index; i++) {
			System.out.println(rets[i]);

		}
	}
	
	public void print() {
		System.out.println("邻接矩阵为:");
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
	
	//对边进行排序处理  冒泡
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
		//获取边放入Edata中
		int index = 0;
		Edata[] data = new Edata[edgeNum];
		for(int i = 0; i < vertexs.length;i++) {
			for(int j = i+1;j < vertexs.length;j++)
				if(matrix[i][j]!= INF )
						data[index++] = new Edata(vertexs[i],vertexs[j],matrix[i][j]);
			}
			return data;
		}
	
	//创建一个类Edata,表示一条边
	static class Edata{
		char start; //边的起点
		char end; //边的终点
		int weight;//边的权值
		
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
