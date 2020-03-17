package datacode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	
	
	
	public static void main(String[] args) {
		//����һ���沨��ʽ�ӣ�Լ���ÿո����
		String suffixEpression = "3 4 + 5 * 6 -";
		List list = getListString(suffixEpression);
		System.out.println("�沨��ʽΪ��\n"+ list);
		int res = cal(list);
		System.out.println("�������ǣ�\n" + res );
		
		
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
