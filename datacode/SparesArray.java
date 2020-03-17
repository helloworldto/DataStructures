package datacode;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
/*
 * ���顪��ϡ����������
 * 1.��ӡ��ά����
 * 2.����ת��ϡ�����飬ע��ϡ�������������num+1
 * 3.��ϡ�����鱣�浽������
 * 4.�Ӵ����ж�ȡ�ļ���ע���һ�ζ�ȡ��Ϊ��ϡ��������������رպ�����ٴζ�ȡ����Ϊʵ�������������δ֪�ģ�
 * 5.�ָ���ԭʼ���鲢��ӡ����
 */

public class SparesArray {
	
	public static void readArray (int [][] Arr) {
		for(int [] row : Arr) {
			for(int temp : row) {
				System.out.printf("%d\t",temp);
			}
			System.out.print("\n");
		}
	}
	
	//����ϡ�����鲢����ϡ������
	public static int[][] buildSparesArray(int [][]Arr) {
		System.out.print("����ϡ������:\n");
		int sum = 0;
		//��ȡϡ������������sum+1��
		for(int [] row : Arr) {
			for(int temp : row) {
				if(temp!=0) {
					sum++;
				}
			}
		}
		//����ϡ������
		//ϡ������
		int sparseArray[][] = new int[sum+1][3];

		sparseArray[0][1] = Arr[0].length;
		sparseArray[0][0]= Arr.length;
		sparseArray[0][2] = sum;	


		int count = 1;
		for(int i = 0; i < 	sparseArray[0][0]; i++) {
			for(int j = 0; j < 	sparseArray[0][1]; j++) {
				if(Arr[i][j]!= 0) {
					sparseArray[count][2] = Arr[i][j];
					sparseArray[count][0] = i;
					sparseArray[count][1] = j;
					count++;
				}
						
			}
			
		}
		return sparseArray;
	}
	//��ϡ�����鱣�浽�ļ���
	public static boolean SaveFile(int[][]Arr,File file) {
		try {
			FileWriter out = new FileWriter(file);
			for(int [] row : Arr) {
				for(int temp : row) {
					out.write(temp + "\t");
				}
				out.write("\r\n");
			}
			System.out.print("�ɹ����ļ����浽������\n");
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
	//�Ӵ����ж�������
	public static int[][] ReadFile(File file) throws IOException{
		InputStreamReader input=new InputStreamReader(new FileInputStream(file),"UTF-8");
		BufferedReader reader=new BufferedReader(input);

		String line;
		String line1;
		int row = 0;
		int num = 0;
		while((line = reader.readLine())!= null) {
			row++;
		}
		reader.close();
		//�Ľ����̶�ȡ��ע�⣬�����е��ļ���Ҫ�ȶ�ȡ�������ر��Ժ��ٴζ�ȡ�������ֵ��
		InputStreamReader in=new InputStreamReader(new FileInputStream(file),"UTF-8");
		BufferedReader dta=new BufferedReader(in);
		int [][]Arr2 = new int[row][3];
		while(( line1 = dta.readLine())!= null) {
			String[] temp = line1.split("\t");
			for(int i = 0; i < temp.length;i++) {
				Arr2[num][i] = Integer.valueOf(temp[i]);
			}
			num++;
		}
		dta.close();
		return Arr2;	
	}
	//�ָ�ԭʼ����
	public static void RestoreArray(int[][]Arr) {
		int a = Arr[0][0];
		int b = Arr[0][1];
		int c = Arr[0][2];
		int [][] Arr2 = new int[a][b];
		for(int i = 1;i < c+1;i++) {
			Arr2[Arr[i][0]][Arr[i][1]] = Arr[i][2];
		}
		System.out.print("�ָ����ݳɹ�\n");
		readArray(Arr2);
		

	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		int charArr[][]= new int[11][11];

		charArr[1][2] = 1;
		charArr[2][3] = 2;
		System.out.print("ԭʼ������:\n");
		readArray(charArr);
		int [][] dataArray = buildSparesArray(charArr);
		readArray(dataArray);
		//��ϡ�����鱣���ڴ�����
		File file = new File("d:\\array.txt"); 
		boolean flag = SaveFile(dataArray,file);
		if(flag) {
	
			dataArray = ReadFile(file);
			readArray(dataArray);
			RestoreArray(dataArray);
    	}
	
	}
}
