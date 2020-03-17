package datacode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
	
	
	
	public static void main(String[] args) {
		//定义一个逆波兰式子，约定用空格隔开
		String suffixEpression = "3 4 + 5 * 6 -";
		List list = getListString(suffixEpression);
		System.out.println("逆波兰式为：\n"+ list);
		int res = cal(list);
		System.out.println("计算结果是：\n" + res );
		
		
	}
	
	public static int cal(List<String> ls) {
		//创建栈
		Stack<String> stack = new Stack();
		for(String item : ls) {
			if(item.matches("\\d+")) {   //正则表达式 匹配多位数
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
					throw new RuntimeException("运算符有误\n");
				}
				//栈内是String 因此将Int转成String
				stack.push(""+res);
			}
		}
		return Integer.parseInt(stack.pop());
	}
	
	public static List<String> getListString(String suffixExpression){
		//首先将suffixExpression用空格进行分割
		String[] suffix = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for(String item: suffix) {
			list.add(item);
		}
		return list;
		
	}

}
