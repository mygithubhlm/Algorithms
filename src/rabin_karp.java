

public class rabin_karp {
	public static void rabin_karp_matcher(String text0,String pattern0,int d,int q){
		char[] text = text0.toCharArray();
		char[] pattern = pattern0.toCharArray();
		int n = text.length;
		int m = pattern.length;
		int h = 1;
		
//		计算d^m
		for(int i=0;i<m-1;i++){
			h *= d;
			System.out.println("h:"+h);
		}
		int p=0,t=0;
		
//		对p和t进行初始化
		
		for(int i=0;i<m;i++){
			p = (d*p+pattern[i])%q;
			t = (d*t+text[i])%q;
		}
		System.out.println("p: "+p+"  t:"+t);
//		
		for(int s =0;s<n-m+1;s++){
//			System.out.println("p: "+p+"  t:"+t);
			if(p==t){
				boolean equal = true;
				for(int i=0;i<m;i++){
					if(pattern[i]!=text[s+i]){
						equal = false;
					}
				}
				if(equal==true){
					System.out.println("Pattern occurs with shift "+s);
				}
			}
			if(s<n-m){
				t = (d*(t-(text[s]*h)%q)+text[s+m])%q;
			}
		}
	}
	
	public static void main(String[] args){
		String text0 = "adafffdadashadahdf";
		String pattern0 = "hdf";
		rabin_karp_matcher(text0, pattern0, 10, 13);
	}
}
