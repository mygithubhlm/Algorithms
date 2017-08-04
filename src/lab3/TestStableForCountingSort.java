package lab3;
/*
 * 此类用于测试所写的countingSort是否为stable
 * 
 */
public class TestStableForCountingSort {
	public static void main(String[] args){
		int[] A = {2,5,3,0,2,3,0,3};
/*
 * 		aString与数组A对应，其中A数组中的两个2在aString中分别用“我”和“们”代替
 * 	aString中的数据下标和A数组中的下标做同样的变动，那么，可以通过打印数的aString
 * 	中“我”和“们”的相对位置是否变化就可以知道A数组是否为stable.
 */
		
//		用于检测的数组
		String[] aString = {"我","5","3","0","们","3","0","3"};
		int[] B = new int[A.length];
		String[] bString = new String[aString.length];
		int k = 0;
		for(int i=0;i<A.length;i++){
			if(k<A[i]){
				k = A[i];
			}
		}
		k++;
		int[] re = countingSort(A, B, aString,bString,k);
		for(int i=0;i<re.length;i++){
			System.out.println(re[i]);
		}
	}
	public static int[] countingSort(int[] A,int[] B,String[] AString,String[] BString,int k){
		int[] C = new int[k];
//		对C初始化
		for(int i=0;i<k;i++){
			C[i] = 0;
		}
//		计算每个元素的个数
		for(int j=0;j<A.length;j++){
			C[A[j]] = C[A[j]]+1; 
		}
//		计算C[i]的位置
		for(int i=1;i<k;i++){
			C[i] = C[i] + C[i-1];
		}
//		处理重复出现数字的情况
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]]-1] = A[j];
			BString[C[A[j]]-1] = AString[j];
			C[A[j]] = C[A[j]]-1;
		}
//		打印出检测数组的内容，看是否为stable（即“我”和“们”的相对位置）
		for (int i = 0; i < BString.length; i++) {
			System.out.print(BString[i]+" , ");
		}
		System.out.println();
		return B;
	}
}
