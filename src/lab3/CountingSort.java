package lab3;

public class CountingSort {

	public static void main(String[] args){
//		����������
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
//		�������ӡ����
		for(int i=0;i<re.length;i++){
			System.out.println(re[i]);
		}
	}
	public static int[] countingSort(int[] A,int[] B, int k){
		int[] C = new int[k];
//		��C��ʼ��
		for(int i=0;i<k;i++){
			C[i] = 0;
		}
//		����ÿ��Ԫ�صĸ���
		for(int j=0;j<A.length;j++){
			C[A[j]] = C[A[j]]+1; 
		}
//		����C[i]��λ��
		for(int i=1;i<k;i++){
			C[i] = C[i] + C[i-1];
		}
//		�����ظ��������ֵ����
		for(int j=A.length-1;j>=0;j--){
			B[C[A[j]]-1] = A[j];
			C[A[j]] = C[A[j]]-1;
		}
		return B;
	}
}
