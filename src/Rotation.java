

public class Rotation {
	public static int[] compute_prefix_function(char[] pattern){
		int m = pattern.length;
		int [] result = new int[m];
		result[0]=0;
		int k = 0;
		for(int q=1;q<m;q++){
			while(k>0&&pattern[k]!=pattern[q]){
				k = result[k];
			}
			if (pattern[k]==pattern[q]) {
				k++;
			}
			result[q]=k;
		}
		for (int i = 0; i < result.length; i++) {
			System.out.println("result "+ i +":"+ result[i]);
		}
		return result;
	}
//	判断是否可以通过rotation得到另一个字符串
	public static boolean isRotated(String s1,String s2){
		// TODO Auto-generated method stub
		char[] text = s1.toCharArray();
		char[] pattern = s2.toCharArray();
		int n = text.length;
		int m = pattern.length;
		if(n!=m){
			return false;
		}
		
		int[] result = compute_prefix_function(pattern);
//		q：number of characters matchered
		int q = 0;
//		scan the text from left to right
		int i = 0;
		int num = 0;
//		
		while(num<2*n){
			while(q>0&&pattern[q]!=text[i]){
				q = result[q];
			}
			if(pattern[q]==text[i]){
				q++;
			}
			
			if(q==m){
				return true;
//				System.out.println("Pattern occurs with shift: "+(i-m+1));
//				q = result[m-1];
			}
			num++;
			i++;
			
//			当s1遍历结束时，匹配s1的开头，看是否匹配，但这个过程不会构成循环，最多进行2n次。
			
			if(i>n-1){
//				num=q;
				i=0;
			}
		}
		return false;
	}
	public static void main(String[] args){
		String s1 = "abababaca";
		String s2 = "aabababac";
		System.out.println(isRotated(s1, s2));
	}
}
