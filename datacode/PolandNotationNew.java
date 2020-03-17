package datacode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/*
 * 中缀表达式转后缀表达式（逆波兰表达式）
 * 思路分析
 * （1）初始化两个栈，运算符栈s1和存储中间结果的栈s2；
 * （2）从左到右扫描中缀表达式
 * （3）遇到操作数时，将其压s2
 * （4）遇到运算符时，比较其与s1栈顶运算符的优先级
 * 1.如果s1为空或（ 则直接压入
 * 2.如果优先级比栈顶的高，压入
 * 3.否则将s1栈顶的运算符弹出并压入s2中，再次钻到4.1与s1中新的栈顶比较
 * (5)遇到符号时：
 * 1.左括号(则直接压入s1
 * 2.有符号)则弹出s1栈顶的运算符并压入s2,直到遇到左括号，此时将这一对括号丢弃
 * （6）重复步骤（2）到（5），知道表达式的最右边
 * （7）将s1中剩余的运算符依次弹出并压入s2
 * （8）一次弹出s2中的元素并输出，结果的逆序即为中缀表达式对应的后缀表达式
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
		System.out.printf("最终的结果为：%d",result);
		

	}
	public static List<String> toInfixExpressionList(String s){
		List<String> ls = new ArrayList<String>();
		int i = 0;//这是一个指针，用于遍历中缀表达式字符串
		String str;//对多位数进行拼接
		char c;//每遍历到一个字符就放入到c
		do {
			if((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57 ) {
				ls.add("" + c);
				i++; //i需要后移
			}else {
				//如果时一个数，考虑多位数
				str = "";
				while(i < s.length() && (c = s.charAt(i)) >= 48 && (c=s.charAt(i))<=57) {
					 str += c; //拼接
					 i++;
				}
				ls.add(str);
			}
		}while(i < s.length());
		return ls;
	}
	
	public static List parseSuffExpressionList(List<String> list) {
		//定义两个栈
		Stack<String> s1 = new Stack();
		//因为S2无pop操作，故用list<String>代替
		List<String> s2 = new ArrayList<String>();
		//遍历list
		for(String item:list) {
			if(item.matches("\\d+")) {
				s2.add(item);
			}else if(item.equals("(")) {
				s1.add(item);
			}else if(item.equals(")")){
				while(!s1.peek().equals("(")) {
					s2.add(s1.pop());
				}
				s1.pop();//将小括号弹出
			}else {
				//优先级的问题
				//当s1的栈顶的优先级》item，则弹出s1继续比较直到入栈
				while(s1.size()!= 0 && Operation.getVlue(s1.peek())>=  Operation.getVlue(item)) {
					s2.add(s1.pop());
					
				}
				s1.push(item);
			}
			
		}
		
		
		while(s1.size()!= 0) {
			//此时不需要逆序输出因为是list
			s2.add(s1.pop());
		}
		return s2;
	}
	
	//编写优先级的类
	public static class Operation{
		private static int ADD = 1;
		private static int SUB = 1;
		private static int PUL = 2;
		private static int DIV = 2;
		
		//写方法返回优先级
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
