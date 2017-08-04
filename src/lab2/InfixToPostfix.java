package lab2;
import java.nio.Buffer;

import lab2.MyStack;

import javax.swing.JOptionPane;

public class InfixToPostfix {
	//声明stringbuffer类型的变量buffer作为最终的结果
	static StringBuffer buffer = new StringBuffer();
	
	public static void main(String[] args){
		//输入一个表达式
		String input = JOptionPane.showInputDialog("Please input your express: ");
		//获取输入，并进行操作
		String output = doSplit(input);
		//将结果通过弹窗展示出来
		JOptionPane.showMessageDialog(null, output);
	}

	public static String doSplit(String info){
		//将输入的字符串转换为字符的组合
		char[] theInfo = info.toCharArray();
	
		//利用自己写的MyStack建立一个此类型的变量以用于堆栈的操作
		MyStack<Character> opreator = new MyStack<Character>();
		
//		//声明stringbuffer类型的变量buffer作为最终的结果
//		StringBuffer buffer = new StringBuffer();
		buffer = new StringBuffer();
		
		for(int i=0;i<theInfo.length;i++){
			char single = theInfo[i];
			//判断是不是数字
			if(Character.isDigit(single)){
				
				/*
				 * 如果是多位数字，此循环将多位数字按照一个整体输出，但是，最后一个数字的读取过程中
				 * 会出现自增过后超出数组边界的错误，所以应该加上判断i值是否大于数组下标。
				 * 
				 */
				while(i<theInfo.length&&Character.isDigit(theInfo[i])){
					buffer = buffer.append(theInfo[i++]);
				}
				i--;
				buffer = buffer.append(' ');
			//判断是不是运算符
			}else if(isOpreator(single)){
				//当堆栈中有运算符并且优先级大于当前运算符的优先级的时候将堆栈中的运算符pop出来
				while(!opreator.isEmpty()&&precedence(opreator.top())>=precedence(single)){
					buffer.append(opreator.pop());
					buffer.append(' ');
				}
					opreator.push(single);
				
			//当输入的字符为左括号时，直接放入堆栈
			}else if(single=='('){
				opreator.push(single);
			//当输入的字符为右括号时，将括号以及括号里面的内容pop出来
			}else if(single==')'){
				while(opreator.top()!='('){
					buffer.append(opreator.pop());
					buffer.append(' ');
				}
				//不能忘了将左括号pop出来
				opreator.pop();
			}
			
		}
		while(!opreator.isEmpty()){
			buffer.append(opreator.pop());
			buffer.append(' ');
		}
		return buffer.toString()+"\n And the result is "+getResult();
	}
	
	//判断所输入的字符是不是运算符
	public static boolean isOpreator(char data){
		return data=='+'||data=='-'||data=='*'||data=='/'||data=='^';
	}
	public static boolean isOpreator(String data){
		return data.equals("+")||data.equals("-")||data.equals("*")||data.equals("/")||data.equals("^");
	}
	//给运算符设定优先级
	public static int precedence(char data){
		int result = 0;
		switch (data) {
		//加减运算优先级为1
		case '+':
		case '-':
			result = 1;
			break;
		//乘除运算优先级为2
		case '*':
		case '/':
			result = 2;
			break;
		//乘方运算优先级为3
		case '^':
			result = 3;
			break;
		}
		return result;
	}
	
	//对postfix进行运算
	public static String getResult(){
		//将postfix切分
		String[] bufferArr = buffer.toString().split(" ");
		//bufferStack 用于存入运算数据
		MyStack<String> bufferStack = new MyStack<String>();
		
		for(int i=0;i<bufferArr.length;i++){
			//读取postfix并对各项数据进行操作
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
