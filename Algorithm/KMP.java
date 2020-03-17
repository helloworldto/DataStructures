package Algorithm;

import java.util.Arrays;

public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = "BBC ABCDAB ABCDABCDABDE";
		String str2 = "ABCDABD";
		int[] next = kmpNext("ABCDABD");
		System.out.println("next=" + Arrays.toString(next));
		int index = kmpSearch(str1,str2,next);
		System.out.println("index=" + index);

	}
	
	//遍历
	public static int kmpSearch(String str1,String str2,int[] next) {
		//遍历
		for(int i = 0, j = 0; i < str1.length(); i++) {
			while( j > 0 && str1.charAt(i)!= str2.charAt(j)) {
				j = next[j-1];
			}
			if(str1.charAt(i)== str2.charAt(j))
				j++;
			if(j == str2.length()) {
				return i - j + 1;
				
			}
		}
		return -1;
	}
	
	
	//获取一个字符串的部分匹配表
	public static int[] kmpNext(String dest) {
		//创建一个next数组保存有部分匹配表
		int[] next = new int[dest.length()];
		next[0] = 0;//如果字符串长度为1，部分匹配表就是0
		for(int i = 1,j = 0; i < dest.length(); i++) {
			//当dest.charAt(i) == dest.charAt(j)
			while(j > 0 && dest.charAt(i)!= dest.charAt(j)) {
				j = next[j-1];
			}
			if(dest.charAt(i)== dest.charAt(j)) {
				j++;
			}
			next[i] = j;
		}
		return next;
	}

}
