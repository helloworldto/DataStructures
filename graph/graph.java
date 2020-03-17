package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class graph {
	private ArrayList<String> vertexList; //�洢��㼯��
	private int[][] edges; //�洢ͼ��Ӧ���ڽӾ���
	private int numOfEdges;//��ʾ�����Ŀ
	//��������boolean[]����¼ĳ������Ƿ񱻷���
	private boolean[] isVisited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 8;
		String Vertexs[] = {"1","2","3","4","5","6","7","8"};
		//����ͼ����
		graph Graph = new graph(n);
		//ѭ������ӽ��
		for(String vertex : Vertexs) {
			Graph.insertVertex(vertex);
		}
		
		
		//��ӱ�
		// A-B A-C B-C B-D B-E
		Graph.insetEdge(0, 1, 1);
		Graph.insetEdge(0, 2, 1);

		

		Graph.insetEdge(1, 3, 1);
		Graph.insetEdge(1, 4, 1);
		
		Graph.insetEdge(3, 7, 1);
		Graph.insetEdge(4, 7, 1);
		Graph.insetEdge(2, 5, 1);
		Graph.insetEdge(2, 6, 1);
		Graph.insetEdge(5, 6, 1);
		
		Graph.showGraph();
		
		
		//��ȱ���
		System.out.println("��ȱ���");
		Graph.DFS();
		System.out.println("��ȱ���");

		
		Graph.BFS();
	}

	public graph(int n) {
		//��ʼ�������vertexList
		edges = new int[n][n];
		vertexList = new ArrayList<String>(n);
		numOfEdges = 0;
		 isVisited = new  boolean[n];
	}
	//����ǰһ���ڽӽ����±��ȡ��һ��
	public int getNexthbor(int v1,int v2) {
		for(int j = v2 +1; j < vertexList.size(); j++) {
			if(edges[v1][j] > 0)
				return j;
	
		}
		return -1;
	}
	
	///�õ���һ���ڽӽ����±�
	//������� ���ض�Ӧ�±�
	public int getFirstNeighbor(int index) {
		for(int j = 0; j < vertexList.size(); j++)
			if(edges[index][j] > 0)
				return j;
		return -1;
	}
	//�������н�����BFS
	private void BFS() {
		for(int i = 0; i < getNumOfVertex(); i++) {
			BFS(isVisited,i);
		}
	}
	
	//��һ�������й�����ȱ���
	private void BFS(boolean[] isVistied, int i) {
		int u; // ��ʾ���е�ͷ����Ӧ�±�
		int w; //�ڽӽ��
		
		//���У���¼�����ʵ�˳��
		LinkedList queue = new LinkedList();
		
		//���ʽ�㣬��������Ϣ
		System.out.println(getValueByIndex(i)+"=>");
		isVistied[i] = true;
		//�����������
		queue.add(i);
		
		while(!queue.isEmpty()) {
			//ȡ�����е�ͷ���
			u = (Integer)queue.removeFirst();
			w = getFirstNeighbor(u);
			while(w != -1) {
				//�Ƿ����
				if(!isVisited[w]) {
					//System.out.println(getValueByIndex(w)+"=>");
					isVisited[w] = true;;
					queue.addLast(w);

				}
					//��uΪ���ģ�����һ���ھ�
					w = getNexthbor(u,w);
				
				
			}
		}
	}
	
	
	//DFS
	public void DFS(boolean[] isVisited,int i) {
		//���ȷ��ʸý��
		System.out.println(getValueByIndex(i) + "->");
		isVisited[i] = true;
		
		//������������ڽӽ��
		int w = getFirstNeighbor(i);
		while(w != -1) {
			if(!isVisited[w]) {
				DFS(isVisited,w);
			}
			//����Ѿ������ʹ�
			else {
				w = getNexthbor(i,w);
			}
		}
	}
	
	
	//��DFS�������� �������еĽ�㲢����DFS
	public void DFS() {
		//�������еĽ�����DFS
		for(int i = 0; i < getNumOfVertex(); i++) {
			if(!isVisited[i]) {
				DFS(isVisited,i);
			}
		}
	}
	
	
	public int getNumOfVertex() {
		return vertexList.size();
	}
	
	//���ؽ��i(�±��Ӧ������)
	public String getValueByIndex(int i) {
		return vertexList.get(i);
	}
	
	//����v1��v2��ֵ
	public int getWeight(int v1, int v2) {
		return edges[v1][v2];
	}

	public int getNumOfEdges() {
		return numOfEdges;
	}

	public void insetEdge(int v1, int v2, int weight) {
		edges[v1][v2] = weight;
		edges[v2][v1] = weight;
		numOfEdges++;

	}

	//  ������
	public void insertVertex(String vertex) {
		vertexList.add(vertex);
	}
	
	//��ʾͼ��Ӧ�ľ���
	public void showGraph() {
		for(int[] link : edges) {
			System.out.println(Arrays.toString(link));
		}
	}
	


}
