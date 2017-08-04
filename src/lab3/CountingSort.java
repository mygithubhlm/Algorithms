package lab3;

public class CountingSort {

	public static void main(String[] args){
//		待排序数组
		int[] A = {2,5,3,0,2,3,0,3};
		int[] B = new int[A.length];
		int k = 0;
		for(int i=0;i<A.length;i++){
			if(k<A[i]){
				k = A[i];
			}
		}
		k++;
		int[] re = countingSort(A, B, k);
//		将结果打印出来
		for(int i=0;i<re.length;i++){
			System.out.println(re[i]);
		}
	}
	public static int[] countingSort(int[] A,int[] B, int k){
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
			C[A[j]] = C[A[j]]-1;
		}
		return B;
	}
}
