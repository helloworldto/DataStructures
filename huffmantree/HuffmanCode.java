package huffmantree;
/*
 * ���Ƚ��ַ���ת���ֽ�����
 * Ȼ���ֽ�����ת��Node���㣬node��data���� ASCII  weight��ʾ���ֵĴ���
 * �����շ�����
 * ͬ��ƪ��������ͬ�����½���dataΪnull ע���¼ӽ��������ӽ��ֱ���ԭ����
 * �շ�������  ����Ƿ�Ҷ�ӽ�� ����������������������ƴ���ַ����룬�����Ҷ�ӽ�㣬������뵽�շ���������
 * ����һ����˼������java
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String content = "i like like like java do you like a java";
		byte[] contentBytes = content.getBytes();
		System.out.println(contentBytes.length);  //40
//		List<Node> nodes = getNodes(contentBytes);
//		System.out.println("nodes=" + nodes);
//		//�շ�����
//		System.out.println("�շ�����");
//		
//		Node root = createHuffmanTree(nodes);
//		preOrder(root);
//		//root.preOrder();
//		
//		getCodes(root,"",stringBuilder);
//		System.out.println("���ɵĺշ��������"+ huffmanCodes);
//		//System.out.println("nodes=" + nodes.toString());
//		
//		byte[] huffmanCodeBytes = zip(contentBytes,huffmanCodes);
//		System.out.println("huffmanCodes=" + Arrays.toString(huffmanCodeBytes));
		
		
		byte[] huffmanCodeBytes = huffmanZip(contentBytes);
		System.out.println("huffmanCodes=" + Arrays.toString(huffmanCodeBytes));
		
		byte[] sourseBytes = decode(huffmanCodes,huffmanCodeBytes);
		System.out.println("ԭ�����ַ����ǣ�" + new String(sourseBytes));
		//666,�����Arrays.toString(sourseBytes)��������������ASCII��   ����Ҫʹ��new String(sourseBytes)�������
		
		String srcFile = "d://DisGan.docx";
		String dstFile = "d://2.zip";
		zipFile(srcFile,dstFile);
		System.out.println("ѹ���ļ�OK");
		String zipFile = "d://2.zip";
		String data = "d://src.docx";
		unZipFile(zipFile,data);
		System.out.println("��ѹ�ɹ�");

	}
	
	
	//�ļ����н�ѹ
	public static void unZipFile(String zipFile,String dstFile) {
		//�����ļ�������
		InputStream is= null;;
		//�������������
		ObjectInputStream ois = null;
		//�����ļ��������
		OutputStream os = null;
		try {
			//�����ļ�������
			is = new FileInputStream(zipFile);
			//����һ����is������Ķ���������
			ois = new ObjectInputStream(is);
			//��ȡbyte����huffmanBytes
			byte[] huffmanBytes = (byte[]) ois.readObject();
			//��ȡ�շ��������
			Map<Byte,String> huffmanCodes = (Map<Byte,String>)ois.readObject();
			//����
			byte[] bytes = decode(huffmanCodes,huffmanBytes);
			//��bytes����д�뵽ļ���ļ�
			os = new FileOutputStream(dstFile);
			os.write(bytes);
		}catch(Exception e) {
			System.out.println(e);
		}finally {
			try {
				ois.close();
				is.close();
				os.close();

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	public static void zipFile(String srcFile,String dstFile) {
		//���������
		FileInputStream is = null;
		FileOutputStream os = null;
		ObjectOutputStream oos = null;
		try {
			//�����ļ���������
			 is = new FileInputStream(srcFile);
			//����һ����Դ�ļ���Сһ����byte[]
			byte[] b = new byte[is.available()];
			is.read(b);
			byte[] huffmanBytes = huffmanZip(b);
			//�����ļ�������������ѹ���ļ�
			os = new FileOutputStream(dstFile);
			//����һ�����ļ������������ObjectOutputStream
			oos = new ObjectOutputStream(os);
			oos.write(huffmanBytes);//�Ѻɷ����������ֽ�����д��ѹ���ļ�
			//�����Զ������ķ�ʽд��շ������룬��Ϊ�������Ժ�ָ��ļ�ʱʹ��
			//ע��һ��Ҫ�Ѻɷ�������д��ѹ���ļ�
			oos.writeObject(huffmanCodes);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}finally {
			 try {
				 is.close();
				 os.close();

				oos.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/*
	 * ��һ��byteת��һ�������Ƶ��ַ���
	 */
	
	private static String byteToBitString(boolean flag, byte b) {
		//ʹ�ñ�������b
		int temp = b; //��bת��int
		if(flag) {
			temp |= 256;  //����û�и�������һ�㣬��ȥ��ϰ����
		}
		String str = Integer.toBinaryString(temp);
		if(flag) {
			return str.substring(str.length() - 8);
		}else {
			return str;
		}
	}
	
	private static byte[] decode(Map<Byte,String> huffmanCodes,byte[] huffmanBytes) {
		//1.�ȵõ�huffmanBytes ��Ӧ�Ķ����Ƶ��ַ���
		StringBuilder stringBuilder = new StringBuilder();
		//��byte����ת�ɶ����Ƶ��ַ���
		for(int i = 0; i < huffmanBytes.length; i++) {
			byte b = huffmanBytes[i];
			//�ж����һ���ֽ�
			boolean flag = (i == huffmanBytes.length -1);
			stringBuilder.append(byteToBitString(!flag,b));
		}
		
		//���ַ�������ָ���ĺշ���������б���
		Map<String, Byte> map = new HashMap<String,Byte>();
		for(Map.Entry<Byte, String>enrty: huffmanCodes.entrySet()) {
			map.put(enrty.getValue(), enrty.getKey());
		}
		System.out.println("map=" + map);
		
		List<Byte> list = new ArrayList<>();
		//i ����������������ɨ��stringBuilder
		for(int i = 0; i < stringBuilder.length(); ) {
			int count = 1; //������
			boolean flag = true;
			Byte b = null;
			
			while(flag) {
				String key = stringBuilder.substring(i,i+count);
				b = map.get(key);
				if(b == null) {
					//˵��û��ƥ�䵽
					count++;
				}else {
					flag = false;
				}
			
			}
			list.add(b);
			i += count; //��i�ƶ����µ�λ��
		}
		
		byte b[] = new byte[list.size()];
		for(int i = 0; i < b.length; i++) {
			b[i] = list.get(i);
		}
		return b;
	}
	
	private static byte[] huffmanZip(byte[] bytes) {
		List<Node> nodes = getNodes(bytes);
		
		Node huffmanTreeRoot = createHuffmanTree(nodes);

		getCodes(huffmanTreeRoot,"",stringBuilder);
		byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
		return huffmanCodeBytes;

	}
	
	//��дһ�����������ַ�����Ӧ��byte[]���飬ͨ�����ɵĺɷ������������һ���շ�������ѹ�����byte[]
	private static byte[] zip(byte[]bytes,Map<Byte,String>huffmanCode) {
		//����huffmanCode��bytesת�ɺɷ��������Ӧ���ַ���
		StringBuilder stringBuilder = new StringBuilder();
		for(byte b: bytes) {
			stringBuilder.append(huffmanCodes.get(b));
		}
		int length;
		if(stringBuilder.length() % 8 == 0) {
			length = stringBuilder.length() / 8;
		}else {
			length = stringBuilder.length() / 8 + 1;
		}
		
		//����  �洢ѹ�����byte����
		byte[] huffmanCodeBytes = new byte[length];
		int index = 0;
		for(int i = 0; i < stringBuilder.length(); i += 8 ) {
			String strByte;
			if(i + 8 > stringBuilder.length()) {
				strByte = stringBuilder.substring(i);
			}else {
				strByte = stringBuilder.substring(i,i+8);
			}
			huffmanCodeBytes[index++] = (byte)Integer.parseInt(strByte,2);
		}
		return huffmanCodeBytes;
	}
	
	static Map<Byte,String> huffmanCodes = new HashMap<Byte,String>();
	static StringBuilder stringBuilder = new StringBuilder();
	
	/*
	 * �������node��������Ҷ�ӽ��ĺշ�������õ���������huffmanCode����
	 * node  ������
	 * code  ·�� ��0��1
	 */
	private static void getCodes(Node node, String code,StringBuilder stringBuilder) {
		StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
		stringBuilder2.append(code);
		if(node != null) {
			//���node == null ������
			//�жϵ�ǰNodeΪҶ�ӽ�㻹�Ƿ�Ҷ�ӽ��
			if(node.data == null) {
				//��Ҷ�ӽ��
				//�ݹ鴦��
				getCodes(node.left,"0",stringBuilder2);
				getCodes(node.right,"1",stringBuilder2);

			}else {
				//����Ҷ�ӽ��
				huffmanCodes.put(node.data, stringBuilder2.toString());
			}
		}
	}
	
	//ǰ�����
	private static void preOrder(Node node) {
		if(node != null) {
			node.preOrder();
			
		}else {
			System.out.println("�շ�����Ϊ��");
		}
		
	}
	
	
	
	//ͨ��list�����շ�����
	private static Node createHuffmanTree(List<Node> nodes) {
		while(nodes.size() > 1) {
			Collections.sort(nodes);
			Node leftNode = nodes.get(0);
			Node rightNode = nodes.get(1);
			Node parent = new Node(null,leftNode.weight + rightNode.weight);
			//��д���������䣬����
			parent.left = leftNode;
			parent.right = rightNode;
			nodes.remove(leftNode);
			nodes.remove(rightNode);
			nodes.add(parent);
		}
		return nodes.get(0);
	}
	
	//�����ֽ����飬����Node List
	private static List<Node> getNodes(byte[] bytes){
		Map<Byte,Integer> counts = new HashMap<>();
		ArrayList<Node> nodes = new ArrayList<Node>();
		for(byte b:bytes) {
			Integer count = counts.get(b);
			if(count == null) {
				counts.put(b,1);
			}else {
				counts.put(b,count + 1);
			}
			
			
		}
		
		//��ÿһ����ֵ��ת��һ��Node���󣬲����뵽Node����
		//����map
		for(Map.Entry<Byte, Integer>entry:counts.entrySet()) {
			nodes.add(new Node(entry.getKey(),entry.getValue()));
		}
		return nodes;
	}

	//����Node,���ݺ�Ȩֵ
	static class Node implements Comparable<Node>{
		Byte data;
		int weight;
		Node left;
		Node right;
		
		
		public Node(Byte data, int weight) {
			super();
			this.data = data;
			this.weight = weight;
		}


		@Override
		public int compareTo(Node o) {
			// TODO Auto-generated method stub
			return this.weight - o.weight;
		}


		//��Ϊһ��ʼ��д��toString������������ǵ�ַ  �м�
		@Override
		public String toString() {
			return "Node [data=" + data + ", weight=" + weight + "]";
		}
		
		public void preOrder() {
				System.out.println(this);
				if(this.left != null)
					this.left.preOrder();;
				if(this.right != null)
					this.right.preOrder();
		}


	
		
		
		
	}

}
