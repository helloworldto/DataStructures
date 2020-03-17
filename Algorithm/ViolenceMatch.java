package Algorithm;

public class ViolenceMatch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 ="�Ұ�ѧϰ ѧϰ������";
		String str2 ="ѧϰ����";
		int index = violenceMatch(str1,str2);
		System.out.println("index:" + index);
	}
	
	//����ƥ���㷨ʵ��
	public static int violenceMatch(String str1,String str2) {
		char[] s1 = str1.toCharArray();
		char[] s2 = str2.toCharArray();
		
		int s1len = s1.length;
		int s2len = s2.length;
		
		int i = 0; //i����ָ��s1
		int j = 0; //j����ָ��s2
		
		while(i < s1len && j < s2len) {
			if(s1[i] == s2[j]) {
				//ƥ��ɹ�
				i++;
				j++;
			}else {
				//û��ƥ��ɹ�
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
