package datacode;
/*
 * ��������
 * 1.ͨ��һ��Index(����)�����������ǵı��ʽ
 * 2.������������֣���ֱ������ջ
 * 3.������ַ������������
 * ��1�������ǰ�ķ���ջΪ�գ�ֱ����ջ
 * ��2���������ջ�в����������бȽϡ������ǰ�Ĳ����������ȼ�С�ڻ����ջ�еĲ�����������Ҫ����ջ��pop�������������ַ�ջ��
 * pop��һ���ַ��������㣬���õ��������ջ��Ȼ�󽫵�ǰ�Ĳ����������ջ
 * �����ǰ�Ĳ����������ȼ�����ջ�еĲ���������ֱ�������ջ
 * 4.�����ʽɨ����ϣ���˳��Ĵ���ջ�ͷ���ջ��pop����Ӧ�����ͷ��Ų����У����������ջ
 * 5.�������ջ��ֻ��һ�����֣�����ջΪ�գ����Ǳ��ʽ�Ľ��
 * Ŀǰ���⣺��λ��char��Ҫ�Ľ�
 */

public class Calculator {
	
	
	static class ArrayStack{
		private int maxSize;
		private int[] stack;
		private int top = -1;
		//����������
		public ArrayStack(int maxSize) {
			this.maxSize = maxSize;
			stack = new int[this.maxSize];
		}
		
		//�ж�ջ��
		public boolean isFull() {
			return top == maxSize - 1;
		}
		
		//ջ��
		public boolean isEmpty() {
			return top == -1;
		}
		
		//��ջ
		public void push(int value) {
			if(isFull()) {
				System.out.print("ջ��\n");
				return;
			}
			top++;
			stack[top] = value;
		}
		
		//��ջ
		public int pop() {
			if(isEmpty()) {
				throw new RuntimeException("ջ��\n");
			}
			int value = stack[top];
			top--;
			return value;
			
		}
		
		//����ջ  ��top��ʼ��ʾ
		public void list() {
			if(isEmpty()) {
				System.out.print("ջΪ��");
				return;
			}
			for(int i = top; i >= 0;i--) {
				System.out.printf("stack[%d]��Ԫ��ֵΪ:%d \n",i,stack[i]);
			}
		}
		
		//��ʾ����������ȼ������ȼ������ֱ�ʾ������Խ�������ȼ�Խ��
		public int priority(int oper) {
			if(oper == '*'||oper =='/')
				return 1;
			else if(oper == '+' || oper =='/')
				return 0;
			else
				return -1;
				
		}
		
		//�ж��ǲ���һ�������
		public boolean isOper(char val) {
			return val == '+'||val =='-'||val =='*'||val=='/';
		}
		
		//���㷽��
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
		//������ر���
		int index = 0;
		int num1 = 0;
		int num2 = 0;
		int res = 0;
		int oper = 0;
		char ch = ' '; //��ÿ��ɨ��õ���char���浽ch
		while(true) {
			//һ�εõ�expression��ÿһ���ַ�
			ch = expression.substring(index, index+1).charAt(0);
			//��仰�Ǵ�expressionȡ��һ���ַ���������ת����ַ�
			//�����ж��ǲ��������
			if(operStack.isOper(ch)) {
				//�������������жϷ���ջ������Ԫ��
				if(!operStack.isEmpty()){
					//�������ջ��Ϊ��
					if(operStack.priority(ch) <= operStack.priority(operStack.peek())) {
						//������ȼ��ͣ���ȡ����ջ����Ԫ�أ�����ջ�е�Ԫ�ؽ������㣬ע�����ֵ��Ⱥ�˳��
						num1 = numStack.pop();
						num2 = numStack.pop();
						oper = operStack.pop();
						res = numStack.cal(num1,num2,oper);
						numStack.push(res);
						//���������������ջ
						operStack.push(ch);
						
					}else {
						operStack.push(ch);
					}
				}else {
					//�������ջΪ�գ���ֱ�ӽ�����ѹ�����ջ
					operStack.push(ch);
				}
			}else {
				numStack.push(ch-48); //ASCII������1 ��49
			}
			index++; //����++ 
			if(index >= expression.length()) {
				break;
			}
		}

		
		while(true) {
			//ɨ������������
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
		System.out.printf("���ʽ%s = %d",expression,res2);
	}

}
