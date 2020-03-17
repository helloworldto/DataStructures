package huffmantree;
/*
 * WPL
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HuffmanTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {13,7,8,3,29,6,1};
		Node res = createHuffmanTree(array);
		preOrder(res);
	}
	
	public static void preOrder(Node node) {
		if(node != null) {
			System.out.println(node);
			if(node.left != null)
				preOrder(node.left);
			if(node.right != null)
				preOrder(node.right);
		}
	}
	
	public static Node createHuffmanTree(int[] array) {
		//1.��������
		//2������С������Ԫ�ع���һ���µ�node
		List<Node> nodes = new ArrayList<Node>();
		for(int value:array) {
			nodes.add(new Node(value));
			
		}
		//��֪ʶ��һ�仰Collections.sort()
		
		while(nodes.size() != 1) {
			Collections.sort(nodes);
			System.out.println("node =" + nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(leftNode.value + rightNode.value);
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		//��Ҫ�����һ�䷵�غշ�������ͷ
		return nodes.get(0);

	}
	
	static class Node implements Comparable<Node>{
		int value;
		Node left;
		Node right;
		public Node(int value) {
			super();
			this.value = value;
		}
		@Override
		public String toString() {
			return "Node [value=" + value + "]";
		}
		@Override
		public int compareTo(Node arg0) {
			// TODO Auto-generated method stub
			//���մ�С�����˳��
			return this.value - arg0.value;
		}
		
		
	}

}
