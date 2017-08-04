package lab7;

public class Rabin_Karp {
	public static void rabin_karp_matcher(char[][] text,char[][] pattern,int d,int q){
//		text的行数
		int nh = text.length;
//		text的列数
		int nl = text[0].length;
//		pattern的行数
		int mh = pattern.length;
//		pattern的列数
		int ml = pattern[0].length;
		
		int h = 1;
		
//		计算d^m-1
		for(int i=0;i<ml-1;i++){
			h *= d;
			System.out.println("h:"+h);
		}
		int p=0,t=0;
		
//		对p进行初始化
		p = calcuNum(pattern,mh,ml,d,q);
//		t = calcuNum(text,mh,ml,d,q);
//		for(int i=0;i<m;i++){
//			p = (d*p+pattern[i])%q;
//			t = (d*t+text[i])%q;
//		}
//		System.out.println("p: "+p+"  t:"+t);
//		
		for(int k =0;k<nh-mh+1;k++){
//		       在第一列时更新t的值
			if (k<nh-mh+1) {
				t = calcuTextNum(text, k, k+mh, 0, ml, d, q);
			}
//			System.out.println("jihao");
			for(int s=0;s<nl-ml+1;s++){
//			System.out.println("p: "+p+"  t:"+t);
//				System.out.println("p: "+p+"  t:"+t);
				if(p==t){
//					System.out.println("jinlaila");
					boolean equal = true;
					for(int i=0;i<mh;i++){
						for(int j=0;j<ml;j++){
							if(pattern[i][j]!=text[k+i][s+j]){
								equal = false;
							}
						}
					}
					if(equal==true){
						System.out.println("Pattern occurs with shift text["+k+"]["+s+"]");
					}
				}
//			    向右平移一个单位
				if (s<nl-ml) {
					int lnum = 0;
					int newLnum = 0;
					for(int a=0;a<mh;a++){
//						System.out.println("text["+(k+a)+"]["+s+"]："+text[k+a][s]);
						lnum += text[k+a][s];
					}
					for (int b = 0; b < mh; b++) {
						newLnum += text[k+b][s+ml];
					}
//					System.out.println("lnum:"+lnum+"  newLnum:"+newLnum);
					t = (d*(t-(lnum*h))+newLnum);
				}
			}
		}
	}
	
	
	public static int calcuNum(char[][] input,int h,int l,int d,int q){
		int re0 = 0;
		int re = 0;
		for(int i=0;i<h;i++){
			for(int j=0;j<l;j++){
				re0 = re0*d + input[i][j];
			}
			re = re + re0;
			re0 = 0;
		}
		return re;
	}
	
//	计算给定范围内的二维矩阵的和
	public static int calcuTextNum(char[][] input,int hfrom,int hto,int lfrom, int lto,int d,int q){
		int re0 = 0;
		int re = 0;
		for(int i=hfrom;i<hto;i++){
			for(int j=lfrom;j<lto;j++){
//				System.out.println("input:"+input[i][j]);
				re0 = re0*d + input[i][j];
			}
			re = re + re0;
			re0 = 0;
		}
		
		return re;
	}
	
	
	public static void main(String[] args){
		char[][] text = {
				{'a','b','d','e','f'},
				{'b','a','c','f','g'},
				{'b','y','j','j','k'},
		};
		char[][] pattern = {
				{'c','f','g'},
				
		};
		rabin_karp_matcher(text, pattern, 10, 133);
	}
}
