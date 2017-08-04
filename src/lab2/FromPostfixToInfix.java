package lab2;
import java.nio.Buffer;

import javax.tools.ToolProvider;

import lab2.MyStack;

import javax.swing.JOptionPane;

public class FromPostfixToInfix {
	//声明stringbuffer类型的变量buffer作为最终的结果
	static StringBuffer buffer = new StringBuffer();
	static MyStack<String> forOutput = new MyStack<String>();
	public static void main(String[] args){
		//输入一个表达式
		String input = JOptionPane.showInputDialog("Please input your express: ");
		//获取输入，并进行操作
		MyStack<String> output = doSplit(input);
		//将结果通过弹窗展示出来
//		JOptionPane.showMessageDialog(null, );
		MyStack<String> kkk = new MyStack<>();
		while(!output.isEmpty()){
			kkk.push(output.pop());	
		}
		while(!kkk.isEmpty()){
			System.out.print(kkk.pop());	
		}
		
	}

	public static MyStack<String> doSplit(String info){
		//将输入的字符串转换为字符的组合
		String[] theInfo = info.split(" ");
//		for(int i=0;i<theInfo.length;i++){
//			System.out.println(theInfo[i]+"dddd");
//		}
		
		//利用自己写的MyStack建立一个此类型的变量以用于堆栈的操作
		MyStack<String> opreator = new MyStack<String>();
		forOutput = new MyStack<String>();
		
//		//声明stringbuffer类型的变量buffer作为最终的结果
		buffer = new StringBuffer();
		
		for(int i=0;i<theInfo.length;i++){
			String single = theInfo[i];
			//判断是不是数字
			if(isDigit(single)){
				forOutput.push(single);
			//判断是不是运算符
			}else if(isOpreator(single)){
				if(single.equals("*")){
					if(!opreator.isEmpty()&&(precedence(opreator.top())<precedence(single))){
						MyStack<String> temp0 = new MyStack<String>();
//						buffer.append(opreator.pop());
						while(forOutput.size()>=0){
//							如果在结果集的前方遇到高级运算符，则停止pop
							if(forOutput.size()>0&&precedence(forOutput.top())>=2){
								String linshi = new String(); 
//								放入temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								放回结果集
								linshi = "("+linshi+")"+single+temp0.pop();
								forOutput.push(linshi);
								break;
//								未遇到更高优先级
							}else if(forOutput.size()==0){
								String linshi = new String(); 
//								放入temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								放回结果集
								linshi = "("+linshi+")"+single+temp0.pop();
								forOutput.push(linshi);
								break;
							}
							temp0.push(forOutput.pop());
						}
					}else {
						String aa = forOutput.pop();
						String bb = forOutput.pop();
						String linshi = new String();
						linshi = bb + single + aa;
						forOutput.push(linshi);
					}
					
				}else if(single.equals("/")) {
					if(!opreator.isEmpty()&&(precedence(opreator.top())<precedence(single))){
						MyStack<String> temp0 = new MyStack<String>();
//						buffer.append(opreator.pop());
						while(forOutput.size()>=0){
//							如果在结果集的前方遇到高级运算符，则停止pop
							if(forOutput.size()>0&&precedence(forOutput.top())>=2){
								String linshi = new String(); 
//								放入temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								放回结果集
								if(linshi.length()>temp0.top().length())
									linshi = "("+linshi+")"+single+temp0.pop();
								else{
									linshi = linshi+single+"("+temp0.pop()+")";
								}
								forOutput.push(linshi);
								break;
//								未遇到更高优先级
							}else if(forOutput.size()==0){
								
								String linshi = new String(); 
//								放入temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								放回结果集
								if(linshi.length()>temp0.top().length())
									linshi = "("+linshi+")"+single+temp0.pop();
								else{
									linshi = linshi+single+"("+temp0.pop()+")";
								}
								forOutput.push(linshi);
								break;
								
//								forOutput.push("(");
//								while(!temp0.isEmpty()){
//									forOutput.push(temp0.pop());
//								}
////								if(forOutput.top().equals(""))
//								String cString = forOutput.pop();
//								forOutput.push(")");
//								forOutput.push(cString);
////								forOutput.push(single);
//								break;
								
								
							}
							temp0.push(forOutput.pop());
						}
						//没有更高级运算符时
//					}else if() {
						
					}else {
						String aa = forOutput.pop();
						String bb = forOutput.pop();
						String linshi = new String();
						linshi = "("+bb + single + aa+")";
						forOutput.push(linshi);
					}
				}else if(precedence(single)==1){
					String aa = forOutput.pop();
					String bb = forOutput.pop();
					String linshi = new String();
					linshi = bb + single + aa;
					forOutput.push(linshi);
				}
				opreator.push(single);
			}//
		}
		return forOutput;
	}	
				
	
	//判断所输入的字符是不是运算符
	public static boolean isOpreator(char data){
		return data=='+'||data=='-'||data=='*'||data=='/'||data=='^';
	}
	public static boolean isOpreator(String data){
		return data.equals("+")||data.equals("-")||data.equals("*")||data.equals("/")||data.equals("^");
	}
	public static boolean isDigit(String shu){
		char[] pp = shu.toCharArray();
		boolean is = true;
		for(int i=0;i<pp.length;i++){
			if(!Character.isDigit(pp[i]))
				is=false;
		}
		return is;
	}
	//给运算符设定优先级
	public static int precedence(String ddd){
		String shuju = ddd;
		if(ddd.equals(null)){}
		int result = 0;
		if(shuju.equals("+")||shuju.equals("-")){
			result = 1;
		}else if(shuju.equals("*")){
			result = 2;
		}else if(shuju.equals("/")){
			result = 2;
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
