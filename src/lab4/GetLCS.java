package lab4;

import java.util.Stack;

public class GetLCS {
	
//	该处两个堆栈用于存放公共子元素分别所在的两个word中的位置信息
	static Stack<Integer> re1 = new Stack<Integer>();
	static Stack<Integer> re2 = new Stack<Integer>();
	public static void main(String[] args) {  
		String word1 = "abcbdab";
		String word2 = "bdcaba";
//		调用此函数得到存放信息的最长子串信息的b
        String[][] b = LCS_Length(word1,word2); 
        int m = word1.length();
        int n = word2.length();
        int option = 0;
//        调用此函数用于得到re1和re2的信息
        minDistance(b, m, n);
        
//        下面的操作计算由word1转化为word2的步数
        if(m-re1.get(0)>=n-re2.get(0)){
        	option+=m-re1.get(0);
        }else {
			option+=n-re2.get(0);
		}
        for(int i=0;i<re1.size()-1;i++){
        	if((re1.get(i)-re1.get(i+1))>=(re2.get(i)-re2.get(i+1))){
        		option+=re1.get(i)-re1.get(i+1)-1;
        	}else {
				option+=re2.get(i)-re2.get(i+1)-1;
			}
        }
        if(re1.peek()>=re2.peek()){
        	option+=re1.peek()-1;
        }else {
			option+=re2.peek()-1;
		}
        System.out.println(option);
	} 
//	按照课本伪代码写成的找最长公共子串的方法
	public static String[][] LCS_Length(String XStr,String YStr){  
        char[] X = XStr.toCharArray();
        char[] Y = YStr.toCharArray();
        int xlen = X.length;  
        int ylen = Y.length;  
           
        String b[][] = new String[xlen+1][ylen+1];  
        int c[][] = new int[xlen+1][ylen+1];  
        for(int i=0;i<xlen+1;i++){  
            c[i][0] = 0;  
        }  
        for(int i=0;i<ylen+1;i++){  
            c[0][i] = 0;  
        }  
           
        for(int i=1;i<xlen+1;i++){//bottom to top  
            for(int j=1;j<ylen+1;j++){  
                if(X[i-1]==Y[j-1]){  
                    c[i][j] = c[i-1][j-1]+1;  
                    b[i][j] ="leftUp";  
                }else if(c[i-1][j] >= c[i][j-1]){  
                    c[i][j] = c[i-1][j];  
                    b[i][j] = "up";  
                }else{  
                    c[i][j] = c[i][j-1];  
                    b[i][j] = "left";  
                }  
                   
            }  
        } 
        return b;
	}
	
//	根据b得到re1和re2的信息的函数
	public static void minDistance(String[][] b,int x,int y){
		// TODO Auto-generated method stub
		if(b[x][y]==null)
			return;
		if(b[x][y].equals("leftUp")){
			re1.push(x);
			re2.push(y);
			minDistance(b, x-1, y-1);
		}else if(b[x][y].equals("up")){
			minDistance(b, x-1, y);
		}else {
			minDistance(b, x, y-1);
		}
	}
	
}
