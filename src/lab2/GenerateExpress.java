package lab2;

import javax.xml.crypto.Data;

import java.util.Scanner;

import lab2.MyStack;
public class GenerateExpress {
	
	//定义数据属性的一个内部类
	private static class Data {
		public double[] inputData;
		
		public String outputEx ;
		
		public String[] strs;
		
		MyStack<String> operator = new MyStack<String>();
		
		char[] outputExStr;
		
		public Data(){}
		public Data(int a,int b,int c,int d){
			 inputData = new double[]{a,b,c,d};
	         strs = new String[]{a+"",b+"",c+"",d+""};
	         outputEx = a+"";
	         operator = new MyStack<String>();
	         outputExStr = new char[50];
		}
	}
	public static void generate(Data data,int number){
		double[] inputData = data.inputData;
		MyStack<String> operator = data.operator;
		char[] outputExStr = data.outputExStr;
		
		if(inputData.length<=1){
			if(inputData.length==1&&Math.abs(inputData[0]-number)<0.0000001d){
//				 System.out.println(data.outputEx+" = "+number);
				MyStack<String> output = FromPostfixToInfix.doSplit(InfixToPostfix.doSplit(data.outputEx));
//				将结果通过弹窗展示出来
//				MyStack<String> kkk = new MyStack<>();
//				
				System.out.println((FromPostfixToInfix.doSplit(InfixToPostfix.doSplit(data.outputEx)).pop()));
//				 while(!operator.isEmpty()){
//					 System.out.println(operator.pop()+"  ");
//				 }
			}
		}
		
		   for(int i=0,len=inputData.length;i<len-1; i++){
	            for(int j=i+1;j<len;j++){
	                double x=inputData[i];
	                double y=inputData[j];
	                String xs=data.strs[i];
	                String ys=data.strs[j];
	                for(int k=0;k<6;k++){
	                	//改变数组
	                    Data newData=getNewArray(data,i);
	                    switch(k){
	                        case 0:
	                        	newData.inputData[j-1]=x+y;
	                            newData.outputEx=xs+"+"+ys;
//	                            System.out.println("is :"+newData.outputEx);
	                            operator.push("+");
	                        break;
	                        case 1:
	                        	newData.inputData[j-1]=x-y;
	                            newData.outputEx=xs+"-"+ys;
	                            operator.push("-");
	                        break;
	                        case 2:
	                        	newData.inputData[j-1]=y-x;
	                        	newData.outputEx=ys+"-"+xs;
	                        	operator.push("-");
	                        break;
	                        case 3:
//	                        	outputExStr = newData.strs[j-1].toCharArray();
//	                        	for(int p=0;p<outputExStr.length;p++){
//	                        		if(!Character.isDigit(outputExStr[p])){
//	                        			if(getPre(""+outputExStr[p])==1){
//	                        				newData.outputEx = "("+xs+")"+"*"+ys;
//	                        			}
//	                        		}else {
//	                        			newData.outputEx=xs+"*"+ys;
//									}
//	                        	}
	                        	
	                        	if(!operator.isEmpty()&&getPre(operator.top())==1){
	                        		newData.outputEx = "("+xs+")"+"*"+ys;
	                        		operator.pop();
	                        	}else
	                        		newData.outputEx=xs+"*"+ys;
	                        	newData.inputData[j-1]=x*y;
	                            operator.push("*");
	                        break;
	                        case 4:
	                        if(y!=0){
	                        	if(!operator.isEmpty()&&(getPre(operator.top())==1||getPre(operator.top())==3)){
	                        		newData.outputEx = "("+xs+")"+"/"+ys;
	                        		operator.pop();
	                        	}else
	                        		newData.outputEx=xs+"/"+ys;
//	                        	outputExStr = newData.strs[j-1].toCharArray();
//	                        	for(int p=0;p<outputExStr.length;p++){
//	                        		if(!Character.isDigit(outputExStr[p])){
//	                        			if(getPre(""+outputExStr[p])==1){
//	                        				newData.outputEx = "("+xs+")"+"/"+ys;
//	                        			}
//	                        		}else {
//	                        			newData.outputEx=xs+"/"+ys;
//									}
//	                        	}
	                            	newData.inputData[j-1]=x/y;
	                                operator.push("/");
	                        }else {
	                            continue;
	                        }
	                        break;
	                        case 5:
	                        if(x!=0){
//	                        	outputExStr = newData.strs[j-1].toCharArray();
//	                        	for(int p=0;p<outputExStr.length;p++){
//	                        		if(!Character.isDigit(outputExStr[p])){
//	                        			if(getPre(""+outputExStr[p])==1){
//	                        				newData.outputEx = ys+"/"+"("+xs+")";
//	                        			}
//	                        		}else {
//	                        			newData.outputEx=ys+"/"+xs;
//									}
//	                        	}
	                        	if(!operator.isEmpty()&&(getPre(operator.top())==1||getPre(operator.top())==3)){
	                        		newData.outputEx = ys+"/"+"("+xs+")";
	                        		operator.pop();
	                        	}else
	                        		newData.outputEx=ys+"/"+xs;
	                        	
	                            	newData.inputData[j-1]=y/x;
//	                                newData.outputEx=ys+"/"+xs;
	                                operator.push("/");
	                        }else {
	                            continue;
	                        }
	                        break;
	                    }
	                   
//	                    newData.outputEx="("+newData.outputEx+")";
	                    newData.strs[j-1]=newData.outputEx;
	                    generate(newData,number);
	                }
	            }
	        }
	         
	}
	
	public static Data getNewArray(Data data, int i){
		Data newArray = new Data();
		newArray.inputData = new double[data.inputData.length-1];
		newArray.outputEx = data.outputEx;
		newArray.strs = new String[data.strs.length-1];
		for(int m=0,n=0;m<data.inputData.length;m++){
			if(m!=i){
				newArray.inputData[n]= data.inputData[m];
				newArray.strs[n]= data.strs[m];
				n++;
			}
		}
		return newArray;
	}
	public static int getPre (String str){
		int result = 0;
		switch (str) {
		case "+":
		case "-":
			result = 1;
			break;
		case "*":
			result = 2;
			break;
		case "/":
			result = 3;
			break;
		}
		return result; 
	}
	 public static void main(String[] args) throws InterruptedException {
//		    System.out.println("输入一个值：");
//		    Scanner input = new Scanner(System.in);
//		    int number = input.nextInt();
	        long start=System.currentTimeMillis();
	        Data data=new Data(1, 2, 3, 4);
	        generate(data,24);
//	        System.out.println(data.optStr);
	        System.out.println("运行时间是  "+(System.currentTimeMillis()-start));
	    }
}
