package lab3;

public class QuickSort {

	public static void  main(String[] args){
		int[] A = {2,8,7,1,3,5,6,4};
		int[] newA = quickSort(A, 0, A.length);
//		�������������ӡ����
		for (int i = 0; i < newA.length; i++) {
			System.out.println(newA[i]);
		}
	}
	
	
	public static int[] quickSort(int[] A, int p , int r){
		if (p<r){
			int q = partition(A, p ,r);
//			�ݹ����quickSort
			quickSort(A, p, q);
			quickSort(A, q+1, r);
		}
		return A;
	}
	
//	partition ���̽�һ�������黮��Ϊ������
	public static int partition(int[] A, int p, int r){
		int x = A[r-1];
		int i = p-1;
		for(int j=p; j<r-1; j++){
			if(A[j]<=x){
//				����A[i]��A[j]��ֵ
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
			}
		}
//		����A[i+1]��A[r]��ֵ
		int temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
		return i+1;
	}
}
