package lab2;
import java.nio.Buffer;

import javax.tools.ToolProvider;

import lab2.MyStack;

import javax.swing.JOptionPane;

public class FromPostfixToInfix {
	//����stringbuffer���͵ı���buffer��Ϊ���յĽ��
	static StringBuffer buffer = new StringBuffer();
	static MyStack<String> forOutput = new MyStack<String>();
	public static void main(String[] args){
		//����һ�����ʽ
		String input = JOptionPane.showInputDialog("Please input your express: ");
		//��ȡ���룬�����в���
		MyStack<String> output = doSplit(input);
		//�����ͨ������չʾ����
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
		//��������ַ���ת��Ϊ�ַ������
		String[] theInfo = info.split(" ");
//		for(int i=0;i<theInfo.length;i++){
//			System.out.println(theInfo[i]+"dddd");
//		}
		
		//�����Լ�д��MyStack����һ�������͵ı��������ڶ�ջ�Ĳ���
		MyStack<String> opreator = new MyStack<String>();
		forOutput = new MyStack<String>();
		
//		//����stringbuffer���͵ı���buffer��Ϊ���յĽ��
		buffer = new StringBuffer();
		
		for(int i=0;i<theInfo.length;i++){
			String single = theInfo[i];
			//�ж��ǲ�������
			if(isDigit(single)){
				forOutput.push(single);
			//�ж��ǲ��������
			}else if(isOpreator(single)){
				if(single.equals("*")){
					if(!opreator.isEmpty()&&(precedence(opreator.top())<precedence(single))){
						MyStack<String> temp0 = new MyStack<String>();
//						buffer.append(opreator.pop());
						while(forOutput.size()>=0){
//							����ڽ������ǰ�������߼����������ֹͣpop
							if(forOutput.size()>0&&precedence(forOutput.top())>=2){
								String linshi = new String(); 
//								����temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								�Żؽ����
								linshi = "("+linshi+")"+single+temp0.pop();
								forOutput.push(linshi);
								break;
//								δ�����������ȼ�
							}else if(forOutput.size()==0){
								String linshi = new String(); 
//								����temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								�Żؽ����
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
//							����ڽ������ǰ�������߼����������ֹͣpop
							if(forOutput.size()>0&&precedence(forOutput.top())>=2){
								String linshi = new String(); 
//								����temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								�Żؽ����
								if(linshi.length()>temp0.top().length())
									linshi = "("+linshi+")"+single+temp0.pop();
								else{
									linshi = linshi+single+"("+temp0.pop()+")";
								}
								forOutput.push(linshi);
								break;
//								δ�����������ȼ�
							}else if(forOutput.size()==0){
								
								String linshi = new String(); 
//								����temp0
								while(temp0.size()>1){
									linshi = linshi + temp0.pop();
								}
//								�Żؽ����
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
						//û�и��߼������ʱ
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
				
	
	//�ж���������ַ��ǲ��������
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
	//��������趨���ȼ�
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
