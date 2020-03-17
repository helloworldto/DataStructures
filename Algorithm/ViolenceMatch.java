package Algorithm;

public class ViolenceMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 ="我爱学习 学习爱我吗";
		String str2 ="学习爱我";
		int index = violenceMatch(str1,str2);
		System.out.println("index:" + index);
	}
	
	//暴力匹配算法实现
	public static int violenceMatch(String str1,String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int s1len = s1.length;
		int s2len = s2.length;
		
		int i = 0; //i索引指向s1
		int j = 0; //j索引指向s2
		
		while(i < s1len && j < s2len) {
			if(s1[i] == s2[j]) {
				//匹配成功
				i++;
				j++;
			}else {
				//没有匹配成功
				i -= j-1;
				j = 0;
			}
		}
		
		if( j == s2len)
			return i-j;
		else
			return -1;
		
	}

}
