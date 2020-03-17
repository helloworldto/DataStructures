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
 * 数组——稀疏数组问题
 * 1.打印二维数组
 * 2.将其转成稀疏数组，注意稀疏数组的行数是num+1
 * 3.将稀疏数组保存到磁盘中
 * 4.从磁盘中读取文件，注意第一次读取是为了稀疏数组的行数，关闭后才能再次读取（因为实际情况中行数是未知的）
 * 5.恢复成原始数组并打印出来
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
	
	//构建稀疏数组并返回稀疏数组
	public static int[][] buildSparesArray(int [][]Arr) {
		System.out.print("构建稀疏数组:\n");
		int sum = 0;
		//读取稀疏数组行数（sum+1）
		for(int [] row : Arr) {
			for(int temp : row) {
				if(temp!=0) {
					sum++;
				}
			}
		}
		//构建稀疏数组
		//稀疏数组
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
	//将稀疏数组保存到文件中
	public static boolean SaveFile(int[][]Arr,File file) {
		try {
			FileWriter out = new FileWriter(file);
			for(int [] row : Arr) {
				for(int temp : row) {
					out.write(temp + "\t");
				}
				out.write("\r\n");
			}
			System.out.print("成功将文件保存到磁盘中\n");
			out.close();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
	}
	//从磁盘中读出数组
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
		//改进磁盘读取，注意，磁盘中的文件需要先读取行数，关闭以后再次读取具体的数值。
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
	//恢复原始数组
	public static void RestoreArray(int[][]Arr) {
		int a = Arr[0][0];
		int b = Arr[0][1];
		int c = Arr[0][2];
		int [][] Arr2 = new int[a][b];
		for(int i = 1;i < c+1;i++) {
			Arr2[Arr[i][0]][Arr[i][1]] = Arr[i][2];
		}
		System.out.print("恢复数据成功\n");
		readArray(Arr2);
		

	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		
		
		int charArr[][]= new int[11][11];

		charArr[1][2] = 1;
		charArr[2][3] = 2;
		System.out.print("原始的数组:\n");
		readArray(charArr);
		int [][] dataArray = buildSparesArray(charArr);
		readArray(dataArray);
		//将稀疏数组保存在磁盘中
		File file = new File("d:\\array.txt"); 
		boolean flag = SaveFile(dataArray,file);
		if(flag) {
	
			dataArray = ReadFile(file);
			readArray(dataArray);
			RestoreArray(dataArray);
    	}
	
	}
}
