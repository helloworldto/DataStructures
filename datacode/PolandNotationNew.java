package datacode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * ��׺���ʽת��׺���ʽ���沨�����ʽ��
 * ˼·����
 * ��1����ʼ������ջ�������ջs1�ʹ洢�м�����ջs2��
 * ��2��������ɨ����׺���ʽ
 * ��3������������ʱ������ѹs2
 * ��4�����������ʱ���Ƚ�����s1ջ������������ȼ�
 * 1.���s1Ϊ�ջ� ��ֱ��ѹ��
 * 2.������ȼ���ջ���ĸߣ�ѹ��
 * 3.����s1ջ���������������ѹ��s2�У��ٴ��굽4.1��s1���µ�ջ���Ƚ�
 * (5)��������ʱ��
 * 1.������(��ֱ��ѹ��s1
 * 2.�з���)�򵯳�s1ջ�����������ѹ��s2,ֱ�����������ţ���ʱ����һ�����Ŷ���
 * ��6���ظ����裨2������5����֪�����ʽ�����ұ�
 * ��7����s1��ʣ�����������ε�����ѹ��s2
 * ��8��һ�ε���s2�е�Ԫ�ز���������������Ϊ��׺���ʽ��Ӧ�ĺ�׺���ʽ
 * 
 */

public class PolandNotationNew {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "1+(2+3)*4-5";
		// [1, +, (, 2, +, 3, ), *, 4, -, 5]
		List<String> infixExpression = toInfixExpressionList(expression);
		System.out.println(infixExpression);
		List<String> list = parseSuffExpressionList(infixExpression);
		System.out.print(list);
		int result = cal(list);
		System.out.printf("���յĽ��Ϊ��%d",result);
		

	}
	public static List<String> toInfixExpressionList(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;//����һ��ָ�룬���ڱ�����׺���ʽ�ַ���
		String str;//�Զ�λ������ƴ��
		char c;//ÿ������һ���ַ��ͷ��뵽c
		do {
			if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57 ) {
				ls.add("" + c);
				i++; //i��Ҫ����
			}else {
				//���ʱһ���������Ƕ�λ��
				str = "";
				while(i < s.length() && (c = s.charAt(i)) >= 48 && (c=s.charAt(i))<=57) {
					 str += c; //ƴ��
					 i++;
				}
				ls.add(str);
			}
		}while(i < s.length());
		return ls;
	}
	
	public static List parseSuffExpressionList(List<String> list) {
		//��������ջ
		Stack<String> s1 = new Stack();
		//��ΪS2��pop����������list<String>����
		List<String> s2 = new ArrayList<String>();
		//����list
		for(String item:list) {
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.add(item);
			}else if(item.equals(")")){
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//��С���ŵ���
			}else {
				//���ȼ�������
				//��s1��ջ�������ȼ���item���򵯳�s1�����Ƚ�ֱ����ջ
				while(s1.size()!= 0 && Operation.getVlue(s1.peek())>=  Operation.getVlue(item)) {
					s2.add(s1.pop());
					
				}
				s1.push(item);
			}
			
		}
		
		
		while(s1.size()!= 0) {
			//��ʱ����Ҫ���������Ϊ��list
			s2.add(s1.pop());
		}
		return s2;
	}
	
	//��д���ȼ�����
	public static class Operation{
		private static int ADD = 1;
		private static int SUB = 1;
		private static int PUL = 2;
		private static int DIV = 2;
		
		//д�����������ȼ�
		public static int getVlue(String operation) {
			int result = 0;
			switch(operation) {
			case "+":
				result = ADD;
				break;
			case "-":
				result = SUB;
				break;
			case "*":
				result = PUL;
				break;
			case "/":
				result = DIV;
				break;
			default:
				break;
				
			
			}
			return result;

		}
	} 
	

	
	public static int cal(List<String> ls) {
		//����ջ
		Stack<String> stack = new Stack();
		for(String item : ls) {
			if(item.matches("\\d+")) {   //������ʽ ƥ���λ��
				stack.push(item);
				
			}else {
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(item.equals("+")) {
					res = num1 + num2;
					
				}else if(item.equals("-")) {
					res = num1 - num2;
				}else if(item.equals("*")) {
					res = num1 * num2;
				}else if(item.equals("/")) {
					res = num1 / num2;
				}else {
					throw new RuntimeException("���������\n");
				}
				//ջ����String ��˽�Intת��String
				stack.push(""+res);
			}
		}
		return Integer.parseInt(stack.pop());
	}
	
	public static List<String> getListString(String suffixExpression){
		//���Ƚ�suffixExpression�ÿո���зָ�
		String[] suffix = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String item: suffix) {
			list.add(item);
		}
		return list;
		
	}
}
