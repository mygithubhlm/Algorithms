package lab3;

public class TestStableForQuickSort {

	public static void  main(String[] args){
		int[] A = {2,8,7,1,3,5,6,4,4};
		
		/*
		 * 		aString������A��Ӧ������A�����е�����2��AString�зֱ��á��ҡ��͡��ǡ�����
		 * 	aString�е������±��A�����е��±���ͬ���ı䶯����ô������ͨ����ӡ����AString
		 * 	�С��ҡ��͡��ǡ������λ���Ƿ�仯�Ϳ���֪��A�����Ƿ�Ϊstable.
		 */
				
//				���ڼ�������
		String[] AString = {"2","8","7","1","3","5","6","��","��"};
		int[] newA = quickSort(A, AString,0, A.length);
		for (int i = 0; i < newA.length; i++) {
			System.out.println(newA[i]);
		}
	}
	
	public static int[] quickSort(int[] A, String[] aStrings,int p , int r){
		if (p<r){
			int q = partition(A,aStrings, p ,r);
			quickSort(A,aStrings, p, q);
			quickSort(A,aStrings, q+1, r);
		}
		return A;
	}
	
//	partition ���̽�һ�������黮��Ϊ������
	public static int partition(int[] A,String[] aStrings, int p, int r){
		int x = A[r-1];
		int i = p-1;
		for(int j=p; j<r-1; j++){
			if(A[j]<=x){
//				����A[i]��A[j]��ֵ
				i = i + 1;
				int temp = A[i];
				A[i] = A[j];
				A[j] = temp;
//				����aStrings[i]�� aString[j]��ֵ
				String temp2 = aStrings[i];
				aStrings[i] = aStrings[j];
				aStrings[j] = temp2;
			}
		}
//		����A[i+1]��A[r]��ֵ
		int temp = A[i+1];
		A[i+1] = A[r-1];
		A[r-1] = temp;
//		����aStrings[i+1]��aStrings[r]��ֵ
		String temp2 = aStrings[i+1];
		aStrings[i+1] = aStrings[r-1];
		aStrings[r-1] = temp2;
		
		for (int d = 0; d< aStrings.length; d++) {
			System.out.print(aStrings[d]+" , ");
		}
		System.out.println();
		return i+1;
	}
}
