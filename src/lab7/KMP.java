package lab7;

public class KMP {
//	计算得到pattern的状态表
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
//	进行匹配
	public static void KMP_matcher(String text0,String pattern0){
		char[] text = text0.toCharArray();
		char[] pattern = pattern0.toCharArray();
		int n = text.length;
		int m = pattern.length;
		
		int[] result = compute_prefix_function(pattern);
//		q：number of characters matchered
		int q = 0;
//		scan the text from left to right
		for(int i=0;i<n;i++){
			while(q>0&&pattern[q]!=text[i]){
				q = result[q];
			}
			if(pattern[q]==text[i]){
				q++;
			}
			if(q==m){
				System.out.println("Pattern occurs with shift: "+(i-m+1));
				q = result[m-1];
			}
		}
	}
	public static void main(String[] args){
		String text0 = "abababass";
		String pattern0 = "ab";
		KMP_matcher(text0, pattern0);
	}
}
