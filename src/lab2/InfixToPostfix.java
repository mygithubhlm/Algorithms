package lab2;
import java.nio.Buffer;

import lab2.MyStack;

import javax.swing.JOptionPane;

public class InfixToPostfix {
	//����stringbuffer���͵ı���buffer��Ϊ���յĽ��
	static StringBuffer buffer = new StringBuffer();
	
	public static void main(String[] args){
		//����һ�����ʽ
		String input = JOptionPane.showInputDialog("Please input your express: ");
		//��ȡ���룬�����в���
		String output = doSplit(input);
		//�����ͨ������չʾ����
		JOptionPane.showMessageDialog(null, output);
	}

	public static String doSplit(String info){
		//��������ַ���ת��Ϊ�ַ������
		char[] theInfo = info.toCharArray();
	
		//�����Լ�д��MyStack����һ�������͵ı��������ڶ�ջ�Ĳ���
		MyStack<Character> opreator = new MyStack<Character>();
		
//		//����stringbuffer���͵ı���buffer��Ϊ���յĽ��
//		StringBuffer buffer = new StringBuffer();
		buffer = new StringBuffer();
		
		for(int i=0;i<theInfo.length;i++){
			char single = theInfo[i];
			//�ж��ǲ�������
			if(Character.isDigit(single)){
				
				/*
				 * ����Ƕ�λ���֣���ѭ������λ���ְ���һ��������������ǣ����һ�����ֵĶ�ȡ������
				 * ������������󳬳�����߽�Ĵ�������Ӧ�ü����ж�iֵ�Ƿ���������±ꡣ
				 * 
				 */
				while(i<theInfo.length&&Character.isDigit(theInfo[i])){
					buffer = buffer.append(theInfo[i++]);
				}
				i--;
				buffer = buffer.append(' ');
			//�ж��ǲ��������
			}else if(isOpreator(single)){
				//����ջ����������������ȼ����ڵ�ǰ����������ȼ���ʱ�򽫶�ջ�е������pop����
				while(!opreator.isEmpty()&&precedence(opreator.top())>=precedence(single)){
					buffer.append(opreator.pop());
					buffer.append(' ');
				}
					opreator.push(single);
				
			//��������ַ�Ϊ������ʱ��ֱ�ӷ����ջ
			}else if(single=='('){
				opreator.push(single);
			//��������ַ�Ϊ������ʱ���������Լ��������������pop����
			}else if(single==')'){
				while(opreator.top()!='('){
					buffer.append(opreator.pop());
					buffer.append(' ');
				}
				//�������˽�������pop����
				opreator.pop();
			}
			
		}
		while(!opreator.isEmpty()){
			buffer.append(opreator.pop());
			buffer.append(' ');
		}
		return buffer.toString()+"\n And the result is "+getResult();
	}
	
	//�ж���������ַ��ǲ��������
	public static boolean isOpreator(char data){
		return data=='+'||data=='-'||data=='*'||data=='/'||data=='^';
	}
	public static boolean isOpreator(String data){
		return data.equals("+")||data.equals("-")||data.equals("*")||data.equals("/")||data.equals("^");
	}
	//��������趨���ȼ�
	public static int precedence(char data){
		int result = 0;
		switch (data) {
		//�Ӽ��������ȼ�Ϊ1
		case '+':
		case '-':
			result = 1;
			break;
		//�˳��������ȼ�Ϊ2
		case '*':
		case '/':
			result = 2;
			break;
		//�˷��������ȼ�Ϊ3
		case '^':
			result = 3;
			break;
		}
		return result;
	}
	
	//��postfix��������
	public static String getResult(){
		//��postfix�з�
		String[] bufferArr = buffer.toString().split(" ");
		//bufferStack ���ڴ�����������
		MyStack<String> bufferStack = new MyStack<String>();
		
		for(int i=0;i<bufferArr.length;i++){
			//��ȡpostfix���Ը������ݽ��в���
			if(isOpreator(bufferArr[i])){
				double re = Calculate.toCalculate(bufferArr[i], bufferStack.pop(),bufferStack.pop());
				bufferStack.push(re+"");
			}else
				bufferStack.push(bufferArr[i]);
		}
		return bufferStack.pop();
//		while(!bufferStack.isEmpty()){
//			if(isOpreator(bufferStack.top())){
//				Calculate.toCalculate(, bufferStack.pop(),bufferStack.pop());
//			}
//			return 0;
//		}
	}
}
