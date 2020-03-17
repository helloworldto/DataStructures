package datacode;
/*
 * 操作流程
 * 1.通过一个Index(索引)，来遍历我们的表达式
 * 2.如果发现是数字，则直接入数栈
 * 3.如果是字符，分以下情况
 * （1）如果当前的符号栈为空，直接入栈
 * （2）如果符号栈有操作符，进行比较。如果当前的操作符的优先级小于或等于栈中的操作服，就需要从数栈中pop出两个数。从字符栈中
 * pop出一个字符进行运算，并得到结果入数栈，然后将当前的操作符入符号栈
 * 如果当前的操作符的优先级大于栈中的操作符，则直接入符号栈
 * 4.当表达式扫描完毕，就顺序的从数栈和符号栈中pop出相应的数和符号并运行，将结果入数栈
 * 5.最后在数栈中只有一个数字，符号栈为空，就是表达式的结果
 * 目前问题：多位数char需要改进
 */

public class Calculator {
	
	
	static class ArrayStack{
		private int maxSize;
		private int[] stack;
		private int top = -1;
		//创建构造器
		public ArrayStack(int maxSize) {
			this.maxSize = maxSize;
			stack = new int[this.maxSize];
		}
		
		//判断栈满
		public boolean isFull() {
			return top == maxSize - 1;
		}
		
		//栈空
		public boolean isEmpty() {
			return top == -1;
		}
		
		//入栈
		public void push(int value) {
			if(isFull()) {
				System.out.print("栈满\n");
				return;
			}
			top++;
			stack[top] = value;
		}
		
		//出栈
		public int pop() {
			if(isEmpty()) {
				throw new RuntimeException("栈空\n");
			}
			int value = stack[top];
			top--;
			return value;
			
		}
		
		//遍历栈  从top开始显示
		public void list() {
			if(isEmpty()) {
				System.out.print("栈为空");
				return;
			}
			for(int i = top; i >= 0;i--) {
				System.out.printf("stack[%d]的元素值为:%d \n",i,stack[i]);
			}
		}
		
		//表示运算符的优先级，优先级用数字表示，数字越大则优先级越高
		public int priority(int oper) {
			if(oper == '*'||oper =='/')
				return 1;
			else if(oper == '+' || oper =='/')
				return 0;
			else
				return -1;
				
		}
		
		//判断是不是一个运算符
		public boolean isOper(char val) {
			return val == '+'||val =='-'||val =='*'||val=='/';
		}
		
		//计算方法
		public int cal(int num1,int num2,int oper) {
			int res = 0;
			switch(oper) {
			case '+':
				res = num1 + num2;
				break;
			case '-':
				res = num2 - num1;
				break;
			case '*':
				res = num1 * num2;
				break;
			case '/':
				res = num2 / num1;
				break;
			}
			return res;
		}
		
		
		public int peek() {
			return stack[top];
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String expression = "3+6-1";
		ArrayStack numStack = new ArrayStack(10);
		ArrayStack operStack = new ArrayStack(10);
		//定义相关变量
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int res = 0;
		int oper = 0;
		char ch = ' '; //将每次扫描得到的char保存到ch
		while(true) {
			//一次得到expression的每一个字符
			ch = expression.substring(index, index+1).charAt(0);
			//这句话是从expression取出一个字符串并将其转变成字符
			//首先判断是不是运算符
			if(operStack.isOper(ch)) {
				//如果是运算符，判断符号栈中有无元素
				if(!operStack.isEmpty()){
					//如果符号栈不为空
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						//如果优先级低，则取出数栈两个元素，符号栈中的元素进行运算，注意数字的先后顺序
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1,num2,oper);
						numStack.push(res);
						//将操作符送入符号栈
						operStack.push(ch);
						
					}else {
						operStack.push(ch);
					}
				}else {
					//如果符号栈为空，则直接将符号压入符号栈
					operStack.push(ch);
				}
			}else {
				numStack.push(ch-48); //ASCII中数字1 是49
			}
			index++; //索引++ 
			if(index >= expression.length()) {
				break;
			}
		}

		
		while(true) {
			//扫描结束后按序计算
			if(operStack.isEmpty()) {
				break;
			}
			num1 = numStack.pop();
			num2 = numStack.pop();
			oper = operStack.pop();
			res = numStack.cal(num1, num2, oper);
			numStack.push(res);
		}
		
		int res2 = numStack.pop();
		System.out.printf("表达式%s = %d",expression,res2);
	}

}
